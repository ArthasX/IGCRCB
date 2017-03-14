/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.cyb.igflow.event.status;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
/**
 * 服务工单流程    处理节点前处理BL
 * @author 张剑
 *
 */
public class IGCYB0151BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	 static Log log = LogFactory.getLog(IGCYB0151BLImpl.class);
	private FlowSetBL flowSetBL;
	
	
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	public void afterTreatmentExecute(
			WorkFlowStatusEventBeanInfo workflowstatuseventbeaninfo)
			throws BLException {
	}
	/***
	 * 前处理  
	 * 添加流程发起者为当前节点参与人
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {	
		
			//
			StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
			statusParticipant.setStatusname("处理");
			statusParticipant.setRoleid(bean.getCrtroleid());
			statusParticipant.setUserid(bean.getCrtuserid());
			flowSetBL.setStatusParticipant(statusParticipant);
		
		
	}

	
}
