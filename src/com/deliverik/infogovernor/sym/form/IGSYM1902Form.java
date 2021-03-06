package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
/**
 * 概述:作息日期模板登记画面FORM
 * 创建记录：张楠    2011/10/18
 * 功能描述：SOC原作息时间设定
 * 修改时间：LuJiayuan 2013/01/29 代码合并将原IGSYM1702Form更名IGSYM1902Form
 */
@SuppressWarnings("serial")
public class IGSYM1902Form extends BaseForm{
	/**
	 * 查询年份
	 */
	protected Integer year;

	/** 工作日期 */
	protected String pwtDate;

	/** 工作开始时间小时 */
	protected String pwtStartTimeHour;
	
	/** 工作开始时间分钟 */
	protected String pwtStartTimeMin;

	/** 工作结束时间小时 */
	protected String pwtEndTimeHour;
	
	/** 工作结束时间分钟 */
	protected String pwtEndTimeMin;

	/** 休息时间 */
	protected Integer pwtSleepTime;

	/** 有效时间 */
	protected Integer factTime;

	/**
	 * 日期获取
	 * @return
	 */
	public String getPwtDate() {
		return pwtDate;
	}

	/**
	 * 日期设定
	 * @param pwtDate
	 */
	public void setPwtDate(String pwtDate) {
		this.pwtDate = pwtDate;
	}

	/**
	 * 休息时间获取
	 * @return
	 */
	public Integer getPwtSleepTime() {
		return pwtSleepTime;
	}

	/**
	 * 休息时间设定
	 * @param pwtSleepTime
	 */
	public void setPwtSleepTime(Integer pwtSleepTime) {
		this.pwtSleepTime = pwtSleepTime;
	}

	/**
	 * 工时获取
	 * @return
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * 工时设定
	 * @param factTime
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}

	/**
	 * 查询年份获取
	 * @return
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * 查询年份设定
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * 开始时间小时获取
	 * @return
	 */
	public String getPwtStartTimeHour() {
		return pwtStartTimeHour;
	}

	/**
	 * 开始时间小时设定
	 * @param pwtStartTimeHour
	 */
	public void setPwtStartTimeHour(String pwtStartTimeHour) {
		this.pwtStartTimeHour = pwtStartTimeHour;
	}

	/**
	 * 开始时间分钟获取
	 * @return
	 */
	public String getPwtStartTimeMin() {
		return pwtStartTimeMin;
	}

	/**
	 * 开始时间分钟设定
	 * @param pwtStartTimeMin
	 */
	public void setPwtStartTimeMin(String pwtStartTimeMin) {
		this.pwtStartTimeMin = pwtStartTimeMin;
	}

	/**
	 * 结束时间小时获取
	 * @return
	 */
	public String getPwtEndTimeHour() {
		return pwtEndTimeHour;
	}

	/**
	 * 结束时间小时设定
	 * @param pwtEndTimeHour
	 */
	public void setPwtEndTimeHour(String pwtEndTimeHour) {
		this.pwtEndTimeHour = pwtEndTimeHour;
	}

	/**
	 * 结束时候分钟获取
	 * @return
	 */
	public String getPwtEndTimeMin() {
		return pwtEndTimeMin;
	}

	/**
	 * 结束时间分钟设定
	 * @param pwtEndTimeMin
	 */
	public void setPwtEndTimeMin(String pwtEndTimeMin) {
		this.pwtEndTimeMin = pwtEndTimeMin;
	}
}
