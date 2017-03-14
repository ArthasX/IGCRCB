/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.workflow.prr.bl.task.IG483BL;
import com.deliverik.infogovernor.prr.dto.IGPRR05DTO;

/**
 * ����: ������BL
 * ��������: ������BL
 * ������¼: 2015/02/03
 * �޸ļ�¼: 
 */
public class IGPRR05BLImpl extends BaseBLImpl implements IGPRR05BL {
	
	/** ��־����ȡ�� */
	private static Log log = LogFactory.getLog(IGPRR05BLImpl.class);
	
	/** ������ʵ��BL */
	protected IG483BL ig483BL;

	/**
	 * ������ʵ��BL�趨
	 * @param ig483BL ������ʵ��BL
	 */
	public void setIg483BL(IG483BL ig483BL) {
		this.ig483BL = ig483BL;
	}

	/**
	 * �������ѯ
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchGroupAction(IGPRR05DTO dto) throws BLException{
		log.debug("============�������ѯ����ʼ============");
		// ��ѯ��¼����
		int totalCount = ig483BL.getSearchCount(dto.getIg483SearchCond());
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		// ��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		pDto.setTotalCount(totalCount);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		dto.setLst_IG483Info(this.ig483BL.searchIG483(dto.getIg483SearchCond(), pDto.getFromCount(), pDto.getPageDispCount()));
		log.debug("============�������ѯ�������============");
		return dto;
	}
	
	/**
	 * �������ѯ
	 * @param dto IGPRR05DTO
	 * @return IGPRR05DTO
	 * @throws BLException
	 */
	public IGPRR05DTO searchProcessAction(IGPRR05DTO dto) throws BLException{
		log.debug("============�������Ա��ѯ����ʼ============");
		dto.setLst_IG500Info(this.ig483BL.searchProcess(dto.getPgrid()));
		log.debug("============�������Ա��ѯ�������============");
		return dto;
	}
}
