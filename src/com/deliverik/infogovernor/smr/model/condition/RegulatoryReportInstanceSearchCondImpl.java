/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;


/**
  * 概述: 报表填报实例表检索条件实现
  * 功能描述: 报表填报实例表检索条件实现
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public class RegulatoryReportInstanceSearchCondImpl implements
		RegulatoryReportInstanceSearchCond {

	/** 组标识 */
	protected String key_eq;

	/** 状态：0开启，1关闭，2中止 */
	protected String status_eq = "0";
	
	/** 当前登录人userid*/
	protected String userid;
	
	/** 流程状态名*/
	protected String psdname;
	
	/** 流程类型*/
	protected String prtype;
	
	/** 实例id*/
	protected Integer instanceid ;
	
	/** 发起人*/
	protected String inituser ;
	
	/** 发起开始时间 */
	protected String propentime;
	
	/** 发起结束时间 */
	protected String proclosetime;
	
	/** 排序标识*/
	protected String orderby;
	
	/** 流程名称*/
	protected String prtitle;
	
	/** 流程类型ID左匹配 */
	protected String prpdid_like;	

	/** 季度降序排序标识*/
	protected String orderby_quarter;
	
	/** 季度报表状态*/
	protected String prstatus;

	/** 季度标识 */
	private String quarter;
	

	/** 季度查询年 */
	private String year;

	/** 季度年查询大于等于 */
	private String year_GtEq;
	/** 月份标志 */
	private String month;
	
	/**填报人*/
	private String reportman;
	
	/**填报部门*/
	private String reportdepartment;
	
	
	
	/**  
	 * 获取reportman  
	 * @return reportman 
	 */
	public String getReportman() {
		return reportman;
	}

	/**  
	 * 设置reportman  
	 * @param reportman
	 */
	
	public void setReportman(String reportman) {
		this.reportman = reportman;
	}

	/**  
	 * 获取reportdepartment  
	 * @return reportdepartment 
	 */
	public String getReportdepartment() {
		return reportdepartment;
	}

	/**  
	 * 设置reportdepartment  
	 * @param reportdepartment
	 */
	
	public void setReportdepartment(String reportdepartment) {
		this.reportdepartment = reportdepartment;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 季度报表状态取得
	 *
	 * @return prstatus 季度报表状态
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * 季度报表状态设定
	 *
	 * @param prstatus 季度报表状态
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * 组标识取得
	 *
	 * @return 组标识
	 */
	public String getKey_eq() {
		return key_eq;
	}

	/**
	 * 组标识设定
	 *
	 * @param key_eq 组标识
	 */
	public void setKey_eq(String key_eq) {
		this.key_eq = key_eq;
	}

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getStatus_eq() {
		return status_eq;
	}

	/**
	 * 状态设定
	 *
	 * @param status_eq 状态
	 */
	public void setStatus_eq(String status_eq) {
		this.status_eq = status_eq;
	}

	/**
	 * 当前登录人userid取得
	 *
	 * @return 当前登录人userid
	 */
	public String getUserid() {
		return userid;
	}
	/**
	 * 当前登录人userid 设定
	 *
	 * @param userid 当前登录人userid 
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	/**
	 * 流程状态名取得
	 *
	 * @return 流程状态名
	 */
	public String getPsdname() {
		return psdname;
	}
	/**
	 * 流程状态名 设定
	 *
	 * @param psdname 流程状态名
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}
	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}
	/**
	 * 流程类型 设定
	 *
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}
	/**
	 * 实例id取得
	 *
	 * @return 实例id
	 */
	public Integer getInstanceid() {
		return instanceid;
	}
	/**
	 * 实例id设定
	 *
	 * @param instanceid 实例id
	 */
	public void setInstanceid(Integer instanceid) {
		this.instanceid = instanceid;
	}

	public String getInituser() {
		return inituser;
	}

	public void setInituser(String inituser) {
		this.inituser = inituser;
	}

	/**
	 *发起开始时间取得
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 *发起开始时间设定
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 *发起结束时间取得
	 */
	public String getProclosetime() {
		return proclosetime;
	}

	/**
	 *发起结束时间设定
	 */
	public void setProclosetime(String proclosetime) {
		this.proclosetime = proclosetime;
	}

	public String getOrderby() {
		return orderby;
	}

	public void setOrderby(String orderby) {
		this.orderby = orderby;
	}

	public String getPrtitle() {
		return prtitle;
	}

	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * 流程类型ID左匹配取得
	 *
	 * @return prpdid_like 流程类型ID左匹配
	 */
	public String getPrpdid_like() {
		return prpdid_like;
	}

	/**
	 * 流程类型ID左匹配设定
	 *
	 * @param prpdid_like 流程类型ID左匹配
	 */
	public void setPrpdid_like(String prpdid_like) {
		this.prpdid_like = prpdid_like;
	}

	/**
	 * 季度降序排序标识取得
	 *
	 * @return orderby_quarter 季度降序排序标识
	 */
	public String getOrderby_quarter() {
		return orderby_quarter;
	}

	/**
	 * 季度降序排序标识设定
	 *
	 * @param orderby_quarter 季度降序排序标识
	 */
	public void setOrderby_quarter(String orderby_quarter) {
		this.orderby_quarter = orderby_quarter;
	}

	/**
	 * 季度标识取得
	 * @return quarter 季度标识
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * 季度标识设定
	 * @param quarter 季度标识
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	/**
	 * 季度查询年取得
	 * @return year 季度查询年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 季度查询年设定
	 * @param year 季度查询年
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 季度年查询大于等于取得
	 * @return year_GtEq 季度年查询大于等于
	 */
	public String getYear_GtEq() {
		return year_GtEq;
	}

	/**
	 * 季度年查询大于等于设定
	 * @param year_GtEq 季度年查询大于等于
	 */
	public void setYear_GtEq(String year_GtEq) {
		this.year_GtEq = year_GtEq;
	}

	public String getMonth() {
		// TODO Auto-generated method stub
		return month;
	}


	
}