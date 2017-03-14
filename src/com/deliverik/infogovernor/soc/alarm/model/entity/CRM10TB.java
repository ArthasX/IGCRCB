/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRM10Info;
import com.deliverik.infogovernor.soc.model.entity.CR01PK;

/**
  * ����: CRM01ʵ��
  * ��������: CRM01ʵ��
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
@Entity
@IdClass(CR01PK.class)
@SuppressWarnings("serial")
public class CRM10TB extends BaseEntity implements Serializable,
		Cloneable, CRM10Info {
	@Id
	/** host */
	protected String host;
	
	@Id
	/** ip */
	protected String ip;

	@Id
	/** servername */
	protected String servername;

	@Id
	/** servertype */
	protected Integer servertype;

	@Id
	/** collecttime */
	protected String collecttime;

	@Id
	/** command */
	protected String command;

	@Id
	/** cdataorder */
	protected Integer cdataorder;

	
	/** cdata */
	protected String cdata;

	
	/** inserttime */
	protected String inserttime;

	@Id
	/** category */
	protected String category;

	@Id
	/** keys */
	protected String keys;
	
	/** unit */
	protected String unit;

	protected String objectname;
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
	 * commandȡ��
	 *
	 * @return command
	 */
	public String getCommand() {
		return command;
	}

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
	}

	/**
	 * command�趨
	 *
	 * @param command command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * cdataorderȡ��
	 *
	 * @return cdataorder
	 */
	public Integer getCdataorder() {
		return cdataorder;
	}

	/**
	 * cdataorder�趨
	 *
	 * @param cdataorder cdataorder
	 */
	public void setCdataorder(Integer cdataorder) {
		this.cdataorder = cdataorder;
	}

	/**
	 * cdataȡ��
	 *
	 * @return cdata
	 */
	public String getCdata() {
		return cdata;
	}

	/**
	 * cdata�趨
	 *
	 * @param cdata cdata
	 */
	public void setCdata(String cdata) {
		this.cdata = cdata;
	}

	/**
	 * inserttimeȡ��
	 *
	 * @return inserttime
	 */
	public String getInserttime() {
		return inserttime;
	}

	/**
	 * inserttime�趨
	 *
	 * @param inserttime inserttime
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}

	/**
	 * categoryȡ��
	 *
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * category�趨
	 *
	 * @param category category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * keysȡ��
	 *
	 * @return keys
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * keys�趨
	 *
	 * @param keys keys
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * ��λȡ��
	 *
	 * @return keys
	 */
	public String getUnit() {
		return unit;
	}
	
	/**
	 * ��λ�趨
	 *
	 * @param unit unit
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	@Override
	public Serializable getPK() {
		// TODO Auto-generated method stub
		return null;
	}




}