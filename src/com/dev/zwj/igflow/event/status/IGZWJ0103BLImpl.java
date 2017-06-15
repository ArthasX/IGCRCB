/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.zwj.igflow.event.status;

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
 * Description: 设置参与人
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGZWJ0103BLImpl implements WorkFlowEventHandlerBL{
	
	/** 更新类API */
	protected FlowSetBL flowSetBL;

	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
		participant.setStatusname("进入机房确认");
		flowSetBL.deleteStatusParticipant(participant);
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
		participant.setStatusname("机房离开确认");
		participant.setUserid(null);
		participant.setRoleid(null);
		flowSetBL.deleteStatusParticipant(participant);
		participant.setUserid(bean.getCrtuserid());
		participant.setRoleid(bean.getCrtroleid());
		flowSetBL.setStatusParticipant(participant);
	}

}
