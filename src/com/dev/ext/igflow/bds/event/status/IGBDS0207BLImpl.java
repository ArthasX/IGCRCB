/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发起升级流程
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0207BLImpl implements WorkFlowEventHandlerBL{
	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 更新类api */
	protected FlowSetBL flowSetBL;
	
	/** 流程处理api */
	protected FlowOptBL flowOptBL;

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

	/**
	 * 流程处理api设定
	 * @param flowOptBL 流程处理api
	 */
	public void setFlowOptBL(FlowOptBL flowOptBL) {
		this.flowOptBL = flowOptBL;
	}

	/**
	 * 前处理
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		
	}

	/**
	 * 后处理
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean)
			throws BLException {
		List<ProcessRecordInfo> processInfos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
		ProcessRecord record = new ProcessRecord(bean.getLogInfo());
		record.setCrtuserid(bean.getLogInfo().getExecutorid());
		record.setDefid("0132001");
		record.setTitle(processInfos.get(0).getPrpdname() + "_" + processInfos.get(0).getPrtitle() + "_发起的升级流程");
		record.setDescription(processInfos.get(0).getPrpdname() + "_" + processInfos.get(0).getPrtitle() + "_发起的升级流程");
		record.setRoleid(bean.getLogInfo().getExecutorRoleid());
		Integer prid = flowOptBL.initProcessAction(record);
		flowSetBL.setProcessRelation(bean.getLogInfo().getPrid(), prid);
	}

}
