/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 待处理任务检索条件接口
  * 功能描述: 待处理任务检索条件接口
  * 创建记录: 2011/04/29
  * 修改记录: 
  */
public interface EiWaitTaskSearchCond {
	
	/**
	 * 任务状态是否完成取得
	 * 
	 * @return 任务状态是否完成
	 */
	public boolean isTaskDone();
	
	/**
	 * 任务是否发生错误取得
	 * 
	 * @return 任务是否发生错误
	 */
	public boolean isTaskError();
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag_eq();

}