/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: mss00013检索条件实现
  * 功能描述: mss00013检索条件实现
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
public class Mss00013SearchCondImpl implements
		Mss00013SearchCond {
	
	protected String ip_eq;
	
	protected String priority_eq;
	
	protected String content;
	
	protected String ip_like;
	
	protected String content_like;
	
	
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}
	public String getContent_like() {
		return content_like;
	}
	public void setContent_like(String content_like) {
		this.content_like = content_like;
	}
	public String[] getCvalue() {
		return cvalue;
	}
	public void setCvalue(String[] cvalue) {
		this.cvalue = cvalue;
	}
	protected  String[]cvalue;
	public String getIp_eq() {
		return ip_eq;
	}
	public void setIp_eq(String ip_eq) {
		this.ip_eq = ip_eq;
	}
	public String getPriority_eq() {
		return priority_eq;
	}
	public void setPriority_eq(String priority_eq) {
		this.priority_eq = priority_eq;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

}