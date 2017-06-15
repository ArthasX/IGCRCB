/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM04接口
  * 功能描述: CRM04接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM04Info extends BaseModel {

	/**
	 * alarmid取得
	 *
	 * @return alarmid
	 */
	public Integer getAlarmid();

	/**
	 * serverid取得
	 *
	 * @return serverid
	 */
	public Integer getServerid();

	/**
	 * ruletempid取得
	 *
	 * @return ruletempid
	 */
	public Integer getRuletempid();

	/**
	 * serverip取得
	 *
	 * @return serverip
	 */
	public String getServerip();

	/**
	 * servername取得
	 *
	 * @return servername
	 */
	public String getServername();

	/**
	 * rulelevel取得
	 *
	 * @return rulelevel
	 */
	public Integer getRulelevel();

	/**
	 * alarmtime取得
	 *
	 * @return alarmtime
	 */
	public String getAlarmtime();

	/**
	 * alarmmsg取得
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg();

	/**
	 * collecttime取得
	 *
	 * @return collecttime
	 */
	public String getCollecttime();

	/**
	 * alarmstate取得
	 *
	 * @return alarmstate
	 */
	public String getAlarmstate();
	
	/**
	 * category取得
	 *
	 * @return category
	 */
	public String getCategory();
	
	/**
	 * objectname取得
	 *
	 * @return objectname
	 */
	public String getObjectname();

}