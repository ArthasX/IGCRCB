/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂成本信息查询接口
 *
 */
public interface LunchCardSearchCond {
	
	/**
	 * 餐卡种类
	 */
	public String getTypename();
	
	/**
	 * 餐卡状态
	 */
	public String getDesc();
	
	/**
	 * 餐卡编号
	 */
	public Integer getIcid();

}
