/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.dev.ext.igflow.linkpage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.workflow.prd.bl.task.WorkFlowLinkageHandlerBL;

/**
 * <p>
 * 表单关联事件处理逻辑实现
 * </p>
 */
public class CheckLinkageBLImpl extends BaseBLImpl implements
		WorkFlowLinkageHandlerBL {

	/**
	 * 表单关联事件处理
	 * @param 主动表单的值
	 */
	public String linkageExecute(String value) throws BLException {
		//通过主动表单的值，按照一定的业务逻辑，取得被动表单的值
		return "ok";
		
	}
	/**
	 * 表单关联校验处理操作
	 * @param initiativeValue 主动表单的值
	 * @param passivityValue 从表单的值 
	 */
	public String checkLinkageExecute(String initiativeValue,String passivityValue) throws BLException{
		//按照按照一定的业务逻辑，对提交的表单进行校验
		//主表单的值不能为空，从表单的值可能为空
		//错误信息的key值定义在ApplicationResources.properties中
		String errorKey = "";
		
		//具体的业务逻辑
		if(initiativeValue.endsWith(passivityValue)){
			errorKey = "IGPRD0102.E003";
		}else{
			errorKey = "IGPRD0102.E003";
		}
		 
		return errorKey;
	}
}
