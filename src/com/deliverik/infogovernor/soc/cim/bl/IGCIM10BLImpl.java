package com.deliverik.infogovernor.soc.cim.bl;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.infogovernor.soc.cim.dto.IGCIM10DTO;

/**
 * ��ռ䷥ֵ�趨ҵ���߼�ʵ��
 *
 */
public class IGCIM10BLImpl extends BaseBLImpl implements IGCIM10BL {

	static Log log = LogFactory.getLog(IGCIM10BLImpl.class);
	
	/** ��������ϢBL */
	protected SOC0118BL soc0118BL;
	
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}

	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	public IGCIM10DTO searchCutItemAction(IGCIM10DTO dto) throws BLException {
		log.debug("========��ռ䷥ֵ�趨��ѯ����ʼ========");
		//Ӧ����Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0118BL.searchCutItemCount(dto.getSoc0437SearchCond());
		if (totalCount == 0) {
			log.debug("========��ռ䷥ֵ�趨��ѯ���ݲ�����========");
			//��ռ䷥ֵ�趨��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========��ռ䷥ֵ�趨��ѯ���ݼ�������========");
			//��ռ䷥ֵ�趨��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		pDto.setTotalCount(totalCount);
		//��ǰҳ��ռ䷥ֵ�趨ȡ��
		List<SOC0437Info> soc0437InfoList = this.soc0118BL.searchCutItem(dto.getSoc0437SearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		
		dto.setSoc0437InfoList(soc0437InfoList);
		log.debug("========��ռ䷥ֵ�趨��ѯ��������========");
		return dto;
		
	}

	public IGCIM10DTO updateCutValueAction(IGCIM10DTO dto) throws BLException {
		log.debug("========��ռ䷥ֵ�趨��ѯ����ʼ========");
		
		this.soc0118BL.updateCutValue(dto.getIgcim1001Form());
		dto.addMessage(new ActionMessage("IGCIM1001.I001",0));
		log.debug("========��ռ䷥ֵ�趨��ѯ��������========");
		return dto;
	}
	
}
