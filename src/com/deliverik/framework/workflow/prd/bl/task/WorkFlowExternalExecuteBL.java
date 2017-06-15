/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;

/**
 * <p>
 * 流程外部事件处理HandlerBL
 * </p>
 */
public interface WorkFlowExternalExecuteBL{

	/**
	 * 
	 * @param eventID 动作ID
	 * @param param 参数
	 * @throws BLException
	 */
	public void eventExecute(String eventID, ExternalParameterInfo param) throws BLException;

}
