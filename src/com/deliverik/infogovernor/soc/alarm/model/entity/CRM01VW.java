/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.soc.alarm.model.CRMVW01Info;

/**
 * 概述: CRM01实体 功能描述: CRM01实体 创建记录: 2013/07/30 修改记录:
 */
@SuppressWarnings("serial")
@IdClass(CRM01PK.class)
@Entity
public class CRM01VW extends BaseEntity implements Serializable, Cloneable,
		CRMVW01Info {
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

	@Id
	/** cdata */
	protected String cdata;

	/** inserttime */
	protected String inserttime;

	/** category */
	protected String category;

	/** keys */
	protected String keys;

	/** unit */
	protected String unit;

	protected String objectname;

	/** objectname获取 **/

	public String getObjectname() {
		return objectname;
	}

	public void setObjectname(String objectname) {
		this.objectname = objectname;
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
	 * @param host
	 *            host
	 */
	public void setHost(String host) {
		this.host = host;
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
	 * @param ip
	 *            ip
	 */
	public void setIp(String ip) {
		this.ip = ip;
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
	 * @param servername
	 *            servername
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
	 * @param servertype
	 *            servertype
	 */
	public void setServertype(Integer servertype) {
		this.servertype = servertype;
	}

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
	 * @param collecttime
	 *            collecttime
	 */
	public void setCollecttime(String collecttime) {
		this.collecttime = collecttime;
	}

	/**
	 * command取得
	 * 
	 * @return command
	 */
	public String getCommand() {
		return command;
	}

	/**
	 * command设定
	 * 
	 * @param command
	 *            command
	 */
	public void setCommand(String command) {
		this.command = command;
	}

	/**
	 * cdataorder取得
	 * 
	 * @return cdataorder
	 */
	public Integer getCdataorder() {
		return cdataorder;
	}

	/**
	 * cdataorder设定
	 * 
	 * @param cdataorder
	 *            cdataorder
	 */
	public void setCdataorder(Integer cdataorder) {
		this.cdataorder = cdataorder;
	}

	/**
	 * cdata取得
	 * 
	 * @return cdata
	 */
	public String getCdata() {
		return cdata;
	}

	/**
	 * cdata设定
	 * 
	 * @param cdata
	 *            cdata
	 */
	public void setCdata(String cdata) {
		this.cdata = cdata;
	}

	/**
	 * inserttime取得
	 * 
	 * @return inserttime
	 */
	public String getInserttime() {
		return inserttime;
	}

	/**
	 * inserttime设定
	 * 
	 * @param inserttime
	 *            inserttime
	 */
	public void setInserttime(String inserttime) {
		this.inserttime = inserttime;
	}

	/**
	 * category取得
	 * 
	 * @return category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * category设定
	 * 
	 * @param category
	 *            category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * keys取得
	 * 
	 * @return keys
	 */
	public String getKeys() {
		return keys;
	}

	/**
	 * keys设定
	 * 
	 * @param keys
	 *            keys
	 */
	public void setKeys(String keys) {
		this.keys = keys;
	}

	/**
	 * 单位取得
	 * 
	 * @return keys
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 单位设定
	 * 
	 * @param unit
	 *            unit
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