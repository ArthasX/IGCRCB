/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险指标维护检索条件接口
  * 功能描述: 风险指标维护检索条件接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface MaintenanceSearchCond {
	
	/**
	 * 获取查询SQL
	 * @return searchSQL
	 */
	public String getSearchSQL();
	
	/**
	 * 获取查询时间
	 * @return searchTime
	 */
	public String getSearchTime();
	
	/**
	 * 风险指标ID取得
	 *
	 * @return 风险指标ID
	 */
	public Integer getRIID();
}