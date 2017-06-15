/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:科技运行综合分析二Form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDBM1202Form extends BaseForm{

	/** 年份 */
	protected String year;
	
	/** 月份 */
	protected String month;
	
	/** 时间标识 */
	protected String date;
	/**
	 * 年份取得
	 * @return year 年份
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
	 * 月份取得
	 * @return month 月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month 月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 时间标识取得
	 * @return date 时间标识
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 时间标识设定
	 * @param date 时间标识
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
