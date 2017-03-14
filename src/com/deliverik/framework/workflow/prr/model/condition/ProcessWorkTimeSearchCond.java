/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 用户作息时间定义表检索条件接口
  * 功能描述: 用户作息时间定义表检索条件接口
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public interface ProcessWorkTimeSearchCond {
	
	/**
	 * @return 查询开始日期
	 */
	public String getStartDate();

	/**
	 * @return 查询结束日期
	 */
	public String getEndDate();

	/**
	 * @return 查询工作日期
	 */
	public String getPwDate();

	/**
	 * @return 查询用户修改标识位
	 */
	public String getPwFlg();
	
	/**
	 * 查询年份获取
	 * @return
	 */
	public String getPwDate_like();
	
	/**
	 * @return 查询用户ID
	 */
	public String getUserId();

}