/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 参考流程触发影响处理BL
 */
public interface WorkFlowGroupEventBL extends BaseBL {

	/**
	 * 参考流程触发影响处理
	 * 
	 * @param rprid 参考流程ID
	 * @param iprid 影响流程ID
	 * @throws BLException
	 */
	public void execute(Integer rprid, Integer iprid) throws BLException;

}
