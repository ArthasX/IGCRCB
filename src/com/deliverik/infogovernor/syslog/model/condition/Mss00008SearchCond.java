/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: SYSLOG信息表检索条件接口
  * 功能描述: SYSLOG信息表检索条件接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00008SearchCond {
	
	public String getWord_like();

	public String getEname();

	public String getAlarmtime_from();

	public String getAlarmtime_to();

	public String getIp_like();
	
	public String getEsyscoding();
	
	public String[] getPriority();
	
	public String getIsalarm();
}