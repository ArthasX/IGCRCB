/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.condition;


/**
  * 概述: 风险监测表检索条件实现
  * 功能描述: 风险监测表检索条件实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class RiskMonitoringSearchCondImpl implements
		RiskMonitoringSearchCond {
	
	protected Integer rmid;

	protected Integer[] rmid_in;
	
	/** 风险策略主键id */
	protected Integer rsid;

	/** 监测任务名称 */
	protected String rmname;

	/** 计划开始时间 */
	protected String rmstartdate;
	
	/** 查询条件 计划开始时间*/
	protected String rmstartdate_from;
	
	/** 查询条件 计划开始时间*/
	protected String rmstartdate_to;

	/** 实际完成时间 */
	protected String rmenddate;
	
	/** 查询条件 实际完成时间*/
	protected String rmenddate_from;
	
	/** 查询条件 实际完成时间*/
	protected String rmenddate_to;

	/**
	 * rmid取得
	 * @return rmid  rmid
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * rmid设定
	 * @param rmid  rmid
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * 风险策略主键id取得
	 * @return rsid  风险策略主键id
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * 风险策略主键id设定
	 * @param rsid  风险策略主键id
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}

	/**
	 * 监测任务名称取得
	 * @return rmname  监测任务名称
	 */
	public String getRmname() {
		return rmname;
	}

	/**
	 * 监测任务名称设定
	 * @param rmname  监测任务名称
	 */
	public void setRmname(String rmname) {
		this.rmname = rmname;
	}

	/**
	 * 计划开始时间取得
	 * @return rmstartdate  计划开始时间
	 */
	public String getRmstartdate() {
		return rmstartdate;
	}

	/**
	 * 计划开始时间设定
	 * @param rmstartdate  计划开始时间
	 */
	public void setRmstartdate(String rmstartdate) {
		this.rmstartdate = rmstartdate;
	}

	/**
	 * 查询条件计划开始时间取得
	 * @return rmstartdate_from  查询条件计划开始时间
	 */
	public String getRmstartdate_from() {
		return rmstartdate_from;
	}

	/**
	 * 查询条件计划开始时间设定
	 * @param rmstartdate_from  查询条件计划开始时间
	 */
	public void setRmstartdate_from(String rmstartdate_from) {
		this.rmstartdate_from = rmstartdate_from;
	}

	/**
	 * 查询条件计划开始时间取得
	 * @return rmstartdate_to  查询条件计划开始时间
	 */
	public String getRmstartdate_to() {
		return rmstartdate_to;
	}

	/**
	 * 查询条件计划开始时间设定
	 * @param rmstartdate_to  查询条件计划开始时间
	 */
	public void setRmstartdate_to(String rmstartdate_to) {
		this.rmstartdate_to = rmstartdate_to;
	}

	/**
	 * 实际完成时间取得
	 * @return rmenddate  实际完成时间
	 */
	public String getRmenddate() {
		return rmenddate;
	}

	/**
	 * 实际完成时间设定
	 * @param rmenddate  实际完成时间
	 */
	public void setRmenddate(String rmenddate) {
		this.rmenddate = rmenddate;
	}

	/**
	 * 查询条件实际完成时间取得
	 * @return rmenddate_from  查询条件实际完成时间
	 */
	public String getRmenddate_from() {
		return rmenddate_from;
	}

	/**
	 * 查询条件实际完成时间设定
	 * @param rmenddate_from  查询条件实际完成时间
	 */
	public void setRmenddate_from(String rmenddate_from) {
		this.rmenddate_from = rmenddate_from;
	}

	/**
	 * 查询条件实际完成时间取得
	 * @return rmenddate_to  查询条件实际完成时间
	 */
	public String getRmenddate_to() {
		return rmenddate_to;
	}

	/**
	 * 查询条件实际完成时间设定
	 * @param rmenddate_to  查询条件实际完成时间
	 */
	public void setRmenddate_to(String rmenddate_to) {
		this.rmenddate_to = rmenddate_to;
	}

	/**
	 * rmid_in取得
	 * @return rmid_in  rmid_in
	 */
	public Integer[] getRmid_in() {
		return rmid_in;
	}

	/**
	 * rmid_in设定
	 * @param rmid_in  rmid_in
	 */
	public void setRmid_in(Integer[] rmid_in) {
		this.rmid_in = rmid_in;
	}


}