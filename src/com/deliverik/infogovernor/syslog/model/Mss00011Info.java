/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: mss00011�ӿ�
  * ��������: mss00011�ӿ�
  * ������¼: 2013/04/16
  * �޸ļ�¼: 
  */
public interface Mss00011Info extends BaseModel {

	/**
	 * deviceidȡ��
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

	/**
	 * devicenameȡ��
	 *
	 * @return devicename
	 */
	public String getDevicename();

	/**
	 * devicetypeȡ��
	 *
	 * @return devicetype
	 */
	public String getDevicetype();

	/**
	 * tempcountsȡ��
	 *
	 * @return tempcounts
	 */
	public Integer getTempcounts();

	/**
	 * devicestateȡ��
	 *
	 * @return devicestate
	 */
	public Integer getDevicestate();

	/**
	 * devicedescȡ��
	 *
	 * @return devicedesc
	 */
	public String getDevicedesc();
	
	public String getTypeid();

}