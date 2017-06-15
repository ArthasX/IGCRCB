/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 接待统计查询接口实现
 *
 */
public class RecptionVWSearchCondImpl implements RecptionVWSearchCond {
	
	/** 查询时间段 开始日期 */
	protected String rtime_from;
	
	/** 查询时间段 截止日期 */
	protected String rtime_to;
	
	/** 年份 */
	protected String year;


	/**
	 * 查询时间段 开始日期取得
	 * @return 查询时间段 开始日期
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * 查询时间段 开始日期设定
	 * @param rtime_from 查询时间段 开始日期
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * 查询时间段 截止日期取得
	 * @return 查询时间段 截止日期
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * 查询时间段 截止日期设定
	 * @param rtime_to 查询时间段 截止日期
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	/**
	 * 年份取得
	 * @return 年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year 年份
	 */
	public void setYear(String year) {
		this.year = year;
	}
}
