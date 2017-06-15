/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * 概述: 报表填报实例表检索条件接口
  * 功能描述: 报表填报实例表检索条件接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportInstanceSearchCond {
	
	/**
	 * 组标识取得
	 *
	 * @return 组标识
	 */
	public String getKey_eq();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getStatus_eq();
	
	/**
	 * 当前登录人userid取得
	 *
	 * @return 当前登录人userid
	 */
	public String getUserid();
	
	/**
	 * 流程状态名取得
	 *
	 * @return 流程状态名
	 */
	public String getPsdname();
	
	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype();
	
	/**
	 * 实例id取得
	 *
	 * @return 实例id
	 */
	public Integer getInstanceid();
	
	public String getInituser();
	
	/**
	 *发起开始时间取得
	 */
	public String getPropentime();
	
	/**
	 *发起结束时间取得
	 */
	public String getProclosetime();
	
	public String getOrderby();
	
	public String getPrtitle();
	
	/**
	 * 流程类型ID左匹配取得
	 *
	 * @return prpdid_like 流程类型ID左匹配
	 */
	public String getPrpdid_like();
	
	/**
	 * 季度降序排序标识取得
	 *
	 * @return orderby_quarter 季度降序排序标识
	 */
	public String getOrderby_quarter();
	
	/**
	 * 季度报表状态取得
	 *
	 * @return prdtatus 季度报表状态
	 */
	public String getPrstatus();
	
	/**
	 * 季度查询年取得
	 * @return year 季度查询年
	 */
	public String getYear();
	
	/**
	 * 季度标识取得
	 * @return quarter 季度标识
	 */
	public String getQuarter();
	
	/**
	 * 季度年查询大于等于取得
	 * @return year_GtEq 季度年查询大于等于
	 */
	public String getYear_GtEq();
	
	/**
	 * 季度年查询大于等于取得
	 * @return year_GtEq 季度年查询大于等于
	 */
	public String getMonth();
	
	public String getReportman();
	
	public String getReportdepartment();

}