/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 报告管理表检索条件实现
  * 功能描述: 报告管理表检索条件实现
  * 创建记录: 2012/06/06
  * 修改记录: 2012/08/10 将ReportManageSearchCondImpl表名修改为SOC0205SearchCondImpl
  */
public class SOC0205SearchCondImpl implements
		SOC0205SearchCond {
	
	protected String rmName_like;
	protected String dateFrom;
	protected String dateTo;
	protected String rtdatetype_eq;
	/**
	 * rmName_like取得
	 *
	 * @return rmName_like rmName_like
	 */
	public String getRmName_like() {
		return rmName_like;
	}
	/**
	 * dateFrom取得
	 *
	 * @return dateFrom dateFrom
	 */
	public String getDateFrom() {
		return dateFrom;
	}
	/**
	 * dateTo取得
	 *
	 * @return dateTo dateTo
	 */
	public String getDateTo() {
		return dateTo;
	}
	/**
	 * rmName_like设定
	 *
	 * @param rmName_like rmName_like
	 */
	public void setRmName_like(String rmName_like) {
		this.rmName_like = rmName_like;
	}
	/**
	 * dateFrom设定
	 *
	 * @param dateFrom dateFrom
	 */
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	/**
	 * dateTo设定
	 *
	 * @param dateTo dateTo
	 */
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
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
	 * rtdatetype_eq设定
	 *
	 * @param rtdatetype_eq rtdatetype_eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}


	
}