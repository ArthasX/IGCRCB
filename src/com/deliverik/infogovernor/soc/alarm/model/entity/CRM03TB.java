/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM03Info;

/**
  * ����: CRM03ʵ��
  * ��������: CRM03ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
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
	 * collecttimeȡ��
	 *
	 * @return collecttime
	 */
	public String getCollecttime() {
		return collecttime;
	}

	/**
	 * collecttime�趨
	 *
	 * @param collecttime collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * tablenameȡ��
	 *
	 * @return tablename
	 */
	public String getTablename() {
		return tablename;
	}

	/**
	 * tablename�趨
	 *
	 * @param tablename tablename
	 */
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	/**
	 * hostȡ��
	 *
	 * @return host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * host�趨
	 *
	 * @param host host
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * statusȡ��
	 *
	 * @return status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * status�趨
	 *
	 * @param status status
	 */
	public void setStatus(String status) {
		this.status = status;
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
	 * servernameȡ��
	 *
	 * @return servername
	 */
	public String getServername() {
		return servername;
	}

	/**
	 * servername�趨
	 *
	 * @param servername servername
	 */
	public void setServername(String servername) {
		this.servername = servername;
	}

	/**
	 * servertypeȡ��
	 *
	 * @return servertype
	 */
	public Integer getServertype() {
		return servertype;
	}

	/**
	 * servertype�趨
	 *
	 * @param servertype servertype
	 */
	public void setServertype(Integer servertype) {
		this.servertype = servertype;
	}

	/**
	 * ipȡ��
	 *
	 * @return ip
	 */
	public String getIp() {
		return ip;
	}

	/**
	 * ip�趨
	 *
	 * @param ip ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return null;
	}

}