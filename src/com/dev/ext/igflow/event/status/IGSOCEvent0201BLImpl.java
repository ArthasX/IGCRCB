/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.dev.ext.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC故障流程方案设定前处理
 * </p>
 */
public class IGSOCEvent0201BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0201BLImpl.class);
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 更新类功能API类 */
	private FlowSetBL flowSetBL;
	
	/**
	 * 更新类功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类查询类功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * 查询类功能API类设定
	 * 
	 * @param flowSearchBL 更新功能API类查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}
	/**
	 * 故障方案设定前处理
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========方案设定前处理开始========");
		//删除当前状态目前的参与者，重新进行设定
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("方案制定");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		String userid = this.flowSearchBL.searchPublicProcessInfo(bean
				.getLogInfo().getPrid(), "流程参与者");
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("方案制定");
		participant.setUserid(userid);
		participant.setRoleid(1001);
		flowSetBL.setStatusParticipant(participant);
		log.debug("========方案设定前处理结束========");
	}

	/**
	 * 故障待发起节点后设置现场工程师角色具体人员后处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
