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
 * 变更计划审核节点前处理设置参与者
 * 将处理状态的参与者及处理审核状态的参与者设置到计划审核节点上
 * </p>
 */
public class IGEVENT0201BLImpl extends BaseBLImpl implements
		WorkFlowEventHandlerBL {
	
	static Log log = LogFactory.getLog(IGEVENT0201BLImpl.class);
	
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
	 * 流程状态前处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========计划审核前处理设置参与者处理开始========");
		//删除本状态目前的参与者，重新进行设定
		StatusParticipant spInfo = new StatusParticipant(bean.getLogInfo());
		spInfo.setStatusname("计划审核");
		this.flowSetBL.deleteStatusParticipant(spInfo);
		
		//查询处理状态的参与者（合作人）
		List<ParticipantInfo> p1InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "处理");
		for(ParticipantInfo pInfo : p1InfoList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("计划审核");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		
		//查询处理审核状态的参与者
		List<ParticipantInfo> p2InfoList = this.flowSearchBL.searchStatusParticipant(bean.getLogInfo().getPrid(), "处理审核");
		for(ParticipantInfo pInfo : p2InfoList){
			StatusParticipant participant = new StatusParticipant(bean.getLogInfo());
			participant.setStatusname("计划审核");
			participant.setUserid(pInfo.getUserid());
			participant.setRoleid(pInfo.getRoleid());
			flowSetBL.setStatusParticipant(participant);
		}
		
		
		log.debug("========计划审核前处理设置参与者处理结束========");
	}

	/**
	 * 流程状态后处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
	}
}
