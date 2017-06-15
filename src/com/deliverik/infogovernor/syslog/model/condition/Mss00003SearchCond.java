/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: 告警规则条件表检索条件接口
  * 功能描述: 告警规则条件表检索条件接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00003SearchCond {
	/**
	 * ruleconditionid取得
	 */
	public Integer getRuleconditionid() ;
	
	/**
	 * alarmmsg取得
	 */
	public String getAlarmmsg();
	
	/**
	 * alarmcondition取得
	 */
	public Integer getAlarmcondition();
	
	/**
	 * 规则模板id取得
	 */
	public Integer getRuletempid();
	
	/**
	 * 创建时间取得
	 */
	public String getCreatetime();
	
	/**
	 * 是否是模板标示取得
	 */
	public String getIsTemp();
}