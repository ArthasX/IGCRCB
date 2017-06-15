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
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC数据申请处理节点前处理
 * </p>
 */
public class IGSOCEvent0501BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0501BLImpl.class);
	
	/** 查询类功能API类 */
	private FlowSearchBL flowSearchBL;
	
	/** 更新类功能API类 */
	private FlowSetBL flowSetBL;
	
	protected UserRoleBL userRoleBL;
	
	/**
	 * @param userRoleBL the userRoleBL to set
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	
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
	 * 数据申请前处理设置参与者处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========数据申请前处理设置参与者处理开始========");
		//删除当前状态目前的参与者，重新进行设定
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("数据处理");
		this.flowSetBL.deleteStatusParticipant(spInfo);
				
		//根据roleid获得角色下的所有人
		UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
		cond.setRoleid(161);//数据处理角色id
		List<UserRoleInfo> roleList=userRoleBL.searchUserRoleVW(cond);
		
		for(UserRoleInfo pInfo : roleList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("数据处理");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		log.debug("========数据申请前处理设置参与者处理结束========");
	}

	/**
	 * 计划中前处理设置参与者处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
