/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: ��ռ�����ʵʱ����������ӿ�
  * ��������: ��ռ�����ʵʱ����������ӿ�
  * ������¼: 2012/07/03
  * �޸ļ�¼: 2012/08/10 ��TSCapacityRealTimeSearchCond�����޸�ΪSOC0415SearchCond
  */
public interface SOC0415SearchCond {
	/**
	 * ���ݿ����ֵ���ȡ��
	 *
	 * @return dbName_eq ���ݿ����ֵ���
	 */
	public String getDbName_eq();
	/**
	 * �������ֵ���ȡ��
	 *
	 * @return hostName_eq �������ֵ���
	 */
	public String getHostName_eq();
}