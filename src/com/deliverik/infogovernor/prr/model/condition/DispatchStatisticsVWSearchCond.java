/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * ����: ��������ͳ�Ƽ��������ӿ�
  * ��������: ��������ͳ�Ƽ��������ӿ�
  * ������¼: 2013/02/27
  * �޸ļ�¼: 
  */
public interface DispatchStatisticsVWSearchCond {
	
	/**
	 * �û���ȡ��
	 *
	 * @return �û���
	 */
	public String getDsusername();
	
	/**
	 * ��ѯ������ʼʱ��ȡ��
	 *
	 * @return ��ѯ������ʼʱ��
	 */
	public String getPropentime_from();
	
	/**
	 * ��ѯ��������ʱ��ȡ��
	 *
	 * @return ��ѯ��������ʱ��
	 */
	public String getPropentime_to();
}