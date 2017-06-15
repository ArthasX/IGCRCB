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
	/**流程定义BL*/
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	/**流程处理BL*/
	protected WorkFlowOperationBL workFlowOperationBL;
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}
	public IGWKM01DTO searchWorkList(IGWKM01DTO dto) throws BLException {
		log.debug("===========工单查询操作开始=============");
		IGWKM0101Form form = dto.getIgwkm0101From();
		// 查询表单信息条件
	    IG599SearchCondImpl processInfoCond = new IG599SearchCondImpl();
	    // 工单类型编号
	 	processInfoCond.setPdid(form.getPrpdid());
	    // 查询表单信息
	   	dto.setProcessInfoList(workFlowOperationBL
	 			.searchProcessInfoByCond(processInfoCond));
	    // 查询参与人信息条件(暂无)
	 	IG337SearchCondImpl processParticipantCond = new IG337SearchCondImpl();
	 	// 查询参与人信息
	 	dto.setProcessParticipantList(workFlowOperationBL
	 			.searchProcessParticipants(processParticipantCond));

	    // 查询流状态定义信息条件
	 	IG333SearchCondImpl processStatusDefCond = new IG333SearchCondImpl();
	 	// 变更管理类型编号
		processStatusDefCond.setPsdid_like(form.getPrpdid());
	 	// 查询流状态定义
	 	dto.setProcessStatusDefList(workFlowDefinitionBL
	 			.searchProcessStatusDef(processStatusDefCond));
		IG500SearchCondImpl cond = new IG500SearchCondImpl();
		if(StringUtils.isEmpty(form.getOrder()) || StringUtils.isEmpty(form.getSing())){
			form.setOrder("propentime");
			form.setSing("desc");
		}
		this.copyProperties(cond, form);
		// 调用DAO接口查询
		List<IG500Info> prList = workFlowOperationBL.searchProcessByType(cond,0 ,0 ,form.getType());
		dto.setProcessList(prList);
		log.debug("===========工单查询操作结束=============");
		return dto;
	}

}
