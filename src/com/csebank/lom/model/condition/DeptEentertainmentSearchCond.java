/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 食堂招待费用统计接口
 *
 */
public interface DeptEentertainmentSearchCond {
	
	/**
	 * 食堂招待费用统计查询时间开始
	 */
	public String getEtime_from();
	
	/**
	 * 食堂招待费用统计查询时间结束
	 */
	public String getEtime_to();
	
	/**
	 * 查询条件
	 * @return 查询条件
	 */
	public String getEwhere();

}
