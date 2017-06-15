/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程策略提醒检索条件接口
  * 功能描述: 流程策略提醒检索条件接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG256SearchCond {
	/**
	 * 获取流程ID
	 * @return
	 */
	public Integer getPrid();
	
	/**
	 * 获取流程状态
	 * @return
	 */
	public String getPrstatus();
	
	/**
	 * 通知标识获取 
	 * @return
	 */
	public String getFlag();
	
	/**
	 * 获取通知标识 in
	 * @return
	 */
	public String[] getFlag_in();
	
}