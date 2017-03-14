/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM04�ӿ�
  * ��������: CRM04�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM04Info extends BaseModel {

	/**
	 * alarmidȡ��
	 *
	 * @return alarmid
	 */
	public Integer getAlarmid();

	/**
	 * serveridȡ��
	 *
	 * @return serverid
	 */
	public Integer getServerid();

	/**
	 * ruletempidȡ��
	 *
	 * @return ruletempid
	 */
	public Integer getRuletempid();

	/**
	 * serveripȡ��
	 *
	 * @return serverip
	 */
	public String getServerip();

	/**
	 * servernameȡ��
	 *
	 * @return servername
	 */
	public String getServername();

	/**
	 * rulelevelȡ��
	 *
	 * @return rulelevel
	 */
	public Integer getRulelevel();

	/**
	 * alarmtimeȡ��
	 *
	 * @return alarmtime
	 */
	public String getAlarmtime();

	/**
	 * alarmmsgȡ��
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg();

	/**
	 * collecttimeȡ��
	 *
	 * @return collecttime
	 */
	public String getCollecttime();

	/**
	 * alarmstateȡ��
	 *
	 * @return alarmstate
	 */
	public String getAlarmstate();
	
	/**
	 * categoryȡ��
	 *
	 * @return category
	 */
	public String getCategory();
	
	/**
	 * objectnameȡ��
	 *
	 * @return objectname
	 */
	public String getObjectname();

}