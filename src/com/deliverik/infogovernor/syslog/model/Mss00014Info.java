/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: mss00014�ӿ�
  * ��������: mss00014�ӿ�
  * ������¼: 2014/01/21
  * �޸ļ�¼: 
  */
public interface Mss00014Info extends BaseModel {

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * alarmipȡ��
	 *
	 * @return alarmip
	 */
	public String getAlarmip();

	/**
	 * happentimeȡ��
	 *
	 * @return happentime
	 */
	public String getHappentime();

	/**
	 * countȡ��
	 *
	 * @return count
	 */
	public Integer getCount();

}