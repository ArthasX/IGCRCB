/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
/**
 * 概述:作息日期变更画面FORM
 * 创建记录：张楠 2011/10/18
 * 功能描述：SOC原作息时间设定
 * 修改时间：LuJiayuan 2013/01/29 代码合并将原IGSYM1703Form更名IGSYM1903Form
 */
@SuppressWarnings("serial")
public class IGSYM1903Form extends BaseForm{
	/**
	 * 主键
	 */
	protected Integer pwtId;
	
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
	 * 主键获取
	 * @return
	 */
	public Integer getPwtId() {
		return pwtId;
	}

	/**
	 * 主键设定
	 * @param pwtId
	 */
	public void setPwtId(Integer pwtId) {
		this.pwtId = pwtId;
	}

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
	 * 结束时间分钟获取
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
