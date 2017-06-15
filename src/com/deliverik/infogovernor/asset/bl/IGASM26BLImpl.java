/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
/**
 * 
 */
package com.deliverik.infogovernor.asset.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.asset.bl.task.IG342BL;
import com.deliverik.infogovernor.asset.dto.IGASM26DTO;
import com.deliverik.infogovernor.asset.model.IG342Info;
import com.deliverik.infogovernor.asset.model.condition.IG342SearchCondImpl;

/**
 * @author Administrator
 *
 */
/**
 * ����: ��������Դ��ͳ��ҵ���߼��ӿ�ʵ��
 * ������������������Դ��ͳ��ҵ���߼��ӿ�ʵ��
 * �����ˣ�����
 * ������¼�� 2012-8-3
 * �޸ļ�¼��
 */
public class IGASM26BLImpl extends BaseBLImpl implements IGASM26BL {

	static Log log = LogFactory.getLog(IGASM26BLImpl.class);
	
	/** ��������Դ��ͳ��BL*/
	private IG342BL ig342BL;
	
    /**
     * ��������Դ��ͳ��BL�趨
     *
     * @param ig342bl ig342BL
     */
    public void setIg342BL(IG342BL ig342bl) {
        ig342BL = ig342bl;
    }

    /**
	 * ��������Դ��ͳ�ƴ���
	 *
	 * @param dto IGASM22DTO
	 * @return IGASM22DTO
	 */
	public IGASM26DTO searchEntityItemRelationVW(IGASM26DTO dto)
			throws BLException {
		log.debug("========��������Դ��ͳ�ƴ���ʼ========");
		//����������ѯ����	
		IG342SearchCondImpl cond = new IG342SearchCondImpl();	
		//���ò�ѯ����	
		cond.setBeginTime_q(dto.getIgasm2601Form().getBeginTime_q());//�����¼��ʼʱ��	
		cond.setEndTime_q(dto.getIgasm2601Form().getEndTime_q());//�����¼��ֹʱ��	
		int totalCount = ig342BL.getSearchCount(cond);
		//��ѯ���ݲ�����
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		// ����ѯ����������������ܲ�ѯ�����ֵʱ��ҳ����ʾ��ѯ���ݼ�������
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			//��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		List<IG342Info> entityItemAndConfigItemVWInfoList = ig342BL.searchIG342(cond,  pDto
				.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setEntityItemAndConfigItemVWInfoList(entityItemAndConfigItemVWInfoList);
		log.debug("========��������Դ��ͳ�ƴ������========");
		return dto;
	}


}
