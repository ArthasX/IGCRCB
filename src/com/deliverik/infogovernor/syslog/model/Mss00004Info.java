/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �澯����ģ���ӿ�
  * ��������: �澯����ģ���ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00004Info extends BaseModel {

	/**
	 * ruletempidȡ��
	 *
	 * @return ruletempid
	 */
	public Integer getRuletempid();

	/**
	 * devicetypeȡ��
	 *
	 * @return devicetype
	 */
	public String getRuletempname();


	/**
	 * tempstateȡ��
	 *
	 * @return tempstate
	 */
	public Integer getTempstate();
	
	/**
	 * �豸����ȡ��
	 */
	public String getTypeid();
	
	/**
	 * ��������ȡ��
	 */
	public Integer getRulecondition();
	
	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime();
	
	/**
	 * ����ȡ��
	 */
	public String getTempdesc();
	
	public String getSummary();

}