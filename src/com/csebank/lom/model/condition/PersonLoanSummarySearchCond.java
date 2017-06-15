/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 预支人员统计查询接口
 *
 */
public interface PersonLoanSummarySearchCond {
	
	/**
	 * 借款人所属机构层次码
	 */
	public String getLpduserorg();
	
	/**
	 * 借款查询时间开始
	 */
	public String getLpddate_from();
	
	/**
	 * 借款查询时间结束
	 */
	public String getLpddate_to();
	
}
