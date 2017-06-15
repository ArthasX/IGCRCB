/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

import java.util.Set;

/**
  * 概述: 检查任务检索条件实现
  * 功能描述: 检查任务检索条件实现
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public class CheckWorkResultSearchCondImpl implements
		CheckWorkResultSearchCond {

	protected Integer cwrid;

	/** 检查策略id */
	protected Integer csid;

	/** 检查任务名称 */
	protected String cwrname;

	/** 任务开始时间 */
	protected String cwrplandate;
	
	/** 查询条件 任务开始时间*/
	protected String cwrplandate_from;
	
	/** 查询条件 任务开始时间*/
	protected String cwrplandate_to;

	/** 任务完成时间 */
	protected String cwrrealtime;
	
	/** 查询条件 任务完成时间*/
	protected String cwrrealtime_from;
	
	/** 查询条件，任务完成时间*/
	protected String cwrrealtime_to;

	/** 责任人id */
	protected String cwruserid;

	/** 责任人姓名 */
	protected String cwrusername;

	/** 合作责任人id */
	protected String cwrassetid;

	/** 合作责任人姓名 */
	protected String cwrassetname;

	/** 进度 */
	protected String cwrrate;
	
	/** 检查方式*/
	protected String cwrtestmode;
	
	protected String cwrid_in;
	
	protected Set<Integer> cwrid_inSet;

	/**
	 * @return the cwrid
	 */
	public Integer getCwrid() {
		return cwrid;
	}

	/**
	 * @param cwrid the cwrid to set
	 */
	public void setCwrid(Integer cwrid) {
		this.cwrid = cwrid;
	}

	/**
	 * @return the csid
	 */
	public Integer getCsid() {
		return csid;
	}

	/**
	 * @param csid the csid to set
	 */
	public void setCsid(Integer csid) {
		this.csid = csid;
	}

	/**
	 * @return the cwrname
	 */
	public String getCwrname() {
		return cwrname;
	}

	/**
	 * @param cwrname the cwrname to set
	 */
	public void setCwrname(String cwrname) {
		this.cwrname = cwrname;
	}

	/**
	 * @return the cwrplandate
	 */
	public String getCwrplandate() {
		return cwrplandate;
	}

	/**
	 * @param cwrplandate the cwrplandate to set
	 */
	public void setCwrplandate(String cwrplandate) {
		this.cwrplandate = cwrplandate;
	}

	/**
	 * @return the cwrrealtime
	 */
	public String getCwrrealtime() {
		return cwrrealtime;
	}

	/**
	 * @param cwrrealtime the cwrrealtime to set
	 */
	public void setCwrrealtime(String cwrrealtime) {
		this.cwrrealtime = cwrrealtime;
	}

	/**
	 * @return the cwruserid
	 */
	public String getCwruserid() {
		return cwruserid;
	}

	/**
	 * @param cwruserid the cwruserid to set
	 */
	public void setCwruserid(String cwruserid) {
		this.cwruserid = cwruserid;
	}

	/**
	 * @return the cwrusername
	 */
	public String getCwrusername() {
		return cwrusername;
	}

	/**
	 * @param cwrusername the cwrusername to set
	 */
	public void setCwrusername(String cwrusername) {
		this.cwrusername = cwrusername;
	}

	/**
	 * @return the cwrassetid
	 */
	public String getCwrassetid() {
		return cwrassetid;
	}

	/**
	 * @param cwrassetid the cwrassetid to set
	 */
	public void setCwrassetid(String cwrassetid) {
		this.cwrassetid = cwrassetid;
	}

	/**
	 * @return the cwrassetname
	 */
	public String getCwrassetname() {
		return cwrassetname;
	}

	/**
	 * @param cwrassetname the cwrassetname to set
	 */
	public void setCwrassetname(String cwrassetname) {
		this.cwrassetname = cwrassetname;
	}

	/**
	 * @return the cwrrate
	 */
	public String getCwrrate() {
		return cwrrate;
	}

	/**
	 * @param cwrrate the cwrrate to set
	 */
	public void setCwrrate(String cwrrate) {
		this.cwrrate = cwrrate;
	}

	/**
	 * @return the cwrtestmode
	 */
	public String getCwrtestmode() {
		return cwrtestmode;
	}

	/**
	 * @param cwrtestmode the cwrtestmode to set
	 */
	public void setCwrtestmode(String cwrtestmode) {
		this.cwrtestmode = cwrtestmode;
	}

	/**
	 * @return the cwrplandate_from
	 */
	public String getCwrplandate_from() {
		return cwrplandate_from;
	}

	/**
	 * @param cwrplandate_from the cwrplandate_from to set
	 */
	public void setCwrplandate_from(String cwrplandate_from) {
		this.cwrplandate_from = cwrplandate_from;
	}

	/**
	 * @return the cwrplandate_to
	 */
	public String getCwrplandate_to() {
		return cwrplandate_to;
	}

	/**
	 * @param cwrplandate_to the cwrplandate_to to set
	 */
	public void setCwrplandate_to(String cwrplandate_to) {
		this.cwrplandate_to = cwrplandate_to;
	}

	/**
	 * @return the cwrrealtime_from
	 */
	public String getCwrrealtime_from() {
		return cwrrealtime_from;
	}

	/**
	 * @param cwrrealtime_from the cwrrealtime_from to set
	 */
	public void setCwrrealtime_from(String cwrrealtime_from) {
		this.cwrrealtime_from = cwrrealtime_from;
	}

	/**
	 * @return the cwrrealtime_to
	 */
	public String getCwrrealtime_to() {
		return cwrrealtime_to;
	}

	/**
	 * @param cwrrealtime_to the cwrrealtime_to to set
	 */
	public void setCwrrealtime_to(String cwrrealtime_to) {
		this.cwrrealtime_to = cwrrealtime_to;
	}

	/**
	 * @return the cwrid_in
	 */
	public String getCwrid_in() {
		return cwrid_in;
	}

	/**
	 * @param cwrid_in the cwrid_in to set
	 */
	public void setCwrid_in(String cwrid_in) {
		this.cwrid_in = cwrid_in;
	}

	/**
	 * @return the cwrid_inSet
	 */
	public Set<Integer> getCwrid_inSet() {
		return cwrid_inSet;
	}

	/**
	 * @param cwrid_inSet the cwrid_inSet to set
	 */
	public void setCwrid_inSet(Set<Integer> cwrid_inSet) {
		this.cwrid_inSet = cwrid_inSet;
	}

	
	
}