/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * 服务请求审核节点前处理设置参与者
 * </p>
 */
public class IGEVENT0304BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0304BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 流程状态前处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========审核前处理设置参与者处理开始========");
		//删除本状态目前的参与者，重新进行设定
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("审核");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("审核");
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
		log.debug("========审核前处理设置参与者处理结束========");
	}

	/**
	 * 流程状态后处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
