/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 概述:月份发起
 * 功能描述：月份发起
 * 创建人：张博
 * 创建记录： 2015/09/14
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR1101Form extends BaseForm {
	
	/** 年份 */
	protected String year;

	/** 月份 */
	protected String month;
	
	/** 填报限制时间 */
	protected String limittime;

	/** 备注 */
	protected String remark;
	
	/** 是否测试发起 */
	protected String test;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * 月份取得
	 * @return 月份
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * 月份设定
	 * @param year 月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	/**
	 * 填报限制时间取得
	 *
	 * @return 填报限制时间
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 * 填报限制时间设定
	 *
	 * @param limittime 填报限制时间
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * 备注设定
	 *
	 * @param remark 备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * 是否测试发起取得
	 * 
	 * @return 是否测试发起
	 */
	public String getTest() {
		return test;
	}

	/**
	 * 是否测试发起设定
	 * 
	 * @param test 是否测试发起
	 */
	public void setTest(String test) {
		this.test = test;
	}
}
