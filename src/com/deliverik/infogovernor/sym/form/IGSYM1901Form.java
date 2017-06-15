/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
/**
 * 概述:作息日期模板查询画面FORM
 * 创建记录：张楠    2011/10/18
 * 功能描述：SOC原作息时间设定
 * 修改时间：LuJiayuan 2013/01/29 代码合并将原IGSYM1701Form更名IGSYM1901Form
 */
@SuppressWarnings("serial")
public class IGSYM1901Form extends BaseForm {
	
	/**
	 * 查询年
	 */
	protected Integer year;
	
	/**
	 * 查询月
	 */
	protected Integer month;

	/**
	 * 查询年获取
	 * @return
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * 查询年设定
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * 查询月获取
	 * @return
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * 查询月设定
	 * @param month
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

}
