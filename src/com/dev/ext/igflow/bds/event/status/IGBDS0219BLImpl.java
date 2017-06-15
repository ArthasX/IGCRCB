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
public class IGBDS0219BLImpl implements WorkFlowEventHandlerBL{

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
		
		
		//知识库流程
		//查看审核意见、添加知识库和格式审核是同一人
		
		//格式审核节点处理人
		List<ParticipantInfo> listOfParticipantInfos = flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "格式审核");
		
		if(CollectionUtils.isNotEmpty(listOfParticipantInfos)){
			
			StatusParticipant del = new StatusParticipant(bean.getLogInfo());
			del.setStatuscode(bean.getAfstatus());
			flowSetBL.deleteStatusParticipant(del);
			
			for (ParticipantInfo participantInfo : listOfParticipantInfos) {
				
				if(StringUtils.isNotEmpty(participantInfo.getPpproctime())){
					StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
					participant.setRoleid(participantInfo.getRoleid());
					participant.setUserid(participantInfo.getUserid());
					participant.setStatuscode(bean.getAfstatus());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
	}

}
