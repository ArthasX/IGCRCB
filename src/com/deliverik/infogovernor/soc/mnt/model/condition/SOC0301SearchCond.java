/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: DMX实时监控性能表检索条件接口
  * 功能描述: DMX实时监控性能表检索条件接口
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
public interface SOC0301SearchCond {
	
	/**
	 * 条件主键相等取得
	 *
	 * @return mtId_eq 条件主键相等
	 */
	public Integer getMtId_eq();
	
	/**
	 * 条件对象名相等取得
	 *
	 * @return mtoName_eq 条件对象名相等
	 */
	public String getMtoName_eq();
	
	/**
	 * 条件kpi相等取得
	 *
	 * @return mtKpi_eq 条件kpi相等
	 */
	public String getMtKpi_eq();
	/**
	 * 时间戳取得
	 *
	 * @return timestamp_ge 时间戳
	 */
	public String getTimestamp_ge();
}