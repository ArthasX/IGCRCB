/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: �澯����������ӿ�
  * ��������: �澯����������ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00003Info extends BaseModel {

	/**
	 * ruleconditionidȡ��
	 *
	 * @return ruleconditionid
	 */
	public Integer getRuleconditionid();

	/**
	 * alarmmsgȡ��
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg();

	/**
	 * alarmconditionȡ��
	 *
	 * @return alarmcondition
	 */
	public Integer getAlarmcondition();

	/**
	 * ����ģ��idȡ��
	 */
	public Integer getRuletempid();
	
	/**
	 * ����ʱ��ȡ��
	 */
	public String getCreatetime();
	
	/**
	 * �澯����ȡ��
	 * @return
	 */
	public Integer getAlarmlevel();

}