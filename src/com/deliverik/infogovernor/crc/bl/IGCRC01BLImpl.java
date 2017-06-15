package com.deliverik.infogovernor.crc.bl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.condition.IG337SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG500SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.infogovernor.wkm.bl.IGWKM01BLImpl;
import com.deliverik.infogovernor.wkm.dto.IGWKM01DTO;
import com.deliverik.infogovernor.wkm.form.IGWKM0101Form;

public class IGCRC01BLImpl extends BaseBLImpl implements IGCRC01BL {
	static Log log = LogFactory.getLog(IGWKM01BLImpl.class);
	/**���̶���BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/**���̴���BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	public IGWKM01DTO searchWorkList(IGWKM01DTO dto) throws BLException {
		log.debug("===========������ѯ������ʼ=============");
		IGWKM0101Form form = dto.getIgwkm0101From();
		// ��ѯ����Ϣ����
	    IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
	    // �������ͱ��
	 	processInfoCond.setPdid(form.getPrpdid());
	    // ��ѯ����Ϣ
	   	dto.setProcessInfoList(workFlowOperationBL
	 			.searchProcessInfoByCond(processInfoCond));
	    // ��ѯ��������Ϣ����(����)
	 	IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
	 	// ��ѯ��������Ϣ
	 	dto.setProcessParticipantList(workFlowOperationBL
	 			.searchProcessParticipants(processParticipantCond));

	    // ��ѯ��״̬������Ϣ����
	 	IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
	 	// ����������ͱ��
		processStatusDefCond.setPsdid_like(form.getPrpdid());
	 	// ��ѯ��״̬����
	 	dto.setProcessStatusDefList(workFlowDefinitionBL
	 			.searchProcessStatusDef(processStatusDefCond));
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		if(StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())){
			form.setOrder("propentime");
			form.setSing("desc");
		}
		this.copyProperties(cond, form);
		// ����DAO�ӿڲ�ѯ
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(cond,0 ,0 ,form.getType());
		dto.setProcessList(prList);
		log.debug("===========������ѯ��������=============");
		return dto;
	}

}
