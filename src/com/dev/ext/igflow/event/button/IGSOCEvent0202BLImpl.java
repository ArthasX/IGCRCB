/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.dev.ext.igflow.event.button;


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSetBL;
import com.deliverik.framework.igflow.parameter.PublicProcessInfoValue;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusButtonHandlerBL;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowStatusEventBeanInfo;

/**
 * <p>
 * SOC服务请求"处理中"节点后处理设置IG337中ppproctime字段为null
 * </p>
 */
public class IGSOCEvent0202BLImpl extends BaseBLImpl implements
		WorkFlowStatusButtonHandlerBL {
	static Log log = LogFactory.getLog(IGSOCEvent0202BLImpl.class);
	
	/** 更新功能API类 */
	private FlowSetBL flowSetBL;
	

	/**
	 * 更新功能API类设定
	 * 
	 * @param flowSetBL 更新功能API类
	 */
	public void setFlowSetBL(FlowSetBL flowSetBL) {
		this.flowSetBL = flowSetBL;
	}

	/**
	 * 按钮事件处理操作
	 * 
	 * @param bean 流程信息
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException {
		log.debug("========按钮事件修改隐藏表单值开始========");
		PublicProcessInfoValue fv = new PublicProcessInfoValue(bean.getLogInfo());
		fv.setFormname("驳回标识");
		fv.setFormvalue("3");
		flowSetBL.setPublicProcessInfoValue(fv);
		log.debug("========按钮事件修改隐藏表单值开始========");
	}
}