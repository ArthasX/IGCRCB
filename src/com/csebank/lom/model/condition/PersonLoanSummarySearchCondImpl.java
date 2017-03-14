/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 预支人员查询接口实现
 *
 */
public class PersonLoanSummarySearchCondImpl implements PersonLoanSummarySearchCond {
	
	/**
	 * 借款人所属机构层次码
	 */
	protected String lpduserorg;
	
	/**
	 * 借款查询时间开始
	 */
	protected String lpddate_from;
	
	/**
	 * 借款查询时间结束
	 */
	protected String lpddate_to;

	/**
	 * 借款人所属机构层次码设定
	 * @return 借款人所属机构层次码
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * 借款人所属机构层次码设定
	 * @param lpduserorg 借款人所属机构层次码
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * 借款查询时间开始设定
	 * @return 借款查询时间开始
	 */
	public String getLpddate_from() {
		return lpddate_from;
	}

	/**
	 * 借款查询时间开始设定
	 * @param lpddate_from 借款查询时间开始
	 */
	public void setLpddate_from(String lpddate_from) {
		this.lpddate_from = lpddate_from;
	}

	/**
	 * 借款查询时间结束设定
	 * @return 借款查询时间结束
	 */
	public String getLpddate_to() {
		return lpddate_to;
	}

	/**
	 * 借款查询时间结束设定
	 * @param lpddate_to 借款查询时间结束
	 */
	public void setLpddate_to(String lpddate_to) {
		this.lpddate_to = lpddate_to;
	}
	
}