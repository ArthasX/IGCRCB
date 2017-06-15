/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0501Info;

/**
 * 概述: 表空间伐值设定 功能描述: 表空间伐值实体 创建记录: 修改记录:
 */
@Entity
@Table(name = "SOC0501", schema = "ig")
public class SOC0501TB extends BaseEntity implements SOC0501Info, Serializable,
		Cloneable {
	@Id
	@SequenceGenerator(
			name="SOC0501_GENERATOR", sequenceName="SOC0501_SEQ", 
			initialValue=1, allocationSize=1
		)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="SOC0501_GENERATOR")
	private Integer pid;
	private String pwdType;
	private String userName;
	private String pwd;
	private String pwdDescription;
	private String regDate;
	private String serverIP;
	
	public Integer getPid() {
		return pid;
	}

	public String getServerIP() {
		return serverIP;
	}



	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}



	



	public void setPid(Integer pid) {
		this.pid = pid;
	}



	public String getPwdType() {
		return pwdType;
	}



	public void setPwdType(String pwdType) {
		this.pwdType = pwdType;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getPwd() {
		return pwd;
	}



	public void setPwd(String pwd) {
		this.pwd = pwd;
	}



	public String getPwdDescription() {
		return pwdDescription;
	}



	public void setPwdDescription(String pwdDescription) {
		this.pwdDescription = pwdDescription;
	}



	public String getRegDate() {
		return regDate;
	}



	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}



	@Override
	public Serializable getPK() {
		return this.pid;
	}

}