/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

import com.deliverik.framework.soc.asset.model.CicollecttaskInfo;

/**
  * 概述: cicollecttask实体
  * 功能描述: cicollecttask实体
  * 创建记录: 2013/07/05
  * @author 王省
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
	
	/** 平台名 */
	protected String platformname;
	
	/** server名 */
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
//	 * typeid取得
//	 *
//	 * @return typeid
//	 */
//	public Integer getTypeid() {
//		return typeid;
//	}

//	/**
//	 * typeid设定
//	 *
//	 * @param typeid typeid
//	 */
//	public void setTypeid(Integer typeid) {
//		this.typeid = typeid;
//	}

	/**
	 * typename取得
	 *
	 * @return typename
	 */
	public String getTypename() {
		return typename;
	}

	/**
	 * typename设定
	 *
	 * @param typename typename
	 */
	public void setTypename(String typename) {
		this.typename = typename;
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
	 * startrule取得
	 *
	 * @return startrule
	 */
	public String getStartrule() {
		return startrule;
	}

	/**
	 * startrule设定
	 *
	 * @param startrule startrule
	 */
	public void setStartrule(String startrule) {
		this.startrule = startrule;
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