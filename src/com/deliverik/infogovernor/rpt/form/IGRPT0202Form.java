/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.rpt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.rpt.model.condition.SOC0207SearchCond;

/**
 * 概述: 自动报表查询Form
 * 功能描述: 自动报表查询Form
 * 创建记录: 2012/06/08
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGRPT0202Form extends BaseForm implements SOC0207SearchCond{
	
	/** 批量删除 */
	protected String[] delid;
	/** 日期分类eq */
	protected String rtdatetype_eq;
	/** 模板名称like */
	protected String rtname_like;

	/**
	 * 日期分类eq取得
	 *
	 * @return rtdatetype_eq 日期分类eq
	 */
	public String getRtdatetype_eq() {
		return rtdatetype_eq;
	}
	/**
	 * 模板名称like取得
	 *
	 * @return rtname_like 模板名称like
	 */
	public String getRtname_like() {
		return rtname_like;
	}
	/**
	 * 日期分类eq设定
	 *
	 * @param rtdatetype_eq 日期分类eq
	 */
	public void setRtdatetype_eq(String rtdatetype_eq) {
		this.rtdatetype_eq = rtdatetype_eq;
	}
	/**
	 * 模板名称like设定
	 *
	 * @param rtname_like 模板名称like
	 */
	public void setRtname_like(String rtname_like) {
		this.rtname_like = rtname_like;
	}
	/**
	 * 批量删除取得
	 *
	 * @return delid 批量删除
	 */
	public String[] getDelid() {
		return delid;
	}
	/**
	 * 批量删除设定
	 *
	 * @param delid 批量删除
	 */
	public void setDelid(String[] delid) {
		this.delid = delid;
	}

	
}
