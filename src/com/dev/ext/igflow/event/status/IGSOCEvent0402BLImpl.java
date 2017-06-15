/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.dev.ext.igflow.event.status;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC变更复核节点前处理
 * </p>
 */
public class IGSOCEvent0402BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0402BLImpl.class);
	
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
	 * 计划中前处理设置参与者处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========变更复核前处理设置参与者处理开始========");
		//查询处理复核状态的参与者
		List<ParticipantInfo> p2InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "变更复核");
		for(ParticipantInfo pInfo : p2InfoList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("变更复核");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		log.debug("========变更复核 前处理设置参与者处理结束========");
	}

	/**
	 * 计划中前处理设置参与者处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
