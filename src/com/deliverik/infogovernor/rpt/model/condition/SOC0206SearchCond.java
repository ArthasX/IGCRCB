/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 模板映射表检索条件接口
  * 功能描述: 模板映射表检索条件接口
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateMappingSearchCond表名修改为SOC0206SearchCond
  */
public interface SOC0206SearchCond {
	/**
	 * rtId_eq取得
	 *
	 * @return rtId_eq rtId_eq
	 */
	public Integer getRtId_eq();

	/**
	 * @return
	 */
	public Integer getRtNumber_eq();
}