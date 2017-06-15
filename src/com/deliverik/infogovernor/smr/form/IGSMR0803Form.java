/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.smr.form;


import com.deliverik.framework.base.BaseForm;

/**
 * 概述:监控报表详细页 form
 * 功能描述：监控报表详细页form
 * 创建人：
 * 创建记录： 2013/09/04
 * 修改记录：
 */
@SuppressWarnings("serial")
public class IGSMR0803Form extends BaseForm{

	/** 人员ID*/
	protected String userid;
	
	/** 机构ID */
	protected String orgid;
	
	
	
	/**
	 * 人员ID取得
	 *
	 * @return 人员ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 人员ID设定
	 *
	 * @param userid 人员ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 机构ID取得
	 *
	 * @return 机构ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构ID设定
	 *
	 * @param orgid 机构ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

}
