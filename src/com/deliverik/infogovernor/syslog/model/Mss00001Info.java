/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �豸��Ϣ��ӿ�
  * ��������: �豸��Ϣ��ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00001Info extends BaseModel {

	/**
	 * deviceidȡ��
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

	/**
	 * typeidȡ��
	 *
	 * @return typeid
	 */
	public String getTypeid();

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
	 * devicedescȡ��
	 *
	 * @return devicedesc
	 */
	public String getDevicedesc();

	/**
	 * devicestateȡ��
	 *
	 * @return devicestate
	 */
	public Integer getDevicestate();
	
	public String getDeviceip2();

}