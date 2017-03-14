/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.WorkFlowParameterInfo;

/**
 * <p>
 * 流程状态表单值初始化HandlerBL
 * </p>
 */
public interface WorkFlowInitFormHandlerBL extends BaseBL {

	/**
	 * 流程状态表单值初始化
	 * 
	 * @param param 流程处理参数接口
	 * @return 表单值集合（<名称-值>）
	 */
	public Map<String, Object> initForm(WorkFlowParameterInfo param) throws BLException;

}
