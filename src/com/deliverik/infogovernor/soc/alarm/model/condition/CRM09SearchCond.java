/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM09���������ӿ�
  * ��������: CRM09���������ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM09SearchCond {
	
	public String getServerid_eq();
	
	public Integer getRuletempid_eq();
	
	public Integer[] getRuletempids_notIn();
	

}