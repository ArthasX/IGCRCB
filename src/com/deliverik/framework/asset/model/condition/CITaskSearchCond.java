/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 任务表检索条件接口
  * 功能描述: 任务表检索条件接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CITaskSearchCond {
	
	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getCitstatus_eq();
	
	/**
	 * 任务描述取得
	 * @return 任务描述
	 */
	public String getCitdesc_like() ;
	
	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public String getCittime_from() ;
	
	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public String getCittime_to() ;

}