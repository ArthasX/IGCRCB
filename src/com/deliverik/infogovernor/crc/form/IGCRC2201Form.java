/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**	
 * 概述:变更总体统计Form
 * 创建记录：yukexin    2014-8-15 下午5:16:37	
 * 修改记录：null
 */	
public class IGCRC2201Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** 年 */
	protected String year;

	/** 月 */
	protected String month;

	/**
	 * 年取得
	 * @return year  年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年设定
	 * @param year  年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月取得
	 * @return month  月
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月设定
	 * @param month  月
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
}
