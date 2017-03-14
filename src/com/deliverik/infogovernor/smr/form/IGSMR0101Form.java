/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 年报发起Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0101Form extends BaseForm {
	
	/** 年份 */
	protected String year;
	
	/** 填报限制时间 */
	protected String limittime;

	/** 备注 */
	protected String remark;
	
	/** 是否测试发起 */
	protected String test;

	/**
	 * 年份取得
	 * @return 年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year 年份
	 */
	public void setYear(String year) {
		this.year = year;
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