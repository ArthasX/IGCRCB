/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报告模板检索条件实现
  * 功能描述: 报告模板检索条件实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportTemplateSearchCondImpl表名修改为SOC0207SearchCondImpl
  */
public class SOC0207SearchCondImpl implements SOC0207SearchCond {
	protected String rtname_like;
	protected String rtdatetype_eq;
	/**
	 * rtname_like取得
	 *
	 * @return rtname_like rtname_like
	 */
	public String getRtname_like() {
		return rtname_like;
	}
	/**
	 * rtdatetype_eq取得
	 *
	 * @return rtdatetype_eq rtdatetype_eq
	 */
	public String getRtdatetype_eq() {
		return rtdatetype_eq;
	}
	/**
	 * rtname_like设定
	 *
	 * @param rtname_like rtname_like
	 */
	public void setRtname_like(String rtname_like) {
		this.rtname_like = rtname_like;
	}
	/**
	 * rtdatetype_eq设定
	 *
	 * @param rtdatetype_eq rtdatetype_eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}

}