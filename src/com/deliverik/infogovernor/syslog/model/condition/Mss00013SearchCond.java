/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * ����: mss00013���������ӿ�
  * ��������: mss00013���������ӿ�
  * ������¼: 2013/08/15
  * �޸ļ�¼: 
  */
public interface Mss00013SearchCond {
	
	public String getIp_eq();

	public String getPriority_eq();
	
	public String getContent();
	
	public String[] getCvalue();
	
	public String getIp_like();
	
	public String getContent_like();
	
}