/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 接待统计查询接口
 *
 */
public interface RecptionVWSearchCond {
	
	/** 查询时间段 开始日期 */
	public String getRtime_from();
	
	/** 查询时间段 截止日期 */
	public String getRtime_to();
	
	/** 年份 */
	public String getYear();

}
