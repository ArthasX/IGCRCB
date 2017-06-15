/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.condition;


import java.util.List;

import javax.persistence.Id;

/**
  * ����: timer01��������ʵ��
  * ��������: timer01��������ʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
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
	 * uuidȡ��
	 *
	 * @return uuid
	 */
	public String getUuid() {
		return uuid;
	}

	/**
	 * uuid�趨
	 *
	 * @param uuid uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	/**
	 * nameȡ��
	 *
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * name�趨
	 *
	 * @param name name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * typeȡ��
	 *
	 * @return type
	 */
	public String getType() {
		return type;
	}

	/**
	 * type�趨
	 *
	 * @param type type
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * strartruleȡ��
	 *
	 * @return strartrule
	 */
	public String getStartrule() {
		return startrule;
	}

	/**
	 * strartrule�趨
	 *
	 * @param strartrule strartrule
	 */
	public void setStartrule(String strartrule) {
		this.startrule = strartrule;
	}

	/**
	 * stopruleȡ��
	 *
	 * @return stoprule
	 */
	public String getStoprule() {
		return stoprule;
	}

	/**
	 * stoprule�趨
	 *
	 * @param stoprule stoprule
	 */
	public void setStoprule(String stoprule) {
		this.stoprule = stoprule;
	}

	/**
	 * starttimeȡ��
	 *
	 * @return starttime
	 */
	public String getStarttime() {
		return starttime;
	}

	/**
	 * starttime�趨
	 *
	 * @param starttime starttime
	 */
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}

	/**
	 * stoptimeȡ��
	 *
	 * @return stoptime
	 */
	public String getStoptime() {
		return stoptime;
	}

	/**
	 * stoptime�趨
	 *
	 * @param stoptime stoptime
	 */
	public void setStoptime(String stoptime) {
		this.stoptime = stoptime;
	}

	/**
	 * newstarttimeȡ��
	 *
	 * @return newstarttime
	 */
	public String getNewstarttime() {
		return newstarttime;
	}

	/**
	 * newstarttime�趨
	 *
	 * @param newstarttime newstarttime
	 */
	public void setNewstarttime(String newstarttime) {
		this.newstarttime = newstarttime;
	}

	/**
	 * newstoptimeȡ��
	 *
	 * @return newstoptime
	 */
	public String getNewstoptime() {
		return newstoptime;
	}

	/**
	 * newstoptime�趨
	 *
	 * @param newstoptime newstoptime
	 */
	public void setNewstoptime(String newstoptime) {
		this.newstoptime = newstoptime;
	}

	/**
	 * executstatusȡ��
	 *
	 * @return executstatus
	 */
	public String getExecutstatus() {
		return executstatus;
	}

	/**
	 * executstatus�趨
	 *
	 * @param executstatus executstatus
	 */
	public void setExecutstatus(String executstatus) {
		this.executstatus = executstatus;
	}

	/**
	 * periodtypeȡ��
	 *
	 * @return periodtype
	 */
	public String getPeriodtype() {
		return periodtype;
	}

	/**
	 * periodtype�趨
	 *
	 * @param periodtype periodtype
	 */
	public void setPeriodtype(String periodtype) {
		this.periodtype = periodtype;
	}



}