/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 表空间伐值设定检索条件实现
  * 功能描述: 表空间伐值设定检索条件实现
  * 创建记录: 
  * 修改记录: 
  */
public class SOC0501SearchCondImpl implements
SOC0501SearchCond {
	
	private String pwdType;
	private String userName;
	private String serverIP;
	private Integer pid;
	
	
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public void setPwdType(String pwdType) {
		this.pwdType = pwdType;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setServerIP(String serverIP) {
		this.serverIP = serverIP;
	}
	public String getPwdType() {
		return pwdType;
	}
	public String getUserName() {
		return userName;
	}
	public String getServerIP() {
		return serverIP;
	}
	

	
}