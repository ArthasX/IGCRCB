/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂成本信息查询接口实现
 *
 */
public class EaterySearchCondImpl implements EaterySearchCond {
	
	/**
	 * 食堂成本信息开始时间查询
	 */
	public String etime_from;
	
	/**
	 * 食堂成本信息结束时间查询
	 */
	public String etime_to;

	/**
	 * 食堂成本信息时间查询取得
	 * @return 食堂成本信息开始时间查询
	 */
	public String getEtime_from() {
		return etime_from;
	}

	/**
	 * 食堂成本信息开始时间查询设定
	 * @param etime_from 食堂成本信息开始时间查询
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}

	/**
	 * 食堂成本信息结束时间查询取得
	 * @return 食堂成本信息结束时间查询
	 */
	public String getEtime_to() {
		return etime_to;
	}

	/**
	 * 食堂成本信息结束时间查询设定
	 * @param etime_to 食堂成本信息结束时间查询
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}

}
