/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: CRM07�ӿ�
  * ��������: CRM07�ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM07Info extends BaseModel {

	/**
	 * RULECONDITIONIDȡ��
	 *
	 * @return RULECONDITIONID
	 */
	public Integer getRuleconditionid();

	/**
	 * RULETEMPIDȡ��
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid();

	/**
	 * ALARMMSGȡ��
	 *
	 * @return ALARMMSG
	 */
	public String getAlarmmsg();

	/**
	 * ALARMCONDITIONȡ��
	 *
	 * @return ALARMCONDITION
	 */
	public Integer getAlarmcondition();
	
	public String getCreatetime();

}