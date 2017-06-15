/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 流程事件处理HandlerBL
 * </p>
 */
public interface WorkFlowEventHandlerBL extends BaseBL {

	/**
	 * 流程状态前处理操作
	 * 
	 * @param bean 前后处理参数定义
	 */
	public void preTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException;

	/**
	 * 流程状态后处理操作
	 * 
	 * @param bean 前后处理参数定义
	 */
	public void afterTreatmentExecute(WorkFlowStatusEventBeanInfo bean) throws BLException;

}
