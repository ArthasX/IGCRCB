/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 接待查询接口实现
 *
 */
public class RecptionSearchCondImpl implements RecptionSearchCond {
	
	/**
	 * 接待ID
	 */
	protected Integer rid;
	
	/**
	 * 接待状态
	 */
	protected String rstatus_q;
	
	/**
	 * 接待开始时间查询开始
	 */
	protected String rtime_from;
	
	/**
	 * 接待开始时间查询结束
	 */
	protected String rtime_to;
	
	/**
	 * 接待结束时间查询开始
	 */
	protected String retime_from;
	
	/**
	 * 接待结束时间查询结束
	 */
	protected String retime_to;
	
	/**
	 * 申请部门层次码
	 */
	protected String rapporgid_q;
	
	/**
	 * 统计年份
	 */
	protected String year;
	
	/**
	 * 统计月份
	 */
	protected String month;
	
	/**
	 * 部门接待统计申请部门层次码
	 */
	protected String rapporgid_org;
	
	/**
	 * 部门接待统计年份
	 */
	protected String year_org;
	
	/**
	 * 部门接待统计开始月份
	 */
	protected String month_from_org;
	
	/**
	 * 部门接待统计结束月份
	 */
	protected String month_to_org;

	/**
	 * 接待ID取得
	 * @return 接待ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待ID设定
	 * @param rid 接待ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	
	
	/**
	 * 接待状态取得
	 * @return 接待状态
	 */
	public String getRstatus_q() {
		return rstatus_q;
	}

	/**
	 * 接待状态设定
	 * @param rstatus 接待状态
	 */
	public void setRstatus_q(String rstatus_q) {
		this.rstatus_q = rstatus_q;
	}

	/**
	 * 接待开始时间查询取得
	 * @return 接待开始时间查询
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * 接待开始时间查询设定
	 * @param rtime_from 接待开始时间查询
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * 接待结束时间查询取得
	 * @return 接待结束时间查询
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * 接待结束时间查询设定
	 * @param rtime_to 接待结束时间查询
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	/**
	 * 申请部门层次码取得
	 * @return 申请部门层次码
	 */
	public String getRapporgid_q() {
		return rapporgid_q;
	}

	/**
	 * 申请部门层次码设定
	 * @param rapporgid 申请部门层次码
	 */
	public void setRapporgid_q(String rapporgid_q) {
		this.rapporgid_q = rapporgid_q;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 部门接待统计申请部门层次码取得
	 * @return 部门接待统计申请部门层次码
	 */
	public String getRapporgid_org() {
		return rapporgid_org;
	}

	/**
	 * 部门接待统计申请部门层次码设定
	 * @param rapporgid_org 部门接待统计申请部门层次码
	 */
	public void setRapporgid_org(String rapporgid_org) {
		this.rapporgid_org = rapporgid_org;
	}

	/**
	 * 部门接待统计年份取得
	 * @return 部门接待统计年份
	 */
	public String getYear_org() {
		return year_org;
	}

	/**
	 * 部门接待统计年份设定
	 * @param year_org 部门接待统计年份
	 */
	public void setYear_org(String year_org) {
		this.year_org = year_org;
	}

	/**
	 * 部门接待统计开始月份取得
	 * @return 部门接待统计开始月份
	 */
	public String getMonth_from_org() {
		return month_from_org;
	}

	/**
	 * 部门接待统计开始月份设定
	 * @param month_from_org 部门接待统计开始月份
	 */
	public void setMonth_from_org(String month_from_org) {
		this.month_from_org = month_from_org;
	}

	/**
	 * 部门接待统计结束月份取得
	 * @return 部门接待统计结束月份
	 */
	public String getMonth_to_org() {
		return month_to_org;
	}

	/**
	 * 部门接待统计结束月份设定
	 * @param month_to_org 部门接待统计结束月份
	 */
	public void setMonth_to_org(String month_to_org) {
		this.month_to_org = month_to_org;
	}

	/**
	 * 接待结束时间查询开始取得
	 * @return 接待结束时间查询开始
	 */
	public String getRetime_from() {
		return retime_from;
	}

	/**
	 * 接待结束时间查询开始设定
	 * @param retime_from 接待结束时间查询开始
	 */
	public void setRetime_from(String retime_from) {
		this.retime_from = retime_from;
	}

	/**
	 * 接待结束时间查询结束取得
	 * @return 接待结束时间查询结束
	 */
	public String getRetime_to() {
		return retime_to;
	}

	/**
	 * 接待结束时间查询结束设定
	 * @param retime_to 接待结束时间查询结束
	 */
	public void setRetime_to(String retime_to) {
		this.retime_to = retime_to;
	}

}
