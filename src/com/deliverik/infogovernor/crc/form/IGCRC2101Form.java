/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**	
 * 概述:人员工作统计Form
 * 创建记录：yukexin    2014-8-15 下午5:16:51	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2101Form extends BaseForm{
	
	/** 年份 */
	protected String year;
	
	/** 月份 */
	protected String month;

	/** 部门 */
	protected String department;

	protected String propentime;
	
	protected String ppinittime;
	
	/**
	 * 年份取得
	 * @return year  年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year  年份
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 月份取得
	 * @return month  月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month  月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 部门取得
	 * @return department  部门
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * 部门设定
	 * @param department  部门
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the propentime
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * @param propentime the propentime to set
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * @return the ppinittime
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * @param ppinittime the ppinittime to set
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}
	
	
	
}
