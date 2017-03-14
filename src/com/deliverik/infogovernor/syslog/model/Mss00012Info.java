/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;


import com.deliverik.framework.base.BaseModel;

/**
  * ����: MSS00012�ӿ�
  * ��������: MSS00012�ӿ�
  * ������¼: 2013/04/25
  * �޸ļ�¼: 
  */
public interface Mss00012Info extends BaseModel {
	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId();

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
	//�澯ȷ��ʱ��
	public String getStarttime();
	//�澯�޸�ʱ��
	public String getEndtime();
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
	
	
	public Integer getState();
	
	public Integer getPrid();
}