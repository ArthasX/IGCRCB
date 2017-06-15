/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.Timer01Info;

/**
  * ����: timer01ʵ��
  * ��������: timer01ʵ��
  * ������¼: 2013/07/04
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="timer01")
public class Timer01TB extends BaseEntity implements Serializable,
		Cloneable, Timer01Info {

	/** uuid */
	@Id
	protected String uuid;

	/** name */
	protected String name;

	/** type */
	protected String typename;
	
	protected String collecttype;

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
	
	/** resource */
	protected Integer resourceid;
	
	
	
//	protected List<String> metricNames;
	
	
	
//
//	public List<String> getMetricNames() {
//		return metricNames;
//	}
//
//	public void setMetricNames(List<String> metricNames) {
//		this.metricNames = metricNames;
//	}

	

	public Integer getResourceid() {
		return resourceid;
	}



	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
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

	public String getTypename() {
		return typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getCollecttype() {
		return collecttype;
	}

	public void setCollecttype(String collecttype) {
		this.collecttype = collecttype;
	}

	public String getStartrule() {
		return startrule;
	}

	public void setStartrule(String startrule) {
		this.startrule = startrule;
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

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return uuid;
	}


}