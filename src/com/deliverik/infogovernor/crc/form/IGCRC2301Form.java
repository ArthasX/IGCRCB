/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**	
 * 概述:程序开发统计Form
 * 创建记录：yukexin    2014-8-15 下午5:17:08	
 * 修改记录：null
 */	
@SuppressWarnings("serial")
public class IGCRC2301Form extends BaseForm{
	
	/** 年份 */
	protected String year;
	
	/** 处理人用户id*/
	protected String userID;
		
	/**钻取标志位*/
	protected String flag;	

	/** 月份 */
	protected String month;

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
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
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
	
	
	
	
}
