/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报告类型表检索条件实现
  * 功能描述: 报告类型表检索条件实现
  * 创建记录: 2012/07/18
  * 修改记录: 2012/08/10 将ReportTypeSearchCondImpl表名修改为SOC0424SearchCondImpl
  */
public class SOC0424SearchCondImpl implements
		SOC0424SearchCond {
	/** 报名字 */
	protected String reportName_eq;

	/** 类型 */
	protected String rtType_eq;

	/** 存储类型 */
	protected String storageType_eq;

	/**
	 * 报名字取得
	 *
	 * @return reportName_eq 报名字
	 */
	public String getReportName_eq() {
		return reportName_eq;
	}

	/**
	 * 报名字设定
	 *
	 * @param reportName_eq 报名字
	 */
	public void setReportName_eq(String reportName_eq) {
		this.reportName_eq = reportName_eq;
	}

	/**
	 * 类型取得
	 *
	 * @return rtType_eq 类型
	 */
	public String getRtType_eq() {
		return rtType_eq;
	}

	/**
	 * 类型设定
	 *
	 * @param rtType_eq 类型
	 */
	public void setRtType_eq(String rtType_eq) {
		this.rtType_eq = rtType_eq;
	}

	/**
	 * 存储类型取得
	 *
	 * @return storageType_eq 存储类型
	 */
	public String getStorageType_eq() {
		return storageType_eq;
	}

	/**
	 * 存储类型设定
	 *
	 * @param storageType_eq 存储类型
	 */
	public void setStorageType_eq(String storageType_eq) {
		this.storageType_eq = storageType_eq;
	}
	
	
	
}