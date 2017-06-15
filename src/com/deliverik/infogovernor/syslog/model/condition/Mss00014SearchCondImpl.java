/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: mss00014检索条件实现
  * 功能描述: mss00014检索条件实现
  * 创建记录: 2014/01/21
  * 修改记录: 
  */
public class Mss00014SearchCondImpl implements
		Mss00014SearchCond {
	
	protected String ip_eq;

	public String getIp_eq() {
		return ip_eq;
	}

	public void setIp_eq(String ip_eq) {
		this.ip_eq = ip_eq;
	}

}