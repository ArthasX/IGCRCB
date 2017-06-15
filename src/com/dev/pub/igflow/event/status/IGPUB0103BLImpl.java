/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.pub.igflow.event.status;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发起人做为处理人前处理
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPUB0103BLImpl implements WorkFlowEventHandlerBL{
	
	/** 日志对象 */
	private static final Log log = LogFactory.getLog(IGPUB0103BLImpl.class);
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	/**
	 * 更新类API设定
	 * @param flowSetBL 更新类API
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		log.debug("================发起人作为当前节点处理人设置操作开始================");
		//实例化参与人对象
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatuscode(bean.getAfstatus());
		//删除当前节点参与人
		flowSetBL.deleteStatusParticipant(participant);
		//设置处理角色为发起角色
		participant.setRoleid(bean.getCrtroleid());
		//设置处理人为发起人
		participant.setUserid(bean.getCrtuserid());
		//设置当前节点处理人
		flowSetBL.setStatusParticipant(participant);
		log.debug("================发起人作为当前节点处理人设置操作结束================");
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}
