/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * 概述: 审计报告表检索条件接口
  * 功能描述: 审计报告表检索条件接口
  * 创建记录: 2012/08/08
  * 修改记录: 
  */
public interface AUDITPROJECTSearchCond {
	/**
	 * 项目名称
	 */
	public String getProjectName();
	/**
	 * 审计报告类型
	 */
	public String getAuditReportType();
	/**
	 * 审计年度
	 */
	public String getApprojectyear();
}