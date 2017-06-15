/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.infogovernor.nms.model.NMS02Info;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: SNMP参数信息实体
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="NMS02")
public class NMS02TB extends BaseEntity implements NMS02Info , LogicalDelete{

	/** 主键 */
	@Id
	protected String id;
	
	/** SNMP版本 */
	protected Integer snmpVersion;
	
	/** 端口 */
	protected Integer snmpPort;
	
	/** 读取团体字 */
	protected String readCommit;
	
	/** 写入团体字 */
	protected String writeCommit;
	
	/** 是否启用SNMP代理 */
	protected String isEnableSnmpProxy;
	
	/** 代理IP */
	protected String snmpProxyIP;
	
	/** V3安全级别 */
	protected String snmpSecurityLevel;
	
	/** V3安全用户 */
	protected String snmpUser;
	
	/** V3上下文名称 */
	protected String snmpSecurityContext;
	
	/** V3身份验证协议 */
	protected String snmpAuthType;
	
	/** V3身份验证密码 */
	protected String snmpPassword;
	
	/** V3隐私协议 */
	protected String snmpPrivacyType;
	
	/** V3隐私密码 */
	protected String snmpPrivacyPassPhrase;
	
	/** 创建时间 */
	protected String instime;
	
	/** 删除标识 */
	protected String deleteflag;
	
	/**
	 * 主键取得
	 * @return 主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键设定
	 * @param id 主键
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * SNMP版本取得
	 * @return SNMP版本
	 */
	public Integer getSnmpVersion() {
		return snmpVersion;
	}

	/**
	 * SNMP版本设定
	 * @param snmpVersion SNMP版本
	 */
	public void setSnmpVersion(Integer snmpVersion) {
		this.snmpVersion = snmpVersion;
	}

	/**
	 * 端口取得
	 * @return 端口
	 */
	public Integer getSnmpPort() {
		return snmpPort;
	}

	/**
	 * 端口设定
	 * @param snmpPort 端口
	 */
	public void setSnmpPort(Integer snmpPort) {
		this.snmpPort = snmpPort;
	}

	/**
	 * 读取团体字取得
	 * @return 读取团体字
	 */
	public String getReadCommit() {
		return readCommit;
	}

	/**
	 * 读取团体字设定
	 * @param readCommit 读取团体字
	 */
	public void setReadCommit(String readCommit) {
		this.readCommit = readCommit;
	}

	/**
	 * 写入团体字取得
	 * @return 写入团体字
	 */
	public String getWriteCommit() {
		return writeCommit;
	}

	/**
	 * 写入团体字设定
	 * @param writeCommit 写入团体字
	 */
	public void setWriteCommit(String writeCommit) {
		this.writeCommit = writeCommit;
	}

	/**
	 * 是否启用SNMP代理取得
	 * @return 是否启用SNMP代理
	 */
	public String getIsEnableSnmpProxy() {
		return isEnableSnmpProxy;
	}

	/**
	 * 是否启用SNMP代理设定
	 * @param isEnableSnmpProxy 是否启用SNMP代理
	 */
	public void setIsEnableSnmpProxy(String isEnableSnmpProxy) {
		this.isEnableSnmpProxy = isEnableSnmpProxy;
	}

	/**
	 * 代理IP取得
	 * @return 代理IP
	 */
	public String getSnmpProxyIP() {
		return snmpProxyIP;
	}

	/**
	 * 代理IP设定
	 * @param snmpProxyIP 代理IP
	 */
	public void setSnmpProxyIP(String snmpProxyIP) {
		this.snmpProxyIP = snmpProxyIP;
	}

	/**
	 * V3安全级别取得
	 * @return V3安全级别
	 */
	public String getSnmpSecurityLevel() {
		return snmpSecurityLevel;
	}

	/**
	 * V3安全级别设定
	 * @param snmpSecurityLevel V3安全级别
	 */
	public void setSnmpSecurityLevel(String snmpSecurityLevel) {
		this.snmpSecurityLevel = snmpSecurityLevel;
	}

	/**
	 * V3安全用户取得
	 * @return V3安全用户
	 */
	public String getSnmpUser() {
		return snmpUser;
	}

	/**
	 * V3安全用户设定
	 * @param snmpUser V3安全用户
	 */
	public void setSnmpUser(String snmpUser) {
		this.snmpUser = snmpUser;
	}

	/**
	 * V3上下文名称取得
	 * @return V3上下文名称
	 */
	public String getSnmpSecurityContext() {
		return snmpSecurityContext;
	}

	/**
	 * V3上下文名称设定
	 * @param snmpSecurityContext V3上下文名称
	 */
	public void setSnmpSecurityContext(String snmpSecurityContext) {
		this.snmpSecurityContext = snmpSecurityContext;
	}

	/**
	 * V3身份验证协议取得
	 * @return V3身份验证协议
	 */
	public String getSnmpAuthType() {
		return snmpAuthType;
	}

	/**
	 * V3身份验证协议设定
	 * @param snmpAuthType V3身份验证协议
	 */
	public void setSnmpAuthType(String snmpAuthType) {
		this.snmpAuthType = snmpAuthType;
	}

	/**
	 * V3身份验证密码取得
	 * @return V3身份验证密码
	 */
	public String getSnmpPassword() {
		return snmpPassword;
	}

	/**
	 * V3身份验证密码设定
	 * @param snmpPassword V3身份验证密码
	 */
	public void setSnmpPassword(String snmpPassword) {
		this.snmpPassword = snmpPassword;
	}

	/**
	 * V3隐私协议取得
	 * @return V3隐私协议
	 */
	public String getSnmpPrivacyType() {
		return snmpPrivacyType;
	}

	/**
	 * V3隐私协议设定
	 * @param snmpPrivacyType V3隐私协议
	 */
	public void setSnmpPrivacyType(String snmpPrivacyType) {
		this.snmpPrivacyType = snmpPrivacyType;
	}

	/**
	 * V3隐私密码取得
	 * @return V3隐私密码
	 */
	public String getSnmpPrivacyPassPhrase() {
		return snmpPrivacyPassPhrase;
	}

	/**
	 * V3隐私密码设定
	 * @param snmpPrivacyPassPhrase V3隐私密码
	 */
	public void setSnmpPrivacyPassPhrase(String snmpPrivacyPassPhrase) {
		this.snmpPrivacyPassPhrase = snmpPrivacyPassPhrase;
	}

	/**
	 * 创建时间取得
	 * @return 创建时间
	 */
	public String getInstime() {
		return instime;
	}

	/**
	 * 创建时间设定
	 * @param instime 创建时间
	 */
	public void setInstime(String instime) {
		this.instime = instime;
	}
	
	/**
	 * 删除标识取得
	 * @return 删除标识
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 删除标识设定
	 * @param deleteflag 删除标识
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.id;
	}
}
