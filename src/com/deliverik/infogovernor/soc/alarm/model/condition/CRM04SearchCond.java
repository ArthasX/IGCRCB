/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM04���������ӿ�
  * ��������: CRM04���������ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM04SearchCond {

	public String getWord_like();

	public String getEname();

	public String getAlarmtime_from();

	public String getAlarmtime_to();

	public String getIp_like();
	
	public String getEsyscoding();
	
	public Integer[] getPriority();
}