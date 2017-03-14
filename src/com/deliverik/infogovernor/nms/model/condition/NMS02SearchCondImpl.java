/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: SNMP参数信息实体查询条件实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS02SearchCondImpl implements NMS02SearchCond{
	
	/** SNMP版本 */
	protected Integer snmpVersion;
	
	/** 端口 */
	protected Integer snmpPort;
	
	/** 读取团体字 */
	protected String readCommit;
	
	/** V3安全用户 */
	protected String snmpUser;
	
	/** V3身份验证密码 */
	protected String snmpPassword;
	
	/** 删除标识 */
	protected String deleteflag;

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
	
}
