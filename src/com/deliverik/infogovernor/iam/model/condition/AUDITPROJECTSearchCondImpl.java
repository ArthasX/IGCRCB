/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * 概述: 审计报告表检索条件实现
  * 功能描述: 审计报告表检索条件实现
  * 创建记录: 2012/08/08
  * 修改记录: 
  */
public class AUDITPROJECTSearchCondImpl implements AUDITPROJECTSearchCond {
	/**
	 * 项目名称
	 */
	private String projectName ;
	/**
	 * 审计报告类型
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
	 * 审计年度
	 */
	private String approjectyear ;

	public String getApprojectyear() {
		return approjectyear;
	}
	public void setApprojectyear(String approjectyear) {
		this.approjectyear = approjectyear;
	}
	
}