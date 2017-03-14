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
 * SOC变更"完成"节点前处理设置处理让人指点到人员
 * </p>
 */
public class IGSOCEvent0304BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0304BLImpl.class);
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	
	/**
	 * 查询类功能API类设定
	 * 
	 * @param flowSearchBL 更新功能API类查询类功能API类
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}
	
	/**
	 * 流程状态"完成"节点前处理将处理角色指定到人员
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========完成前处理设置参与者处理开始========");
		//删除当前状态目前的参与者，重新进行设定
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("完成");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		String userid = this.flowSearchBL.searchPublicProcessInfo(bean
				.getLogInfo().getPrid(), "流程参与者");
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("完成");
		participant.setUserid(userid);
		participant.setRoleid(1001);
		flowSetBL.setStatusParticipant(participant);
		log.debug("========完成前处理设置参与者处理结束========");
	}

	/**
	 * 流程状态后处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
