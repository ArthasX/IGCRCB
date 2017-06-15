/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.igflow.api;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.igflow.parameter.ExternalParameterInfo;

/**
 * 流程外部事件处理API
 */
public interface FlowExternalBL{

	/**
	 * 外部事件调用方法
	 * 
	 * @param eventID 事件ID
	 * @param param 参数信息
	 * @throws BLException
	 */
	public void eventHandler(String eventID, ExternalParameterInfo param) throws BLException;
}
