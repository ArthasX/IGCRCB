/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
  * 概述: 流程策略管理业务逻辑接口
  * 功能描述: 流程策略管理业务逻辑接口
  * 创建记录: 2013/09/04
  * 修改记录: 
  */
public interface WorkFlowTacticsHandlerBL extends BaseBL {

	public abstract void initExecute(String pdid, String psdid) throws BLException;
	
}
