/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: SYSLOG��Ϣ��ӿ�
  * ��������: SYSLOG��Ϣ��ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00008Info extends BaseModel {

	/**
	 * IDȡ��
	 *
	 * @return ID
	 */
	public Integer getID();

	/**
	 * deviceidȡ��
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

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
	 * rulelevelȡ��
	 *
	 * @return rulelevel
	 */
	public String getRulelevel();

	/**
	 * alarmmsgȡ��
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg();

	/**
	 * isalarmȡ��
	 *
	 * @return isalarm
	 */
	public Integer getIsalarm();
	
	/**
	 * createtimeȡ��
	 * 
	 * @return createtime
	 */
	public String getCreatetime();
	
	/**
	 * 
	 * @return
	 */
	public String getStarttime();
	
}