/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ������ͱ���������ӿ�
  * ��������: ������ͱ���������ӿ�
  * ������¼: 2012/02/07
  * �޸ļ�¼: 
  */
public interface MonitorTypeSearchCond {
	/**
	 * ���β����ȡ��
	 * @return
	 */
	public String getMtSyscoding();
	
	/**
	 * ���β�������ƻ�ȡ
	 * @return
	 */
	public String getMtSyscoding_like();
}