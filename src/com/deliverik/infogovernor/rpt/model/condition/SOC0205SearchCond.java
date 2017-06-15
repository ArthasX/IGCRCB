/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报告管理表检索条件接口
  * 功能描述: 报告管理表检索条件接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportManageSearchCond表名修改为SOC0205SearchCond
  */
public interface SOC0205SearchCond {
	/**
	 * rmName_like取得
	 *
	 * @return rmName_like rmName_like
	 */
	public String getRmName_like();
	/**
	 * dateFrom取得
	 *
	 * @return dateFrom dateFrom
	 */
	public String getDateFrom();
	/**
	 * dateTo取得
	 *
	 * @return dateTo dateTo
	 */
	public String getDateTo();
	/**
	 * rmDateType_eq取得
	 *
	 * @return rmDateType_eq rmDateType_eq
	 */
	public String getRtdatetype_eq();
}