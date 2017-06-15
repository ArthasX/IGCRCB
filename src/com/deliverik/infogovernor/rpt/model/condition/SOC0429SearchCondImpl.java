/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 主机容量视图检索条件实现
  * 功能描述: 主机容量视图检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVWSearchCondImpl表名改为SOC0429SearchCondImpl
  */
public class SOC0429SearchCondImpl implements
		SOC0429SearchCond {
	protected Integer bcId_eq;
	protected String sName_eq;
	protected String bcName_eq;

	/**
	 * bcId_eq取得
	 *
	 * @return bcId_eq bcId_eq
	 */
	public Integer getBcId_eq() {
		return bcId_eq;
	}

	/**
	 * bcId_eq设定
	 *
	 * @param bcId_eq bcId_eq
	 */
	public void setBcId_eq(Integer bcId_eq) {
		this.bcId_eq = bcId_eq;
	}

	/**
	 * sName_eq取得
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq() {
		return sName_eq;
	}

	/**
	 * sName_eq设定
	 *
	 * @param name_eq sName_eq
	 */
	public void setSName_eq(String name_eq) {
		sName_eq = name_eq;
	}

	/**
	 * bcName_eq取得
	 *
	 * @return bcName_eq bcName_eq
	 */
	public String getBcName_eq() {
		return bcName_eq;
	}

	/**
	 * bcName_eq设定
	 *
	 * @param bcName_eq bcName_eq
	 */
	public void setBcName_eq(String bcName_eq) {
		this.bcName_eq = bcName_eq;
	}

}