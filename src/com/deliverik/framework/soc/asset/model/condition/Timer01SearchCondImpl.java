/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;


import java.util.List;

import javax.persistence.Id;

/**
  * 概述: timer01检索条件实现
  * 功能描述: timer01检索条件实现
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public class Timer01SearchCondImpl implements
		Timer01SearchCond {
	
	/** uuid */
	@Id
	protected String uuid;

	/** name */
	protected String name;

	/** type */
	protected String type;

	/** strartrule */
	protected String startrule;

	/** stoprule */
	protected String stoprule;

	/** starttime */
	protected String starttime;

	/** stoptime */
	protected String stoptime;

	/** newstarttime */
	protected String newstarttime;

	/** newstoptime */
	protected String newstoptime;

	/** executstatus */
	protected String executstatus;

	/** periodtype */
	protected String periodtype;
	
	protected Integer resourceid_eq;
	
	/** typeNames */
	protected List<String> typeNames_Notin;
	
	protected List<String> typeNames_In;
	
	protected List<Integer> resourceid_Notin;
	
	public Integer getResourceid_eq() {
		return resourceid_eq;
	}

	public void setResourceid_eq(Integer resourceid_eq) {
		this.resourceid_eq = resourceid_eq;
	}

	public List<Integer> getResourceid_Notin() {
		return resourceid_Notin;
	}

	public void setResourceid_Notin(List<Integer> resourceid_Notin) {
		this.resourceid_Notin = resourceid_Notin;
	}

	public List<String> getTypeNames_In() {
		return typeNames_In;
	}

	public void setTypeNames_In(List<String> typeNames_In) {
		this.typeNames_In = typeNames_In;
	}

	public List<String> getTypeNames_Notin() {
		return typeNames_Notin;
	}

	public void setTypeNames_Notin(List<String> typeNames_Notin) {
		this.typeNames_Notin = typeNames_Notin;
	}

	/**
	 * uuid取得
	 *
	 * @return uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * uuid设定
	 *
	 * @param uuid uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * name取得
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name设定
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * type取得
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * type设定
	 *
	 * @param type type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * strartrule取得
	 *
	 * @return strartrule
	 */
	public String getStartrule() {
		return startrule;
	}

	/**
	 * strartrule设定
	 *
	 * @param strartrule strartrule
	 */
	public void setStartrule(String strartrule) {
		this.startrule = strartrule;
	}

	/**
	 * stoprule取得
	 *
	 * @return stoprule
	 */
	public String getStoprule() {
		return stoprule;
	}

	/**
	 * stoprule设定
	 *
	 * @param stoprule stoprule
	 */
	public void setStoprule(String stoprule) {
		this.stoprule = stoprule;
	}

	/**
	 * starttime取得
	 *
	 * @return starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * starttime设定
	 *
	 * @param starttime starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * stoptime取得
	 *
	 * @return stoptime
	 */
	public String getStoptime() {
		return stoptime;
	}

	/**
	 * stoptime设定
	 *
	 * @param stoptime stoptime
	 */
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	/**
	 * newstarttime取得
	 *
	 * @return newstarttime
	 */
	public String getNewstarttime() {
		return newstarttime;
	}

	/**
	 * newstarttime设定
	 *
	 * @param newstarttime newstarttime
	 */
	public void setNewstarttime(String newstarttime) {
		this.newstarttime = newstarttime;
	}

	/**
	 * newstoptime取得
	 *
	 * @return newstoptime
	 */
	public String getNewstoptime() {
		return newstoptime;
	}

	/**
	 * newstoptime设定
	 *
	 * @param newstoptime newstoptime
	 */
	public void setNewstoptime(String newstoptime) {
		this.newstoptime = newstoptime;
	}

	/**
	 * executstatus取得
	 *
	 * @return executstatus
	 */
	public String getExecutstatus() {
		return executstatus;
	}

	/**
	 * executstatus设定
	 *
	 * @param executstatus executstatus
	 */
	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	/**
	 * periodtype取得
	 *
	 * @return periodtype
	 */
	public String getPeriodtype() {
		return periodtype;
	}

	/**
	 * periodtype设定
	 *
	 * @param periodtype periodtype
	 */
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}



}