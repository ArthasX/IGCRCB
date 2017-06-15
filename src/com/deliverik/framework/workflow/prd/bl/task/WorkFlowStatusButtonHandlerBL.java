/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 流程状态按钮处理HandlerBL
 * </p>
 */
public interface WorkFlowStatusButtonHandlerBL extends BaseBL {
	
	/**
	 * 流程状态按钮处理操作
	 * 
	 * @param info 参数
	 */
	public void statusButtonTreatmentExecute(WorkFlowStatusEventBeanInfo info) throws BLException;
}
