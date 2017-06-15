/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 人员借款明细查询接口
 *
 */
public interface PersonLoanDetailSearchCond {
	
	/**
	 * 姓名
	 */
	public String getUsername();
	
	/**
	 * 查询时间开始
	 */
	public String getDate_from();
	
	/**
	 * 查询时间结束
	 */
	public String getDate_to();
	
	public String getGoorgname();
	public String getGoreqorg();
	
}
