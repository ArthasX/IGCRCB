/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM03Info;

/**
  * 概述: CRM03实体
  * 功能描述: CRM03实体
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="CRM03")
public class CRM03TB extends BaseEntity implements Serializable,
		Cloneable, CRM03Info {

	@Id
	/** collecttime */
	protected String collecttime;

	@Id
	/** tablename */
	protected String tablename;

	@Id
	/** host */
	protected String host;

	@Id
	/** status */
	protected String status;

	@Id
	/** type */
	protected String type;

	@Id
	/** servername */
	protected String servername;

	@Id
	/** servertype */
	protected Integer servertype;

	@Id
	/** ip */
	protected String ip;

	/**
	 * collecttime取得
	 *
	 * @return collecttime
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * collecttime设定
	 *
	 * @param collecttime collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * tablename取得
	 *
	 * @return tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * tablename设定
	 *
	 * @param tablename tablename
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * host取得
	 *
	 * @return host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * host设定
	 *
	 * @param host host
	 */
	public void setHost(String host) {
		this.host = host;
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
	public Integer getServertype() {
		return servertype;
	}

	/**
	 * servertype设定
	 *
	 * @param servertype servertype
	 */
	public void setServertype(Integer servertype) {
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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return null;
	}

}