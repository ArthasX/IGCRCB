/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.dev.qlb.igflow.event.status;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
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

/***
 * 变更添加合作人后处理
 * @time 2014/06/11
 * @author zhangqiang
 * @version 1.0
 * @mail zhangq@deliverik.com
 */
public class IGQL0103BLImpl extends BaseBLImpl implements WorkFlowEventHandlerBL {
	
	private static Log log = LogFactory.getLog(IGQL0103BLImpl.class);
	
	/** 查询类API */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新功能API类 */
	protected FlowSetBL flowSetBL;

	/**
	 * @param 更新功能API类 the flowSetBL to set
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 查询类API设定
	 * @param flowSearchBL 查询类API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)throws BLException {
		log.debug("=====================变更一级审批后处理开始=====================");
		//查询合作人表单值
		 List<ParticipantInfo> participants = flowSearchBL.searchPublicParticipantFormValue(bean.getLogInfo().getPrid(), "合作人");
		//查询当前状态
		List<ParticipantInfo>  list = flowSearchBL.searchStatusParticipantByCode(bean.getLogInfo().getPrid(), bean.getAfstatus());
		Map<String, ParticipantInfo> map = new HashMap<String, ParticipantInfo>();
		for(ParticipantInfo info:list){
			if(StringUtils.isNotEmpty(info.getUserid())){
				map.put(info.getUserid(), info);
			}
		}
		if(participants != null){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatuscode(bean.getAfstatus());
			for(ParticipantInfo info:participants){
				if(map.get(info.getUserid()) == null){
					participant.setRoleid(info.getRoleid());
					participant.setUserid(info.getUserid());
					flowSetBL.setStatusParticipant(participant);
				}
			}
		}
		log.debug("=====================变更一级审批后处理结束=====================");
	}
}
