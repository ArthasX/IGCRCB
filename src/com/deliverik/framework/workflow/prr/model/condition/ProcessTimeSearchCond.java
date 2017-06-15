/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程计时表检索条件接口
  * 功能描述: 流程计时表检索条件接口
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public interface ProcessTimeSearchCond {
	/**
	 * @return 查询年份
	 */
	public String getYear();
	
	/**
	 * @return 查询用户id
	 */
	public String getUserId();

	/**
	 * @return 查询计时开始时间
	 */
	public String getPrtstartTime_le();

	/**
	 * @return 查询计时结束时间
	 */
	public String getPrtEndTime_ge();
	
	/**
	 * @return 流程ID
	 */
	public Integer getPrid();
	
}