/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * ����: ��Ʊ������������ӿ�
  * ��������: ��Ʊ������������ӿ�
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
public interface AUDITPROJECTSearchCond {
	/**
	 * ��Ŀ����
	 */
	public String getProjectName();
	/**
	 * ��Ʊ�������
	 */
	public String getAuditReportType();
	/**
	 * ������
	 */
	public String getApprojectyear();
}