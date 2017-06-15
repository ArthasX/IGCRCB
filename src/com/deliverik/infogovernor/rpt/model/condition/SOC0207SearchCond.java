/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报告模板检索条件接口
  * 功能描述: 报告模板检索条件接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateSearchCond表名修改为SOC0207SearchCond
  */
public interface SOC0207SearchCond {
	/**
	 * rtname_like取得
	 *
	 * @return rtname_like rtname_like
	 */
	public String getRtname_like();
	/**
	 * rtdatetype_eq取得
	 *
	 * @return rtdatetype_eq rtdatetype_eq
	 */
	public String getRtdatetype_eq();
}