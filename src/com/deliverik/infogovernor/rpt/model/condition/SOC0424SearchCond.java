/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报告类型表检索条件接口
  * 功能描述: 报告类型表检索条件接口
  * 创建记录: 2012/07/18
  * 修改记录: 2012/08/10 将ReportTypeSearchCond表名修改为SOC0424SearchCond
  */
public interface SOC0424SearchCond {
	/**
	 * 报名字取得
	 *
	 * @return reportName_eq 报名字
	 */
	public String getReportName_eq();

	/**
	 * 类型取得
	 *
	 * @return rtType_eq 类型
	 */
	public String getRtType_eq();

	/**
	 * 存储类型取得
	 *
	 * @return storageType_eq 存储类型
	 */
	public String getStorageType_eq();
	
}