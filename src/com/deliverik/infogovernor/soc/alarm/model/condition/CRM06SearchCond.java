/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * ����: CRM06���������ӿ�
  * ��������: CRM06���������ӿ�
  * ������¼: 2013/07/30
  * �޸ļ�¼: 
  */
public interface CRM06SearchCond {
	
	public String getServerName_like();


	public String getIp_like();
	
	public String getFileid_eq();

	public String getServerName();

}