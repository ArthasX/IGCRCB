/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 预支明细统计查询接口
 *
 */
public interface AdvanceDetailSearchCond {
	
	/**
	 * 查询时间开始
	 */
	public String getDate_from();
	
	/**
	 * 查询时间结束
	 */
	public String getDate_to();
	
}
