/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.soc.vir.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 
 */

@SuppressWarnings("serial")
public class IGVIR1102Form extends BaseForm{
	
	/**机构码  */
	protected String orgsyscoding_like;
	/**机构名称  */
	protected String orgname;
	
	/**
	 * 机构码取得
	 * @return orgsyscoding_like 机构码
	 */
	public String getOrgsyscoding_like() {
		return orgsyscoding_like;
	}
	/**
	 * 机构码设定
	 * @param orgsyscoding_like 机构码
	 */
	public void setOrgsyscoding_like(String orgsyscoding_like) {
		this.orgsyscoding_like = orgsyscoding_like;
	}
	/**
	 * 机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}
	/**
	 * 机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}
	
}
