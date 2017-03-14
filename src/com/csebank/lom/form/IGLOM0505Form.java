/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */

package com.csebank.lom.form;

import com.csebank.lom.model.condition.WorkLunchEaterySearchCond;
import com.deliverik.framework.base.BaseForm;
/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 食堂管理_食堂工作餐收益统计FormBean
 * </p>
 * 
 * @author wuzhenqiu@deliverik.com
 * @version 1.0
 */

public class IGLOM0505Form extends BaseForm implements WorkLunchEaterySearchCond {
	private static final long serialVersionUID = 1L;

	/** 查询类型 */
	protected String searchtype;
	
	/** 年 */
	protected String year;

	/** 月 */
	protected String month;
	
	/** 年 */
	protected String yearD;

	/** 月 */
	protected String monthD;
	
	/** 季 */
	protected String quarter;
	
	/** 明细查询类型 */
	protected String detail;	
	
	/**
	 * 统计开始时间查询
	 */
	public String etime_from;
	
	/**
	 * 统计结束时间查询
	 */
	public String etime_to;
	
	/**
	 * 日期
	 */
	public String edate;
	
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
	 * 年
	 * @return 年
	 */
	public String getYear() {
		return year;
	}
	
	/**
	 * 年
	 * @param year 年
	 */
	public void setYear(String year) {
		this.year = year;
	}
	
	/**
	 * 月
	 * @return 月
	 */
	public String getMonth() {
		return month;
	}
	
	/**
	 * 月
	 * @param year 月
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
	/**
	 * 季
	 * @return 季
	 */
	public String getQuarter() {
		return quarter;
	}
	
	/**
	 * 季
	 * @param quarter 季
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getYearD() {
		return yearD;
	}

	public void setYearD(String yearD) {
		this.yearD = yearD;
	}

	public String getMonthD() {
		return monthD;
	}

	public void setMonthD(String monthD) {
		this.monthD = monthD;
	}
}
