/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * ����: DMXʵʱ������ܱ���������ӿ�
  * ��������: DMXʵʱ������ܱ���������ӿ�
  * ������¼: 2012/05/16
  * �޸ļ�¼: 
  */
public interface SOC0301SearchCond {
	
	/**
	 * �����������ȡ��
	 *
	 * @return mtId_eq �����������
	 */
	public Integer getMtId_eq();
	
	/**
	 * �������������ȡ��
	 *
	 * @return mtoName_eq �������������
	 */
	public String getMtoName_eq();
	
	/**
	 * ����kpi���ȡ��
	 *
	 * @return mtKpi_eq ����kpi���
	 */
	public String getMtKpi_eq();
	/**
	 * ʱ���ȡ��
	 *
	 * @return timestamp_ge ʱ���
	 */
	public String getTimestamp_ge();
}