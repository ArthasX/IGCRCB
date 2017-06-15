/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM06VWInfo;

/**
  * 概述: CRM06实体
  * 功能描述: CRM06实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
public class CRM06VW extends BaseEntity implements Serializable,Cloneable, CRM06VWInfo {

	/** serverid */
	@Id
	protected Integer serverid;

	/** fileid */
	protected Integer fileid;

	/** servername */
	protected String servername;

	/** servertype */
	protected String servertype;

	/** ip */
	protected String ip;
	
	/** ip2 */
	protected String ip2;

	/** status */
	protected String status;
	
	protected String host;
	
	/** 规则个数 */
	protected Integer tempcounts;
	
	/** 是否生成告警 */
	protected String alarmstatus;
	
	private Integer hqserverid;
	
	private String hqservername;
	
	public String getAlarmstatus() {
		return alarmstatus;
	}

	public void setAlarmstatus(String alarmstatus) {
		this.alarmstatus = alarmstatus;
	}

	public Integer getTempcounts() {
		return tempcounts;
	}

	public void setTempcounts(Integer tempcounts) {
		this.tempcounts = tempcounts;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * serverid取得
	 *
	 * @return serverid
	 */
	public Integer getServerid() {
		return serverid;
	}

	/**
	 * serverid设定
	 *
	 * @param serverid serverid
	 */
	public void setServerid(Integer serverid) {
		this.serverid = serverid;
	}

	/**
	 * fileid取得
	 *
	 * @return fileid
	 */
	public Integer getFileid() {
		return fileid;
	}

	/**
	 * fileid设定
	 *
	 * @param fileid fileid
	 */
	public void setFileid(Integer fileid) {
		this.fileid = fileid;
	}

	/**
	 * servername取得
	 *
	 * @return servername
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * servername设定
	 *
	 * @param servername servername
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * servertype取得
	 *
	 * @return servertype
	 */
	public String getServertype() {
		return servertype;
	}

	/**
	 * servertype设定
	 *
	 * @param servertype servertype
	 */
	public void setServertype(String servertype) {
		this.servertype = servertype;
	}

	/**
	 * ip取得
	 *
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip设定
	 *
	 * @param ip ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * status取得
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * status设定
	 *
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return serverid;
	}

	public String getIp2() {
		return ip2;
	}

	public void setIp2(String ip2) {
		this.ip2 = ip2;
	}

	public Integer getHqserverid() {
		return hqserverid;
	}

	public void setHqserverid(Integer hqserverid) {
		this.hqserverid = hqserverid;
	}

	public String getHqservername() {
		return hqservername;
	}

	public void setHqservername(String hqservername) {
		this.hqservername = hqservername;
	}
	
}