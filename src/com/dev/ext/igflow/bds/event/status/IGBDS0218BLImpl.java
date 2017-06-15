/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.resultset.ParticipantInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 预置处理人
 * </p>
 * 
 * @author zhangze@deliverik.com
 * @version 1.0
 */
public class IGBDS0218BLImpl implements WorkFlowEventHandlerBL{

	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类api */
	protected FlowSetBL flowSetBL;
	
	/**
	 * 查询类api设定
	 * @param flowSearchBL 查询类api
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 更新类api设定
	 * @param flowSetBL 更新类api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/*
	 * 
	 * 根据当前流程prid取得待发起节点处理人为当前节点的处理人[共同]
	 * 市局流程,区局流程
	 * 
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		//根据当前流程prid取得待发起节点处理人为当前节点的处理人[共同]
		
		//待发起节点处理人
		List<ParticipantInfo> listOfParticipantInfos = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "待发起");
		
		//待发起节点只有一个人
		if(CollectionUtils.isNotEmpty(listOfParticipantInfos)){
			StatusParticipant del = new StatusParticipant(bean.getLogInfo());
			del.setStatuscode(bean.getAfstatus());
			flowSetBL.deleteStatusParticipant(del);
			
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setRoleid(listOfParticipantInfos.get(0).getRoleid());
			participant.setUserid(listOfParticipantInfos.get(0).getUserid());
			participant.setStatuscode(bean.getAfstatus());
			flowSetBL.setStatusParticipant(participant);
			
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
