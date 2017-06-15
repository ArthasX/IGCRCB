/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报告类型表接口
  * 功能描述: 报告类型表接口
  * 创建记录: 2012/07/18
  * 修改记录: 2012/08/09 将ReportTypeInfo表名改为SOC0424Info
  */
public interface SOC0424Info extends BaseModel {

	/**
	 * 报名字取得
	 *
	 * @return 报名字
	 */
	public String getReportName();

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getRtType();

	/**
	 * 存储类型取得
	 *
	 * @return 存储类型
	 */
	public String getStorageType();

}