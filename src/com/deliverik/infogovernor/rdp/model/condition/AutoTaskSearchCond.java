/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * ����: AutoTask���������ӿ�
  * ��������: AutoTask���������ӿ�
  * ������¼: 2014/04/16
  * �޸ļ�¼: 
  */
public interface AutoTaskSearchCond {
	
	public Integer getSystemid_eq();

	public String getTaskName_like();

	public String getTime_from();

	public String getTime_to();

}