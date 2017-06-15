/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.smr.form;


import com.deliverik.framework.base.BaseForm;

/**
 * 概述:核心网络系统运行情况页 form
 * 功能描述：核心网络系统运行情况页form
 * 创建人：
 * 创建记录： 2013/09/17
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0804Form extends BaseForm{

	/** 当前页数 */
	protected int pagesize;
	
	/** 查询到的信息总数 */
	protected int countall;
	
	/** 查询年 */
	protected String year;
	
	/** 查询季度 */
	protected String quarter;
	
	/** 初始查询标识 */
	protected String select_flag;
	
	/**
	 * 查询年标识
	 */
	protected String year_flag;
	
	/**
	 * 当前页数取得
	 *
	 * @return pagesize 当前页数
	 */
	public int getPagesize() {
		return pagesize;
	}

	/**
	 * 当前页数设定
	 *
	 * @param pagesize 当前页数
	 */
	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	/**
	 * 查询到的信息总数取得
	 *
	 * @return countall 查询到的信息总数
	 */
	public int getCountall() {
		return countall;
	}

	/**
	 * 查询到的信息总数设定
	 *
	 * @param countall 查询到的信息总数
	 */
	public void setCountall(int countall) {
		this.countall = countall;
	}

	/**
	 * 查询年取得
	 * @return year 查询年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 查询年设定
	 * @param year 查询年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 查询季度取得
	 * @return quarter 查询季度
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * 查询季度设定
	 * @param quarter 查询季度
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	/**
	 * 查询年标识取得
	 * @return year_flag 查询年标识
	 */
	public String getYear_flag() {
		return year_flag;
	}

	/**
	 * 查询年标识设定
	 * @param year_flag 查询年标识
	 */
	public void setYear_flag(String year_flag) {
		this.year_flag = year_flag;
	}

	/**
	 * 初始查询标识取得
	 * @return select_flag 初始查询标识
	 */
	public String getSelect_flag() {
		return select_flag;
	}

	/**
	 * 初始查询标识设定
	 * @param select_flag 初始查询标识
	 */
	public void setSelect_flag(String select_flag) {
		this.select_flag = select_flag;
	}


}
