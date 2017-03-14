/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.dev.ext.igflow.bds.event.status;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.api.FlowOptBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowEventHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 问题发起后主流程关闭
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGBDS0206BLImpl implements WorkFlowEventHandlerBL{
	
	/** 查询类api */
	protected FlowSearchBL flowSearchBL;
	
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
		//查询主流程信息
		Integer parPrid = flowSearchBL.searchProcessRelationForPar(bean.getLogInfo().getPrid());
		if(parPrid != null && parPrid > 0){
			//跃迁主流程信息
			flowOptBL.transitionProcess(parPrid, bean.getLogInfo().getExecutorid(), "提交", IGStringUtils.getCurrentDateTime());
		}
	}

}
