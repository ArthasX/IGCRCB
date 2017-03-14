/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.svc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 年度工作趋势统计Form
 * </p>
 * 
 * @author wanglei@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGSVC0640Form extends BaseForm{

	/** 年份 */
	protected String year;
	
	/** 机构id */
	protected String orgid;
	
	/** 机构名称 */
	protected String orgname;

	/**
	 * 年份取得
	 * @return year 年份
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 年份设定
	 * @param year 年份
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * 机构id取得
	 * @return orgid 机构id
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构id设定
	 * @param orgid 机构id
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 * @return orgid 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 * @param orgid 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
	
}
