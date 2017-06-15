/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * 概述: 发文流程统计检索条件接口
  * 功能描述: 发文流程统计检索条件接口
  * 创建记录: 2013/02/27
  * 修改记录: 
  */
public interface DispatchStatisticsVWSearchCond {
	
	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getDsusername();
	
	/**
	 * 查询条件开始时间取得
	 *
	 * @return 查询条件开始时间
	 */
	public String getPropentime_from();
	
	/**
	 * 查询条件结束时间取得
	 *
	 * @return 查询条件结束时间
	 */
	public String getPropentime_to();
}