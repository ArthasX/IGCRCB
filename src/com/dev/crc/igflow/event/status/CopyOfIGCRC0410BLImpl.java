package com.dev.crc.igflow.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.entity.IG599TB;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckBL;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 
 * 功能：指派检查工作。发起节点如果选择分派人员，则进入分派节点，如果选择处理人，则会进入执行节点
 * @author 史凯龙   2014-9-9
 */
public class CopyOfIGCRC0410BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {

	/** 日志对象取得 */
	static Log log = LogFactory.getLog(CopyOfIGCRC0410BLImpl.class);

	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 流程处理BL */
    protected WorkFlowOperationBL workFlowOperationBL;

	/** 风险检查信息BL */
	protected RiskCheckResultBL riskCheckResultBL;
    
	/** 执行工作 */
	private String STATUSNAME_ZXGZ = "执行工作";

	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * @param 查询类功能API类
	 *            the flowSearchBL to set
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	
	

	/**
	 * @param workFlowOperationBL the workFlowOperationBL to set
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * @param riskCheckResultBL the riskCheckResultBL to set
	 */
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}

	/** 前处理 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

	/** 后处理 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		 log.debug("========指派工作流程部门审批前处理设置参与者处理开始========");

		    //日志参数信息设定
	        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
	        
	        //封装流程状态名称
	        participant.setStatusname(STATUSNAME_ZXGZ);
	        
	        //删除跃迁节点的原有参与者
//	        flowSetBL.deleteStatusParticipant(participant);
	        
	        // 设置下一个节点
//	        setParticipant(bean);
	        setNextPoint(bean);
	        
	        	        
			log.debug("========指派工作流程部门审批前处理设置参与者处理结束========");
	}
	
	/**
	 * 设置下一个节点
	 * @param bean
	 */
	private void setNextPoint(WorkFlowStatusEventBeanInfo bean) throws BLException{
		// TODO Auto-generated method stub
		
		//查询分派节点处理人		
		List<ParticipantInfo> ppList = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "检查分派");
		//查询执行节点处理人
		List<ParticipantInfo> ppList2 = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "检查执行");
		//分派节点有处理人,表单“分派标示”设置为1
		if(ppList != null && ppList.size() > 0){
			
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(bean.getLogInfo().getPrid());//流程ID
			cond.setPivarlabel("分派标示");//表单名称
			List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
			if(lst_ProcessInfo.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "表单（分派标示）");
			} else if(lst_ProcessInfo.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "表单（分派标示）");
			} else{
				IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
				instance.setPivarvalue("1");
				workFlowOperationBL.updateProcessInfo(instance);
			}
		}
		
		//执行节点有处理人，表单“分派标示”设置为1
		else if(ppList2 != null && ppList2.size() > 0){
			IG599SearchCondImpl cond = new IG599SearchCondImpl();
			cond.setPrid(bean.getLogInfo().getPrid());//流程ID
			cond.setPivarlabel("分派标示");//表单名称
			List<IG599Info> lst_ProcessInfo = workFlowOperationBL.searchProcessInfoByCond(cond);
			if(lst_ProcessInfo.isEmpty()) {
				throw new BLException("IGFLOW0000.E001", "表单（分派标示）");
			} else if(lst_ProcessInfo.size() > 1) {
				throw new BLException("IGFLOW0000.E002", "表单（分派标示）");
			} else{
				IG599TB instance = (IG599TB)SerializationUtils.clone(lst_ProcessInfo.get(0));
				instance.setPivarvalue("2");
				workFlowOperationBL.updateProcessInfo(instance);
			}
		}
		
		//
		String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "人员");
		String people = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "处理人");
        if(StringUtils.isNotEmpty(rcrid)){
        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setAssignprid(bean.getLogInfo().getPrid());
        		rcrTB.setRcrusername(people);
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}			
        }

		
	}
}