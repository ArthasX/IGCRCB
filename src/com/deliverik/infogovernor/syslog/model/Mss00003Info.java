/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 告警规则条件表接口
  * 功能描述: 告警规则条件表接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00003Info extends BaseModel {

	/**
	 * ruleconditionid取得
	 *
	 * @return ruleconditionid
	 */
	public Integer getRuleconditionid();

	/**
	 * alarmmsg取得
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg();

	/**
	 * alarmcondition取得
	 *
	 * @return alarmcondition
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
	 * 告警级别取得
	 * @return
	 */
	public Integer getAlarmlevel();

}