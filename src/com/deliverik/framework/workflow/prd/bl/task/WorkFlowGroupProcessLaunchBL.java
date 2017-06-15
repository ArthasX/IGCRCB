/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * 组内流程发起处理BL
 */
public interface WorkFlowGroupProcessLaunchBL extends BaseBL {
	
	/**
	 * 组内流程发起处理
	 * 
	 * @return 流程ID
	 * @throws BLException
	 */
	public Integer launchProcess(Integer groupID, String groupDefID, String pdid, String title, 
			String executorID, Integer executorRoleID) throws BLException;

}
