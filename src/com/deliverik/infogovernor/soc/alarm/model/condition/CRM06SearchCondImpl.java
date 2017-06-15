/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM06检索条件实现
  * 功能描述: CRM06检索条件实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM06SearchCondImpl implements CRM06SearchCond {
	
	protected String serverName_like;
	
	protected String ip_like;
	
	protected String fileid_eq;
	
	private String serverName;
	
	public String getFileid_eq() {
		return fileid_eq;
	}

	public void setFileid_eq(String fileid_eq) {
		this.fileid_eq = fileid_eq;
	}

	public String getServerName_like() {
		return serverName_like;
	}

	public void setServerName_like(String serverName_like) {
		this.serverName_like = serverName_like;
	}

	public String getIp_like() {
		return ip_like;
	}

	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}

	public String getServerName() {
		return serverName;
	}
	
}