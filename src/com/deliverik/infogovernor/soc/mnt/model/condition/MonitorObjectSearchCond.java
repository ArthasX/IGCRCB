/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: ��ض�����Ϣ���������ӿ�
  * ��������: ��ض�����Ϣ���������ӿ�
  * ������¼: 2012/02/08
  * �޸ļ�¼: 
  */
public interface MonitorObjectSearchCond {

	/**
	 * �������id��ȡ
	 * @return
	 */
	public String getMtSyscoding();
	
	/**
	 * ��ض������ƻ�ȡ
	 * @return
	 */
	public String getMoName();
	
	/**
	 * ����ʱ�䵽��ȡ
	 * @return
	 */
	public String getMoCreateTime_to();
	
	/**
	 * ����ʱ��ӻ�ȡ
	 * @return
	 */
	public String getMoCreateTime_from();
}