/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * 概述: ExcuteResult检索条件实现
  * 功能描述: ExcuteResult检索条件实现
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
public class ExcuteResultSearchCondImpl implements
		ExcuteResultSearchCond {
	
	protected Integer taskID_eq;

	public Integer getTaskID_eq() {
		return taskID_eq;
	}

	public void setTaskID_eq(Integer taskID_eq) {
		this.taskID_eq = taskID_eq;
	}

}