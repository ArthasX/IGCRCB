/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * ����: ��⹤�������������ӿ�
  * ��������: ��⹤�������������ӿ�
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
public interface MonitoringWorkSearchCond {
	
	/**
	 * ���ղ�������idȡ��
	 * @return rmid  ���ղ�������id
	 */
	public Integer getRmid();
	
	/**
	 * �����nullȡ��
	 * @return result_isNotNull  �����null
	 */
	public String getResult_isNotNull();
	
	/**
	 * ָ������ȡ��
	 * @return einame  ָ������
	 */
	public String getEiname();
	
	/**
	 * ָ����ȡ��
	 * @return eilabel  ָ����
	 */
	public String getEilabel();
}