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
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC变更关闭节点前处理
 * </p>
 */
public class IGSOCEvent0405BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0405BLImpl.class);
	
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
		log.debug("========变更关闭前处理设置参与者处理开始========");
		//添加发起人为变更关闭人
//		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
//		//participant.setStatusname("变更关闭 ");
//		participant.setUserid(bean.getCrtuserid());
//		participant.setRoleid(bean.getCrtroleid());
//		flowSetBL.setStatusParticipant(participant);
		//String userid = this.flowSearchBL.searchPublicProcessInfo(bean
				//.getLogInfo().getPrid(), "一级审批");
		//String userid1 = this.flowSearchBL.searchPublicProcessInfo(bean
		//		.getLogInfo().getPrid(), "二级审批");
		//String userid2 = this.flowSearchBL.searchPublicProcessInfo(bean
				//.getLogInfo().getPrid(), "三级审批");
		//List<ParticipantInfo> yi = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "一级审批");
		List<ParticipantInfo> san = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "三级审批");
		PublicProcessInfoValue fv = new PublicProcessInfoValue(bean.getLogInfo());
		fv.setFormname("审批标识");
		fv.setFormvalue("1");
		
		
		if(san != null && san.size() > 0){
			fv.setFormvalue("3");
		}
		
		
		flowSetBL.setPublicProcessInfoValue(fv);
		log.debug("========变更关闭前处理设置参与者处理结束========");
	}

	/**
	 * 计划中前处理设置参与者处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
