/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM07接口
  * 功能描述: CRM07接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM07Info extends BaseModel {

	/**
	 * RULECONDITIONID取得
	 *
	 * @return RULECONDITIONID
	 */
	public Integer getRuleconditionid();

	/**
	 * RULETEMPID取得
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid();

	/**
	 * ALARMMSG取得
	 *
	 * @return ALARMMSG
	 */
	public String getAlarmmsg();

	/**
	 * ALARMCONDITION取得
	 *
	 * @return ALARMCONDITION
	 */
	public Integer getAlarmcondition();
	
	public String getCreatetime();

}