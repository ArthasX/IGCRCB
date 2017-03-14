/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model.condition;

/**
  * 概述: 工作管理检索条件实现
  * 功能描述: 工作管理检索条件实现
  * 创建记录: 2016/04/19
  * 修改记录: 
  */
public class WorkmanagerSearchCondImpl implements
		WorkmanagerSearchCond {

	protected Integer wmid;

	/** 工作名称 */
	protected String wmname;

	/** 描述 */
	protected String wmdesc;

	/** 完成状态(0-未完成1-已完成) */
	protected String wmstatus;
	
	/** 是否提醒0-提醒1-不再提醒  */
	protected String wmremind;

	/** 发起日期 */
	protected String wmstartdate_from;
	
	protected String wmstartdate_to;

	/** 频率 */
	protected String wmfrequency;
	
	//发起人
	protected String wmusername;
	
	/** 数据源 wmid  */
	protected String rewmid;
	
	/** 发起日期 */
	protected String wmstartdate;
	
	/**
	 * @return the 发起日期
	 */
	public String getWmstartdate() {
		return wmstartdate;
	}

	/**
	 * @param 发起日期 the wmstartdate to set
	 */
	public void setWmstartdate(String wmstartdate) {
		this.wmstartdate = wmstartdate;
	}

	/**
	 * @return the 数据源wmid
	 */
	public String getRewmid() {
		return rewmid;
	}

	/**
	 * @param 数据源wmid the rewmid to set
	 */
	public void setRewmid(String rewmid) {
		this.rewmid = rewmid;
	}

	/**
	 * @return the 频率
	 */
	public String getWmfrequency() {
		return wmfrequency;
	}

	/**
	 * @param 频率 the wmfrequency to set
	 */
	public void setWmfrequency(String wmfrequency) {
		this.wmfrequency = wmfrequency;
	}

	/**
	 * @return the wmusername
	 */
	public String getWmusername() {
		return wmusername;
	}

	/**
	 * @param wmusername the wmusername to set
	 */
	public void setWmusername(String wmusername) {
		this.wmusername = wmusername;
	}

	/**
	 * @return the wmid
	 */
	public Integer getWmid() {
		return wmid;
	}

	/**
	 * @param wmid the wmid to set
	 */
	public void setWmid(Integer wmid) {
		this.wmid = wmid;
	}

	/**
	 * @return the 工作名称
	 */
	public String getWmname() {
		return wmname;
	}

	/**
	 * @param 工作名称 the wmname to set
	 */
	public void setWmname(String wmname) {
		this.wmname = wmname;
	}

	/**
	 * @return the 描述
	 */
	public String getWmdesc() {
		return wmdesc;
	}

	/**
	 * @param 描述 the wmdesc to set
	 */
	public void setWmdesc(String wmdesc) {
		this.wmdesc = wmdesc;
	}

	/**
	 * @return the 完成状态(0-未完成1-已完成)
	 */
	public String getWmstatus() {
		return wmstatus;
	}

	/**
	 * @param 完成状态(0-未完成1-已完成) the wmstatus to set
	 */
	public void setWmstatus(String wmstatus) {
		this.wmstatus = wmstatus;
	}

	/**
	 * @return the 发起日期
	 */
	public String getWmstartdate_from() {
		return wmstartdate_from;
	}

	/**
	 * @param 发起日期 the wmstartdate_from to set
	 */
	public void setWmstartdate_from(String wmstartdate_from) {
		this.wmstartdate_from = wmstartdate_from;
	}

	/**
	 * @return the wmstartdate_to
	 */
	public String getWmstartdate_to() {
		return wmstartdate_to;
	}

	/**
	 * @param wmstartdate_to the wmstartdate_to to set
	 */
	public void setWmstartdate_to(String wmstartdate_to) {
		this.wmstartdate_to = wmstartdate_to;
	}

	/**
	 * @return the 是否提醒0-提醒1-不再提醒
	 */
	public String getWmremind() {
		return wmremind;
	}

	/**
	 * @param 是否提醒0-提醒1-不再提醒 the wmremind to set
	 */
	public void setWmremind(String wmremind) {
		this.wmremind = wmremind;
	}
	
}