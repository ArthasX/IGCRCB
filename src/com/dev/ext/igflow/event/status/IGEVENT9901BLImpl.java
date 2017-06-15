/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.risk.bl.task.RiskCheckResultBL;
import com.deliverik.infogovernor.risk.model.RiskCheckResult;
import com.deliverik.infogovernor.risk.model.entity.RiskCheckResultTB;

/**
 * 检查问题流程 - （计划制定）节点前处理添加参与者逻辑（将发起人添加为处理人）
 * @author Administrator
 *
 */
public class IGEVENT9901BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	
	/**日志对象取得*/
	static Log log = LogFactory.getLog(IGEVENT9901BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;

    /** 流程处理BL */
    private WorkFlowOperationBL workFlowOperationBL;
	
	/** 风险检查信息BL */
	protected RiskCheckResultBL riskCheckResultBL;
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/**
	 * 注入更新功能API类
	 * 
	 * @param flowSetBL
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
     * 流程处理BL设定
     *
     * @param workFlowOperationBL 流程处理BL
     */
    public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
        this.workFlowOperationBL = workFlowOperationBL;
    }
    
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}
	public void setRiskCheckResultBL(RiskCheckResultBL riskCheckResultBL) {
		this.riskCheckResultBL = riskCheckResultBL;
	}
	/**
	 *查询类功能API类设定
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	
	/**
	 * 前处理添加参与者
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		
	    log.debug("========检查问题流程计划制定前处理设置参与者处理开始========");

        //获得待发起的参与者的部门机构码
        IG500Info prInfo = workFlowOperationBL.searchProcessRecordByKey(bean.getLogInfo().getPrid());
        
        //日志参数信息设定
        StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
        
        //封装流程状态名称
        spInfo.setStatusname("计划制定");
        
        //删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(spInfo);
        
        //日志参数信息设定
        StatusParticipant participants = new StatusParticipant(bean.getLogInfo());
        
        //封装流程处理人id
        participants.setUserid(prInfo.getPruserid());
        
        //封装流程处理角色id
        participants.setRoleid(prInfo.getPrroleid());
        
        //封装流程状态名称
        participants.setStatusname("计划制定");
        
        //参与角色和参与人添加
        flowSetBL.setStatusParticipant(participants);
        
        String rcrid = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "检查工作");
        if(StringUtils.isNotEmpty(rcrid)){
        	rcrid = rcrid.split("#")[2];
        	RiskCheckResult rcrBean = riskCheckResultBL.searchRiskCheckResultByKey(Integer.parseInt(rcrid));
        	if(rcrBean!=null){
        		RiskCheckResultTB rcrTB = (RiskCheckResultTB)SerializationUtils.clone(rcrBean);
        		rcrTB.setPrid(prInfo.getPrid());
        		riskCheckResultBL.updateRiskCheckResult(rcrTB);
        	}
        			
        }
        
		log.debug("========检查问题流程计划制定前处理设置参与者处理结束========");
	}

}

