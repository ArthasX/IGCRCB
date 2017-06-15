/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.soc.alarm.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.infogovernor.soc.alarm.bl.task.CRM01BL;
import com.deliverik.infogovernor.soc.alarm.dto.IGALM07DTO;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;
import com.deliverik.infogovernor.soc.alarm.model.condition.CRM10SearchCond;


/**
 * ���ܸ澯��Ϣ��ѯ�߼�ʵ��
 *
 */
public class IGALM07BLImpl extends BaseBLImpl implements IGALM07BL {
	
	static Log log = LogFactory.getLog(IGALM07BLImpl.class);
	
	
	
	protected CRM01BL crm01BL;
	
	
	
	public void setCrm01BL(CRM01BL crm01BL) {
		this.crm01BL = crm01BL;
	}

	

	public IGALM07DTO searchALM0501VWAction(IGALM07DTO dto) throws BLException {
		//��ѯ����
		int totalCount =0;
		if(!dto.getCrm10SearchCond().getTablename().equals(""))
			totalCount = crm01BL.getSearchCount(dto.getCrm10SearchCond());
		if(totalCount==0){
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		log.debug(dto.getMaxSearchCount());
//		if (totalCount > dto.getMaxSearchCount()) {
//			log.debug("========��ѯ���ݼ�������========");
//			//��ѯ���ݼ�������
//			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
//			return dto;
//		}
		
		//����DAO�ӿڲ�ѯ ������־
		List<CRMVW01Info> crm10InfoList = null;
		if(dto.getCrm10SearchCond().getTablename().equals(""))
			crm10InfoList = new ArrayList<CRMVW01Info>();
		else
			crm10InfoList = crm01BL.searchCRM01VWInfoList(dto.getCrm10SearchCond(), pDto.getFromCount(),
				pDto.getPageDispCount());
		
		pDto.setPageDispCount(12);
		pDto.setTotalCount(totalCount);
		dto.setIgalm0501VWList(crm10InfoList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		return dto;
	}

	public IGALM07DTO getRefreshRate(IGALM07DTO dto) throws BLException {
		return crm01BL.getRefreshRate(dto);
	}
	
	public String searchTable(final CRM10SearchCond cond){
		return crm01BL.searchTable(cond);
	}
}
