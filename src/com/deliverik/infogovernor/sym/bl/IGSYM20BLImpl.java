/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.sym.bl.task.MSGFILTERBL;
import com.deliverik.infogovernor.sym.dto.IGSYM20DTO;
import com.deliverik.infogovernor.sym.form.IGSYM1803Form;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
 * ����: ��ҳ�����߼�ʵ�� ������������ҳ�����߼�ʵ�� ������¼����ѧ־ 2012/11/14 �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class IGSYM20BLImpl extends BaseBLImpl implements IGSYM20BL {

	static Log log = LogFactory.getLog(IGSYM19BLImpl.class);
	private MSGFILTERBL msgfilterbl;

	public void setMsgfilterbl(MSGFILTERBL msgfilterbl) {
		this.msgfilterbl = msgfilterbl;
	}

	// ����������ѯ
	public IGSYM20DTO searchIPInfoAction(IGSYM20DTO dto) throws BLException {
		List<MSGFILTERInfo> ipInfoList = new ArrayList<MSGFILTERInfo>();
		IGSYM1803Form igsym1803form = dto.getIgsym1803form();
		int totalCount = 0;
		totalCount = msgfilterbl.getSearchCount(igsym1803form);
		if (totalCount == 0) {
			log.debug("========��Ϣ��ѯ���ݲ�����========");
			// �ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��Ϣ��ѯ���ݼ�������========");
			// �ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		pDto.setTotalCount(totalCount);
		ipInfoList = msgfilterbl.searchMSGFILTER(igsym1803form,
				pDto.getFromCount(), pDto.getPageDispCount());
		dto.setIpInfoList(ipInfoList);
		return dto;
	}

	// �������Ƿ�Ϊ��
	public boolean checkSearchCount(IGSYM20DTO dto) {
		boolean flag = true;
		IGSYM1803Form igsym1803form = dto.getIgsym1803form();
		if (msgfilterbl.getSearchCount(igsym1803form) != 0) {
			return flag;
		} else {
			return false;
		}

	}

	// ����ʵ����ɾ��
	public void deleteTB(MSGFILTERInfo msgfilterinfo) throws BLException {

		msgfilterbl.deleteMSGFILTER(msgfilterinfo);

	}

	// ��������ɾ��
	public void deleteByPK(IGSYM20DTO dto) throws BLException {
		IGSYM1803Form form = dto.getIgsym1803form();
		for (Integer ruletempid : form.getIds()) {
			msgfilterbl.deleteMSGFILTERByPK(ruletempid);
		}
	}

	// �Ǽ�
	public IGSYM20DTO insertInfo(IGSYM20DTO dto) throws BLException {

		msgfilterbl.registMSGFILTER(dto.getIgsym1803form());

		return dto;

	}

	// �޸�
	public IGSYM20DTO updateInfo(IGSYM20DTO dto) throws BLException {

		msgfilterbl.updateMSGFILTER(dto.getMsgfilterinfo());

		return dto;
	}

	// ״̬λ
	public IGSYM20DTO changeTempstate(IGSYM20DTO dto) throws BLException {
		log.debug("========���Ĺ���״̬����ʼ========");

		// ȡ��form
		IGSYM1803Form form = dto.getIgsym1803form();
		// �����������ģ��ʵ
		MSGFILTERInfo info = msgfilterbl.searchMSGFILTERByPK(form.getId());
		MSGFILTERTB msgfilterTB = (MSGFILTERTB) SerializationUtils.clone(info);

		// �ж�ģ��֮ǰ��״̬
		if ("0".equals(form.getState())) {
			msgfilterTB.setState("1");
		} else if ("1".equals(form.getState())) {
			msgfilterTB.setState("0");

			// �޸�ģ��״̬
		}
		msgfilterbl.updateMSGFILTER(msgfilterTB);

		return dto;
	}

}
