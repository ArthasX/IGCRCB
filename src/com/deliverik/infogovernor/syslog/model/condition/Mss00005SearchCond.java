/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;


/**
  * ����: �澯��Ϣ�����������ӿ�
  * ��������: �澯��Ϣ�����������ӿ�
  * ������¼: 2013/03/28
  * �޸ļ�¼: 
  */
public interface Mss00005SearchCond {
	
	public String getWord_like();

	public String getEname();

	public String getAlarmtime_from();

	public String getAlarmtime_to();

	public String getIp_like();

	public String getPriority_eq();
	
	public String getEsyscoding();
	
	public String getAlarmstate();
	
	public String[] getIds();
	
	public String[] getPriority();

}