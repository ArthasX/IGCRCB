/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �澯��Ϣ���ӿ�
  * ��������: �澯��Ϣ���ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00005Info extends BaseModel {

	/**
	 * alarmidȡ��
	 *
	 * @return alarmid
	 */
	public Integer getAlarmid();

	/**
	 * devceidȡ��
	 *
	 * @return devceid
	 */
	public Integer getDevceid();

	/**
	 * deviceipȡ��
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

	/**
	 * devicenameȡ��
	 *
	 * @return devicename
	 */
	public String getDevicename();

	/**
	 * ruleidȡ��
	 *
	 * @return ruleid
	 */
	public Integer getRuleid();

	/**
	 * ruleconditionidȡ��
	 *
	 * @return ruleconditionid
	 */
	public Integer getRuleconditionid();

	/**
	 * rulelevelȡ��
	 *
	 * @return rulelevel
	 */
	public String getRulelevel();

	/**
	 * alarmtimeȡ��
	 *
	 * @return alarmtime
	 */
	public String getAlarmtime();

	/**
	 * syslogmsgȡ��
	 *
	 * @return syslogmsg
	 */
	public String getSyslogmsg();

	/**
	 * syslogtimeȡ��
	 *
	 * @return syslogtime
	 */
	public String getSyslogtime();

	/**
	 * alarmstateȡ��
	 *
	 * @return alarmstate
	 */
	public Integer getAlarmstate();
	
}