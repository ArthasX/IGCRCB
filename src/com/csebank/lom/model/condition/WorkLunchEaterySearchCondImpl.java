/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 工作餐成本统计实现
 *
 */
public class WorkLunchEaterySearchCondImpl implements WorkLunchEaterySearchCond {
	
	/**
	 * 查询类型
	 */
	protected String searchtype;
	
	/**
	 * 统计开始时间查询
	 */
	protected String etime_from;
	
	/**
	 * 统计结束时间查询
	 */
	protected String etime_to;
	
	/**
	 * 日期
	 */
	protected String edate;
	
	/**
	 * 查询类型
	 * @return 查询类型
	 */
	public String getSearchtype() {
		return searchtype;
	}
	
	/**
	 * 查询类型
	 * @param searchtype 查询类型
	 */
	public void setSearchtype(String searchtype) {
		this.searchtype = searchtype;
	}
	
	/**
	 * 统计开始时间查询
	 * @return 统计开始时间查询
	 */
	public String getEtime_from() {
		return etime_from;
	}
	
	/**
	 * 统计开始时间查询
	 * @param etime_from 统计开始时间查询
	 */
	public void setEtime_from(String etime_from) {
		this.etime_from = etime_from;
	}
	
	/**
	 * 统计结束时间查询
	 * @return 统计结束时间查询
	 */
	public String getEtime_to() {
		return etime_to;
	}
	
	/**
	 * 统计结束时间查询
	 * @param etime_to 统计结束时间查询
	 */
	public void setEtime_to(String etime_to) {
		this.etime_to = etime_to;
	}
	
	/**
	 * 日期
	 * @return 日期
	 */
	public String getEdate() {
		return edate;
	}
	
	/**
	 * 日期
	 * @param edate 日期
	 */
	public void setEdate(String edate) {
		this.edate = edate;
	}

}
