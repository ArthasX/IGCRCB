/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * ����: ��Ʊ�����������ʵ��
  * ��������: ��Ʊ�����������ʵ��
  * ������¼: 2012/08/08
  * �޸ļ�¼: 
  */
public class AUDITPROJECTSearchCondImpl implements AUDITPROJECTSearchCond {
	/**
	 * ��Ŀ����
	 */
	private String projectName ;
	/**
	 * ��Ʊ�������
	 */
	private String auditReportType ;
	
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getAuditReportType() {
		return auditReportType;
	}
	public void setAuditReportType(String auditReportType) {
		this.auditReportType = auditReportType;
	} 
	
	/**
	 * ������
	 */
	private String approjectyear ;

	public String getApprojectyear() {
		return approjectyear;
	}
	public void setApprojectyear(String approjectyear) {
		this.approjectyear = approjectyear;
	}
	
}