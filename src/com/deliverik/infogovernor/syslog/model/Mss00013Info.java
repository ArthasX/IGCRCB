/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: mss00013�ӿ�
  * ��������: mss00013�ӿ�
  * ������¼: 2013/08/15
  * �޸ļ�¼: 
  */
public interface Mss00013Info extends BaseModel {

	/**
	 * idȡ��
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * deviceipȡ��
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

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

}