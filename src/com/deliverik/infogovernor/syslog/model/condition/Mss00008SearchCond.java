/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * ����: SYSLOG��Ϣ����������ӿ�
  * ��������: SYSLOG��Ϣ����������ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00008SearchCond {
	
	public String getWord_like();

	public String getEname();

	public String getAlarmtime_from();

	public String getAlarmtime_to();

	public String getIp_like();
	
	public String getEsyscoding();
	
	public String[] getPriority();
	
	public String getIsalarm();
}