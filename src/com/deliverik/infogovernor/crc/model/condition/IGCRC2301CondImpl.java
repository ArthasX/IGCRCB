/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.model.condition;


public class IGCRC2301CondImpl implements IGCRC2301Cond{
	
	/** 年份 */
	protected String year;
	
	/**处理标示位*/
	protected String flag;
	
	/**处理人ID*/
	protected String userid;
	
	/** 月份 */
	protected String month;

	/** 处理时间*/
	protected String propentime;
	

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

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * @return the userid
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * @param userid the userid to set
	 */
	public void setUserid(String userid) {
		this.userid = userid;
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
	
	
	
}
