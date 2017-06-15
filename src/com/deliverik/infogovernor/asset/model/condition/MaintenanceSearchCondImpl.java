/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * 概述: 风险指标维护检索条件实现
  * 功能描述: 风险指标维护检索条件实现
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public class MaintenanceSearchCondImpl implements
		MaintenanceSearchCond {
	
	/** 查询SQL */
	protected String searchSQL;
	
	/**查询时间*/
	protected String searchTime;
	
	/** 风险指标ID */
	protected Integer RIID;

	/**
	 * 获取查询SQL
	 * @return searchSQL
	 */
	public String getSearchSQL() {
		return searchSQL;
	}

	/**
	 * 设置查询SQL
	 * @param searchSQL
	 */
	public void setSearchSQL(String searchSQL) {
		this.searchSQL = searchSQL;
	}
	
	/**
	 * 获取查询时间
	 * @return searchTime
	 */
	public String getSearchTime() {
		return searchTime;
	}

	/**
	 * 设置查询时间
	 * @param searchTime
	 */
	public void setSearchTime(String searchTime) {
		this.searchTime = searchTime;
	}
	
	/**
	 * 风险指标ID取得
	 *
	 * @return 风险指标ID
	 */
	public Integer getRIID() {
		return RIID;
	}

	/**
	 * 风险指标ID设定
	 *
	 * @param RIID 风险指标ID
	 */
	public void setRIID(Integer RIID) {
		this.RIID = RIID;
	}
}