/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM01���������ӿ�
  * ��������: CRM01���������ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM10SearchCond {
  
	public String getIp();//ip
	
	public String getGet_StartTime() ;//��ʼʱ��
		
	public String getGet_EndTime() ;//����ʱ��
		
	public String getSymType() ;//�豸����
	
    public String getTablename();//
	
    public String getNowCollecttime();

}