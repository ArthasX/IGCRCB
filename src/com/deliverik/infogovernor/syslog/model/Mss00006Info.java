/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;


import java.util.Date;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 告警信息月表接口
  * 功能描述: 告警信息月表接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00006Info extends BaseModel {

	/**
	 * alarmid取得
	 *
	 * @return alarmid
	 */
	public Integer getAlarmid();

	/**
	 * deviceid取得
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

	/**
	 * deviceip取得
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

	/**
	 * devicename取得
	 *
	 * @return devicename
	 */
	public String getDevicename();

	/**
	 * ruleid取得
	 *
	 * @return ruleid
	 */
	public Integer getRuleid();

	/**
	 * ruleconditionid取得
	 *
	 * @return ruleconditionid
	 */
	public Integer getRuleconditionid();

	/**
	 * rulelevel取得
	 *
	 * @return rulelevel
	 */
	public String getRulelevel();

	/**
	 * alarmtime取得
	 *
	 * @return alarmtime
	 */
	public String getAlarmtime();

	/**
	 * syslogmsg取得
	 *
	 * @return syslogmsg
	 */
	public String getSyslogmsg();

	/**
	 * syslogtime取得
	 *
	 * @return syslogtime
	 */
	public String getSyslogtime();

	/**
	 * alarmstate取得
	 *
	 * @return alarmstate
	 */
	public Integer getAlarmstate();
	/**
	 * systime取得
	 *
	 * @return systime systime
	 */
	public Date getSystime();
	

}