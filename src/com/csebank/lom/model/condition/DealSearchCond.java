/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 接待查询接口
 *
 */
public interface DealSearchCond {
	
	/**
	 * 接待工作
	 */
	public Integer getRid();
	public String getDeptName();
	
	/**
	 * 接待状态
	 */
	public String getRstatus();
	
	/**
	 * 时间
	 */
	public String getDealTime();
	

	/**
	 * 申请部门层次码
	 */
	public String getRapporgid();
	
	/**
	 * 统计年份
	 */
	public String getYear();
	
	/**
	 * 统计月份
	 */
	public String getMonth();
	
	/**
	 * 部门接待统计申请部门层次码
	 */
	public String getRapporgid_org();
	
	/**
	 * 部门接待统计年份
	 */
	public String getYear_org();
	
	/**
	 * 部门接待统计开始月份
	 */
	public String getMonth_from_org();
	
	/**
	 * 部门接待统计结束月份
	 */
	public String getMonth_to_org();
	
	/**
	 * 接待查询时间开始
	 */
	public String getRtime_from();
	
	/**
	 * 接待查询时间结束
	 */
	public String getRtime_to();
}
