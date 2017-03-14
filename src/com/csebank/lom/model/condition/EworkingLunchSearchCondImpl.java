/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂成本信息查询接口实现
 *
 */
public class EworkingLunchSearchCondImpl implements EworkingLunchSearchCond {
	
	/**
	 * 食堂工作餐信息查询时间开始
	 */
	public String ewltime_from;
	
	/**
	 * 食堂工作餐信息查询时间结束
	 */
	public String ewltime_to;

	/**
	 * 食堂工作餐信息查询时间开始
	 * @return 食堂工作餐信息查询时间开始
	 */
	public String getEwltime_from() {
		return ewltime_from;
	}

	/**
	 * 食堂工作餐信息查询时间开始
	 * @param etime_from 食堂工作餐信息查询时间开始
	 */
	public void setEwltime_from(String ewltime_from) {
		this.ewltime_from = ewltime_from;
	}

	/**
	 * 食堂工作餐信息查询时间结束
	 * @return 食堂工作餐信息查询时间结束
	 */
	public String getEwltime_to() {
		return ewltime_to;
	}

	/**
	 * 食堂工作餐信息查询时间结束
	 * @param etime_to 食堂工作餐信息查询时间结束
	 */
	public void setEwltime_to(String ewltime_to) {
		this.ewltime_to = ewltime_to;
	}

}
