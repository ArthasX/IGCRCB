/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.condition.SOC0205SearchCond;

/**
 * 概述: 报告查询Form
 * 功能描述: 
 * 创建记录: 2012/06/13
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0204Form extends BaseForm implements SOC0205SearchCond {
	/**查询模板表专用rtdatetype_eq*/
	protected String rtdatetype_eq;
	/**批量删除id*/
	protected String[] delid;
	/**报告名称模糊*/
	protected String rmName_like;
	/**时间从*/
	protected String dateFrom;
	/**时间到*/
	protected String dateTo;
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
	 * 查询模板表专用rtdatetype_eq取得
	 *
	 * @return rtdatetype_eq 查询模板表专用rtdatetype_eq
	 */
	public String getRtdatetype_eq() {
		return rtdatetype_eq;
	}
	/**
	 * 批量删除id取得
	 *
	 * @return delid 批量删除id
	 */
	public String[] getDelid() {
		return delid;
	}
	/**
	 * 查询模板表专用rtdatetype_eq设定
	 *
	 * @param rtdatetype_eq 查询模板表专用rtdatetype_eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}
	/**
	 * 批量删除id设定
	 *
	 * @param delid 批量删除id
	 */
	public void setDelid(String[] delid) {
		this.delid = delid;
	}
	
	

	
}
