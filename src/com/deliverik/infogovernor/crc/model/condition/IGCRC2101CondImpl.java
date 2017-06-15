/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.condition;


public class IGCRC2101CondImpl implements IGCRC2101Cond{
	
	/** 年份 */
	protected String year;
	
	/** 月份 */
	protected String month;

	/** 部门 */
	protected String department;
	
	protected String propentime;
	
	protected String ppinittime;
	
	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}
	
	public String getDepartment() {
		return department;
	}

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
