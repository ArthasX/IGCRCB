/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * ����: �������ͱ��������ʵ��
  * ��������: �������ͱ��������ʵ��
  * ������¼: 2012/07/18
  * �޸ļ�¼: 2012/08/10 ��ReportTypeSearchCondImpl�����޸�ΪSOC0424SearchCondImpl
  */
public class SOC0424SearchCondImpl implements
		SOC0424SearchCond {
	/** ������ */
	protected String reportName_eq;

	/** ���� */
	protected String rtType_eq;

	/** �洢���� */
	protected String storageType_eq;

	/**
	 * ������ȡ��
	 *
	 * @return reportName_eq ������
	 */
	public String getReportName_eq() {
		return reportName_eq;
	}

	/**
	 * �������趨
	 *
	 * @param reportName_eq ������
	 */
	public void setReportName_eq(String reportName_eq) {
		this.reportName_eq = reportName_eq;
	}

	/**
	 * ����ȡ��
	 *
	 * @return rtType_eq ����
	 */
	public String getRtType_eq() {
		return rtType_eq;
	}

	/**
	 * �����趨
	 *
	 * @param rtType_eq ����
	 */
	public void setRtType_eq(String rtType_eq) {
		this.rtType_eq = rtType_eq;
	}

	/**
	 * �洢����ȡ��
	 *
	 * @return storageType_eq �洢����
	 */
	public String getStorageType_eq() {
		return storageType_eq;
	}

	/**
	 * �洢�����趨
	 *
	 * @param storageType_eq �洢����
	 */
	public void setStorageType_eq(String storageType_eq) {
		this.storageType_eq = storageType_eq;
	}
	
	
	
}