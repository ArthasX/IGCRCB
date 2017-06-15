/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 审计待处理任务检索条件实现
  * 功能描述: 审计待处理任务检索条件实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class SOC0105SearchCondImpl implements
		SOC0105SearchCond {
	
	/** 任务状态是否完成 */
	protected boolean taskDone;
	
	/** 任务是否发生错误 */
	protected boolean taskError;
	
	/** 逻辑删除标识 */
	protected String deleteflag_eq;

	/**
	 * 任务状态是否完成取得
	 * 
	 * @return 任务状态是否完成
	 */
	public boolean isTaskDone() {
		return taskDone;
	}

	/**
	 * 任务状态是否完成设定
	 * 
	 * @param 任务状态是否完成
	 */
	public void setTaskDone(boolean taskDone) {
		this.taskDone = taskDone;
	}
	
	/**
	 * 任务是否发生错误取得
	 * 
	 * @return 任务是否发生错误
	 */
	public boolean isTaskError() {
		return taskError;
	}

	/**
	 * 任务是否发生错误设定
	 * 
	 * @param taskError 任务是否发生错误
	 */
	public void setTaskError(boolean taskError) {
		this.taskError = taskError;
	}

	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * 逻辑删除标识设定
	 *
	 * @param deleteflag_eq 逻辑删除标识
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}

}