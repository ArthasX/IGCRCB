/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 主机容量视图检索条件接口
  * 功能描述: 主机容量视图检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVWSearchCond修改为SOC0429SearchCond
  */
public interface SOC0429SearchCond {
	/**
	 * bcId_eq取得
	 *
	 * @return bcId_eq bcId_eq
	 */
	public Integer getBcId_eq();
	/**
	 * sName_eq取得
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq();
	/**
	 * bcName_eq取得
	 *
	 * @return bcName_eq bcName_eq
	 */
	public String getBcName_eq();
}