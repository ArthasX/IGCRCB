/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.ProcessRecord;
import com.deliverik.framework.igflow.resultset.ProcessRecordInfo;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;
import com.deliverik.framework.workflow.prr.bl.task.IG500BL;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.framework.workflow.prr.model.entity.IG500TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 区局运维发起市局运维
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0205BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
	/** 流程处理api */
	protected FlowOptBL flowOptBL;
	
	/** 更新类api */
	protected FlowSetBL flowSetBL;
	
	/** 流BL */
	protected IG500BL ig500BL;
	
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
	 * 流BL设定
	 * @param ig500BL 流BL
	 */
	public void setIg500BL(IG500BL ig500bl) {
		ig500BL = ig500bl;
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
		String flag = flowSearchBL.searchPublicProcessInfo(bean.getLogInfo().getPrid(), "是否是市局运维");
		if("是".equals(flag)){
			List<ProcessRecordInfo> processInfos = flowSearchBL.searchProcessInfo(bean.getLogInfo().getPrid(), null);
			ProcessRecord record = new ProcessRecord(bean.getLogInfo());
			record.setCrtuserid(bean.getLogInfo().getExecutorid());
			record.setDefid("0128001");
			record.setTitle(processInfos.get(0).getPrtitle() + "上报的市局运维");
			record.setDescription(processInfos.get(0).getPrtitle() + "上报的市局运维");
			record.setRoleid(bean.getLogInfo().getExecutorRoleid());
			Integer prid = flowOptBL.initProcessAction(record);
			flowSetBL.setProcessRelation(bean.getLogInfo().getPrid(), prid);
			IG500Info ig500 = ig500BL.searchIG500InfoByKey(prid);
			IG500TB ig500TB = (IG500TB) SerializationUtils.clone(ig500);
			ig500TB.setProrgid("0002001");
			ig500TB.setProrgname("市局机关");
			ig500BL.updateIG500Info(ig500TB);
		}
	}

}
