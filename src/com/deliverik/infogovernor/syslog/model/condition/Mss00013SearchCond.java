/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: mss00013检索条件接口
  * 功能描述: mss00013检索条件接口
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
public interface Mss00013SearchCond {
	
	public String getIp_eq();

	public String getPriority_eq();
	
	public String getContent();
	
	public String[] getCvalue();
	
	public String getIp_like();
	
	public String getContent_like();
	
}