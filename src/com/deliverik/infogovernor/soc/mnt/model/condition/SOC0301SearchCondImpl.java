/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: DMX实时监控性能表检索条件实现
  * 功能描述: DMX实时监控性能表检索条件实现
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
public class SOC0301SearchCondImpl implements SOC0301SearchCond {
	
	/** 条件主键相等 */
	private Integer mtId_eq;
	/** 条件对象名相等 */
	private String mtoName_eq;
	/** 条件kpi相等 */
	private String mtKpi_eq;
	/** 时间戳 */
	private String timestamp_ge;
	/**
	 * 条件对象名相等取得
	 *
	 * @return mtoName_eq 条件对象名相等
	 */
	public String getMtoName_eq() {
		return mtoName_eq;
	}

	/**
	 * 条件对象名相等设定
	 *
	 * @param mtoName_eq 条件对象名相等
	 */
	public void setMtoName_eq(String mtoName_eq) {
		this.mtoName_eq = mtoName_eq;
	}

	/**
	 * 条件kpi相等取得
	 *
	 * @return mtKpi_eq 条件kpi相等
	 */
	public String getMtKpi_eq() {
		return mtKpi_eq;
	}

	/**
	 * 条件kpi相等设定
	 *
	 * @param mtKpi_eq 条件kpi相等
	 */
	public void setMtKpi_eq(String mtKpi_eq) {
		this.mtKpi_eq = mtKpi_eq;
	}

	/**
	 * 条件主键相等取得
	 *
	 * @return mtId_eq 条件主键相等
	 */
	public Integer getMtId_eq() {
		return mtId_eq;
	}

	/**
	 * 条件主键相等设定
	 *
	 * @param mtId_eq 条件主键相等
	 */
	public void setMtId_eq(Integer mtId_eq) {
		this.mtId_eq = mtId_eq;
	}

	/**
	 * 时间戳取得
	 *
	 * @return timestamp_ge 时间戳
	 */
	public String getTimestamp_ge() {
		return timestamp_ge;
	}

	/**
	 * 时间戳设定
	 *
	 * @param timestamp_ge 时间戳
	 */
	public void setTimestamp_ge(String timestamp_ge) {
		this.timestamp_ge = timestamp_ge;
	}
}