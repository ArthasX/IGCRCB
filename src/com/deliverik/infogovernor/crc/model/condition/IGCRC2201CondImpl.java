/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
 * @Description: 变更总体统计查询条件实现
 * @Author zhangqiang
 * @History @2014-8-7新建
 * 
 * @Version V1.0
 */
public class IGCRC2201CondImpl implements IGCRC2201Cond {

	/** 年 */
	protected String year;

	/** 月 */
	protected String month;

	/**
	 * 年取得
	 * 
	 * @return year 年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年设定
	 * 
	 * @param year
	 *            年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月取得
	 * 
	 * @return month 月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月设定
	 * 
	 * @param month
	 *            月
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
