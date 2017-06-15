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
 * 个人工作流程    处理节点前处理BL
 * @author 张剑
 *
 */
public class IGCYB0152BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL{
	 static Log log = LogFactory.getLog(IGCYB0152BLImpl.class);
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
    public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {

        // 日志参数信息设定
        StatusParticipant participant = new StatusParticipant(bean.getLogInfo());

        // 封装流程状态名称
        participant.setStatusname("确认");
        // 删除跃迁节点的原有参与者
        flowSetBL.deleteStatusParticipant(participant);

        //
        StatusParticipant statusParticipant = new StatusParticipant(bean.getLogInfo());
        statusParticipant.setStatusname("确认");
        statusParticipant.setRoleid(bean.getCrtroleid());
        statusParticipant.setUserid(bean.getCrtuserid());
        flowSetBL.setStatusParticipant(statusParticipant);

    }

	
}
