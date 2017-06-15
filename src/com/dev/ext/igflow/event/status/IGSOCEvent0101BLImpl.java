/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
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
 * SOC服务请求"处理中"节点前处理设置处理人指定到人员
 * </p>
 */
public class IGSOCEvent0101BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0101BLImpl.class);
	
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
		log.debug("========处理中前处理设置参与者处理开始========");
		//删除本状态目前的参与者，重新进行设定
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("处理中");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("处理中");
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
		log.debug("========处理中前处理设置参与者处理结束========");
	}

	/**
	 * 流程状态后处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}