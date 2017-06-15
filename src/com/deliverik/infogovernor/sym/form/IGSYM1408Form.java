/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述: 查询条件
 * 功能描述: 查询条件
 * 创建记录: 2012/05/28
 * 修改记录: 2012/05/31
 */
@SuppressWarnings("serial")
public class IGSYM1408Form extends BaseForm{
	// 查询条件集 
	/** 模式（1-5） */
	private String mode;
	//1天
	/** 按天查询时间 */
	private String byday_date;
	//2月
	/** 按月查询时间 */
	private String bymouth_date;
	//3日对比
	/** 按天对比查询时间 */
	private String[] cds1;//select
	private String[] cms1;//select
	private String bycday_timeFrom;
	private String bycday_timeTo;
	//4月对比
	/** 按月对比查询时间 */
	private String bycmouth_date;
	//5统计查询
	/** 统计查询开始时间 */
	private String bycount_dateFrom;
	/** 统计查询结束时间 */
	private String bycount_dateTo;
	
	
	//birt params
	
	private String checkboxs;//复选框值 
	
	private String compareDate;//对比时间
	
	private String device;//对象名
	
	/** 查询复选框1 */
	private String[] checkbox1;
	/** 查询复选框1 */
	private String[] checkbox2;
	/** 查询复选框1 */
	private String[] checkbox3;
	/** 存储id */
	private String dataid;
	/** 日期从 */
	private String dateFrom;
	/** 日期到 */
	private String dateTo;
	/** 时间从 */
	private String timeFrom;
	/** 时间到 */
	private String timeTo;
	/** 时间类型 */
	private String timetype;
	/** 比较日期1 */
	private String CDate1;
	/** 比较日期2 */
	private String CDate2;
	/** 比较日期3 */
	private String CDate3;
	/** 比较日期4 */
	private String CDate4;
	/** 比较日期5 */
	private String CDate5;
	/** 报表名 */
	private String reportname;
	/** 载入路径 */
	private String reportpath;
	/**
	 * 查询条件集取得
	 *
	 * @return mode 查询条件集
	 */
	public String getMode() {
		return mode;
	}
	/**
	 * 查询条件集设定
	 *
	 * @param mode 查询条件集
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}
	/**
	 * 1天按天查取得
	 *
	 * @return byday_date 1天按天查
	 */
	public String getByday_date() {
		return byday_date;
	}
	/**
	 * 1天按天查设定
	 *
	 * @param byday_date 1天按天查
	 */
	public void setByday_date(String byday_date) {
		this.byday_date = byday_date;
	}
	/**
	 * 2月按月查取得
	 *
	 * @return bymouth_date 2月按月查
	 */
	public String getBymouth_date() {
		return bymouth_date;
	}
	/**
	 * 2月按月查设定
	 *
	 * @param bymouth_date 2月按月查
	 */
	public void setBymouth_date(String bymouth_date) {
		this.bymouth_date = bymouth_date;
	}
	/**
	 * bycday_timeFrom取得
	 *
	 * @return bycday_timeFrom bycday_timeFrom
	 */
	public String getBycday_timeFrom() {
		return bycday_timeFrom;
	}
	/**
	 * bycday_timeFrom设定
	 *
	 * @param bycday_timeFrom bycday_timeFrom
	 */
	public void setBycday_timeFrom(String bycday_timeFrom) {
		this.bycday_timeFrom = bycday_timeFrom;
	}
	/**
	 * bycday_timeTo取得
	 *
	 * @return bycday_timeTo bycday_timeTo
	 */
	public String getBycday_timeTo() {
		return bycday_timeTo;
	}
	/**
	 * bycday_timeTo设定
	 *
	 * @param bycday_timeTo bycday_timeTo
	 */
	public void setBycday_timeTo(String bycday_timeTo) {
		this.bycday_timeTo = bycday_timeTo;
	}
	/**
	 * 4月对比按月对取得
	 *
	 * @return bycmouth_date 4月对比按月对
	 */
	public String getBycmouth_date() {
		return bycmouth_date;
	}
	/**
	 * 4月对比按月对设定
	 *
	 * @param bycmouth_date 4月对比按月对
	 */
	public void setBycmouth_date(String bycmouth_date) {
		this.bycmouth_date = bycmouth_date;
	}
	/**
	 * 5统计查询统计取得
	 *
	 * @return bycount_dateFrom 5统计查询统计
	 */
	public String getBycount_dateFrom() {
		return bycount_dateFrom;
	}
	/**
	 * 5统计查询统计设定
	 *
	 * @param bycount_dateFrom 5统计查询统计
	 */
	public void setBycount_dateFrom(String bycount_dateFrom) {
		this.bycount_dateFrom = bycount_dateFrom;
	}
	/**
	 * 统计查询结束时间取得
	 *
	 * @return bycount_dateTo 统计查询结束时间
	 */
	public String getBycount_dateTo() {
		return bycount_dateTo;
	}
	/**
	 * 统计查询结束时间设定
	 *
	 * @param bycount_dateTo 统计查询结束时间
	 */
	public void setBycount_dateTo(String bycount_dateTo) {
		this.bycount_dateTo = bycount_dateTo;
	}
	/**
	 * 存储id取得
	 *
	 * @return dataid 存储id
	 */
	public String getDataid() {
		return dataid;
	}
	/**
	 * 存储id设定
	 *
	 * @param dataid 存储id
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	/**
	 * 日期从取得
	 *
	 * @return dateFrom 日期从
	 */
	public String getDateFrom() {
		return dateFrom;
	}
	/**
	 * 日期从设定
	 *
	 * @param dateFrom 日期从
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * 日期到取得
	 *
	 * @return dateTo 日期到
	 */
	public String getDateTo() {
		return dateTo;
	}
	/**
	 * 日期到设定
	 *
	 * @param dateTo 日期到
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	/**
	 * 时间从取得
	 *
	 * @return timeFrom 时间从
	 */
	public String getTimeFrom() {
		return timeFrom;
	}
	/**
	 * 时间从设定
	 *
	 * @param timeFrom 时间从
	 */
	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}
	/**
	 * 时间到取得
	 *
	 * @return timeTo 时间到
	 */
	public String getTimeTo() {
		return timeTo;
	}
	/**
	 * 时间到设定
	 *
	 * @param timeTo 时间到
	 */
	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}
	/**
	 * 时间类型取得
	 *
	 * @return timetype 时间类型
	 */
	public String getTimetype() {
		return timetype;
	}
	/**
	 * 时间类型设定
	 *
	 * @param timetype 时间类型
	 */
	public void setTimetype(String timetype) {
		this.timetype = timetype;
	}
	/**
	 * 报表名取得
	 *
	 * @return reportname 报表名
	 */
	public String getReportname() {
		return reportname;
	}
	/**
	 * 报表名设定
	 *
	 * @param reportname 报表名
	 */
	public void setReportname(String reportname) {
		this.reportname = reportname;
	}
	/**
	 * 载入路径取得
	 *
	 * @return reportpath 载入路径
	 */
	public String getReportpath() {
		return reportpath;
	}
	/**
	 * 载入路径设定
	 *
	 * @param reportpath 载入路径
	 */
	public void setReportpath(String reportpath) {
		this.reportpath = reportpath;
	}
	/**
	 * birtparams取得
	 *
	 * @return checkbox1 birtparams
	 */
	public String[] getCheckbox1() {
		return checkbox1;
	}
	/**
	 * birtparams设定
	 *
	 * @param checkbox1 birtparams
	 */
	public void setCheckbox1(String[] checkbox1) {
		this.checkbox1 = checkbox1;
	}
	/**
	 * 查询复选框1取得
	 *
	 * @return checkbox2 查询复选框1
	 */
	public String[] getCheckbox2() {
		return checkbox2;
	}
	/**
	 * 查询复选框1设定
	 *
	 * @param checkbox2 查询复选框1
	 */
	public void setCheckbox2(String[] checkbox2) {
		this.checkbox2 = checkbox2;
	}
	/**
	 * 查询复选框1取得
	 *
	 * @return checkbox3 查询复选框1
	 */
	public String[] getCheckbox3() {
		return checkbox3;
	}
	/**
	 * 查询复选框1设定
	 *
	 * @param checkbox3 查询复选框1
	 */
	public void setCheckbox3(String[] checkbox3) {
		this.checkbox3 = checkbox3;
	}
	/**
	 * 3日对比按天对取得
	 *
	 * @return cds1 3日对比按天对
	 */
	public String[] getCds1() {
		return cds1;
	}
	/**
	 * 3日对比按天对设定
	 *
	 * @param cds1 3日对比按天对
	 */
	public void setCds1(String[] cds1) {
		this.cds1 = cds1;
	}
	/**
	 * cms1取得
	 *
	 * @return cms1 cms1
	 */
	public String[] getCms1() {
		return cms1;
	}
	/**
	 * cms1设定
	 *
	 * @param cms1 cms1
	 */
	public void setCms1(String[] cms1) {
		this.cms1 = cms1;
	}
	/**
	 * cDate1取得
	 *
	 * @return cDate1 cDate1
	 */
	public String getCDate1() {
		return CDate1;
	}
	/**
	 * cDate1设定
	 *
	 * @param date1 cDate1
	 */
	public void setCDate1(String date1) {
		CDate1 = date1;
	}
	/**
	 * cDate2取得
	 *
	 * @return cDate2 cDate2
	 */
	public String getCDate2() {
		return CDate2;
	}
	/**
	 * cDate2设定
	 *
	 * @param date2 cDate2
	 */
	public void setCDate2(String date2) {
		CDate2 = date2;
	}
	/**
	 * cDate3取得
	 *
	 * @return cDate3 cDate3
	 */
	public String getCDate3() {
		return CDate3;
	}
	/**
	 * cDate3设定
	 *
	 * @param date3 cDate3
	 */
	public void setCDate3(String date3) {
		CDate3 = date3;
	}
	/**
	 * cDate4取得
	 *
	 * @return cDate4 cDate4
	 */
	public String getCDate4() {
		return CDate4;
	}
	/**
	 * cDate4设定
	 *
	 * @param date4 cDate4
	 */
	public void setCDate4(String date4) {
		CDate4 = date4;
	}
	/**
	 * cDate5取得
	 *
	 * @return cDate5 cDate5
	 */
	public String getCDate5() {
		return CDate5;
	}
	/**
	 * cDate5设定
	 *
	 * @param date5 cDate5
	 */
	public void setCDate5(String date5) {
		CDate5 = date5;
	}
	
	public String getCheckboxs() {
		return checkboxs;
	}
	public void setCheckboxs(String checkboxs) {
		this.checkboxs = checkboxs;
	}
	public String getCompareDate() {
		return compareDate;
	}
	public void setCompareDate(String compareDate) {
		this.compareDate = compareDate;
	}
	public String getDevice() {
		return device;
	}
	public void setDevice(String device) {
		this.device = device;
	}
	
	

}