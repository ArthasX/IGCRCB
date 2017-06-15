/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;

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
public class IGBDS0220BLImpl implements WorkFlowEventHandlerBL{

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

	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
		//填写审核意见、和内容审核是同一人
//		List<ParticipantInfo> listOfParticipantInfos = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "内容审核");
		
		List<ParticipantInfo> participants = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		
		if(CollectionUtils.isNotEmpty(participants)){
			
			for (ParticipantInfo participantInfo : participants) {
				//指定到角色的删除
				if(StringUtils.isEmpty(participantInfo.getUserid())){
					StatusParticipant del = new StatusParticipant(bean.getLogInfo());
					del.setStatuscode(bean.getAfstatus());
					del.setRoleid(participantInfo.getRoleid());
					flowSetBL.deleteStatusParticipant(del);
				}
				
			}
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
