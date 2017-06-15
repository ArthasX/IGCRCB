/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.StatusParticipant;
import com.deliverik.framework.igflow.parameter.WorkFlowLog;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 变更关闭前主流程跃迁
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0102BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 流程处理api */
	protected FlowOptBL flowOptBL;
	
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
	 * 流程处理api设定
	 * @param flowOptBL 流程处理api
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 更新类api设定
	 * @param flowSetBL 更新类api
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 前处理（跃迁主流程）
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		//取得主流程主键
		Integer parPrid = flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		if(parPrid != null && parPrid > 0){
			WorkFlowLog logInfo = new WorkFlowLog();
			logInfo.setAuthuserid(bean.getLogInfo().getAuthuserid());
			logInfo.setComment(bean.getLogInfo().getComment());
			logInfo.setExecutorid(bean.getLogInfo().getExecutorid());
			logInfo.setExecutorRoleid(bean.getLogInfo().getExecutorRoleid());
			logInfo.setPrid(parPrid);
			List<ProcessRecordInfo> info = flowSearchBL.searchProcessInfo(parPrid, null);
			StatusParticipant participant = new StatusParticipant(logInfo);
			participant.setStatuscode(info.get(0).getPrstatus());
			participant.setRoleid(bean.getLogInfo().getExecutorRoleid());
			flowSetBL.setStatusParticipant(participant);
			flowOptBL.transitionProcess(parPrid, bean.getLogInfo().getExecutorid(), "提交", IGStringUtils.getCurrentDateTime());
		}
	}

	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

}

