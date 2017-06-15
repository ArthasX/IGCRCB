/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 工作餐成本统计接口
 *
 */
public interface WorkLunchEaterySearchCond {
	
	/**
	 * 日期
	 */
	public String getEdate();
	
	/**
	 * 查询类型
	 */
	public String getSearchtype();
	
	/**
	 * 统计查询时间开始
	 */
	public String getEtime_from();
	
	/**
	 * 统计查询时间结束
	 */
	public String getEtime_to();

}
