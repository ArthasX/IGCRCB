/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * ����: �澯������������������ӿ�
  * ��������: �澯������������������ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00003SearchCond {
	/**
	 * ruleconditionidȡ��
	 */
	public Integer getRuleconditionid() ;
	
	/**
	 * alarmmsgȡ��
	 */
	public String getAlarmmsg();
	
	/**
	 * alarmconditionȡ��
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
	 * �Ƿ���ģ���ʾȡ��
	 */
	public String getIsTemp();
}