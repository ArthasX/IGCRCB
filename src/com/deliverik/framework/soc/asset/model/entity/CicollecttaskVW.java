/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;

/**
  * ����: cicollecttaskʵ��
  * ��������: cicollecttaskʵ��
  * ������¼: 2013/07/05
  * @author ��ʡ
  */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class CicollecttaskVW implements Serializable,Cloneable, CicollecttaskInfo {

//	/** typeid */
//	protected Integer typeid;

	/** typename */
	protected String typename;

	/** uuid */
	protected String uuid;

	/** name */
	protected String name;

	/** startrule */
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
	
	/** ƽ̨�� */
	protected String platformname;
	
	/** server�� */
	protected String servername;
	
	@Id
	protected Integer resourceid;
	

	public String getPlatformname() {
		return platformname;
	}

	public void setPlatformname(String platformname) {
		this.platformname = platformname;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	public Integer getResourceid() {
		return resourceid;
	}

	public void setResourceid(Integer resourceid) {
		this.resourceid = resourceid;
	}

//	/**
//	 * typeidȡ��
//	 *
//	 * @return typeid
//	 */
//	public Integer getTypeid() {
//		return typeid;
//	}

//	/**
//	 * typeid�趨
//	 *
//	 * @param typeid typeid
//	 */
//	public void setTypeid(Integer typeid) {
//		this.typeid = typeid;
//	}

	/**
	 * typenameȡ��
	 *
	 * @return typename
	 */
	public String getTypename() {
		return typename;
	}

	/**
	 * typename�趨
	 *
	 * @param typename typename
	 */
	public void setTypename(String typename) {
		this.typename = typename;
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
	 * startruleȡ��
	 *
	 * @return startrule
	 */
	public String getStartrule() {
		return startrule;
	}

	/**
	 * startrule�趨
	 *
	 * @param startrule startrule
	 */
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
}