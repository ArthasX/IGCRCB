/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �������ͱ���������ӿ�
  * ��������: �������ͱ���������ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/10 ��ReportTypeSearchCond�����޸�ΪSOC0424SearchCond
  */
public interface SOC0424SearchCond {
	/**
	 * ������ȡ��
	 *
	 * @return reportName_eq ������
	 */
	public String getReportName_eq();

	/**
	 * ����ȡ��
	 *
	 * @return rtType_eq ����
	 */
	public String getRtType_eq();

	/**
	 * �洢����ȡ��
	 *
	 * @return storageType_eq �洢����
	 */
	public String getStorageType_eq();
	
}