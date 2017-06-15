/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:定时提醒设置 
 * 功能描述：定时提醒设置 
 * 创建人：赵梓廷
 * 创建记录： 2013-08-05
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0303Form extends BaseForm {

	/** 月 */
	protected String rcmonth;

	/** 日 */
	protected String rcday;

	/** 类型 */
	protected String rctype;
	
	/** 年报的月 */
	protected String year_m;
	
	/** 年报的日 */
	protected String year_d;
	
	/** 一季度的月 */
	protected String month1_m;
	
	/** 一季度的日*/
	protected String month1_d;
	
	/** 二季度的月 */
	protected String month2_m;
	
	/** 二季度的日*/
	protected String month2_d;
	
	/** 三季度的月 */
	protected String month3_m;
	
	/** 三季度的日*/
	protected String month3_d;
	
	/** 四季度的月 */
	protected String month4_m;
	
	/** 四季度的日*/
	protected String month4_d;
	/**
	 * 月取得
	 *
	 * @return 月
	 */
	public String getRcmonth() {
		return rcmonth;
	}

	/**
	 * 月设定
	 *
	 * @param rcmonth 月
	 */
	public void setRcmonth(String rcmonth) {
		this.rcmonth = rcmonth;
	}

	/**
	 * 日取得
	 *
	 * @return 日
	 */
	public String getRcday() {
		return rcday;
	}

	/**
	 * 日设定
	 *
	 * @param rcday 日
	 */
	public void setRcday(String rcday) {
		this.rcday = rcday;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRctype() {
		return rctype;
	}

	/**
	 * 类型设定
	 *
	 * @param rctype 类型
	 */
	public void setRctype(String rctype) {
		this.rctype = rctype;
	}

	public String getYear_m() {
		return year_m;
	}

	public void setYear_m(String year_m) {
		this.year_m = year_m;
	}

	public String getYear_d() {
		return year_d;
	}

	public void setYear_d(String year_d) {
		this.year_d = year_d;
	}

	public String getMonth1_m() {
		return month1_m;
	}

	public void setMonth1_m(String month1_m) {
		this.month1_m = month1_m;
	}

	public String getMonth1_d() {
		return month1_d;
	}

	public void setMonth1_d(String month1_d) {
		this.month1_d = month1_d;
	}

	public String getMonth2_m() {
		return month2_m;
	}

	public void setMonth2_m(String month2_m) {
		this.month2_m = month2_m;
	}

	public String getMonth2_d() {
		return month2_d;
	}

	public void setMonth2_d(String month2_d) {
		this.month2_d = month2_d;
	}

	public String getMonth3_m() {
		return month3_m;
	}

	public void setMonth3_m(String month3_m) {
		this.month3_m = month3_m;
	}

	public String getMonth3_d() {
		return month3_d;
	}

	public void setMonth3_d(String month3_d) {
		this.month3_d = month3_d;
	}

	public String getMonth4_m() {
		return month4_m;
	}

	public void setMonth4_m(String month4_m) {
		this.month4_m = month4_m;
	}

	public String getMonth4_d() {
		return month4_d;
	}

	public void setMonth4_d(String month4_d) {
		this.month4_d = month4_d;
	}
	
}
