/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * 表单关联事件处理HandlerBL
 * </p>
 */
public interface WorkFlowLinkageHandlerBL extends BaseBL {

	/**
	 * 表单关联处理操作
	 *  @param value 表单的值
	 */
	public String linkageExecute(String value) throws BLException;
	

	/**
	 * 表单关联校验处理操作
	 * 
	 */
	public String checkLinkageExecute(String initiativeValue,String passivityValue) throws BLException;



}
