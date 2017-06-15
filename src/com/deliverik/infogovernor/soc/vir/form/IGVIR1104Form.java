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
public class IGVIR1104Form extends BaseForm{

	/**查看类型*/
	protected String showType;
	
	/**查询类型 */
	protected String searchType;
	
	/**用户id */
	protected String userid;
	
	/**机构码  */
	protected String orgsyscoding;
	
	/** 项目主键 */
    protected Integer pid_eq;

	/**
	 * 查询类型取得
	 * @return searchType 查询类型
	 */
	public String getSearchType() {
		return searchType;
	}

	/**
	 * 查看类型取得
	 * @return showType 查看类型
	 */
	public String getShowType() {
		return showType;
	}

	/**
	 * 查看类型设定
	 * @param showType 查看类型
	 */
	public void setShowType(String showType) {
		this.showType = showType;
	}

	/**
	 * 查询类型设定
	 * @param searchType 查询类型
	 */
	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	/**
	 * 用户id取得
	 * @return userid 用户id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户id设定
	 * @param userid 用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 机构码取得
	 * @return orgsyscoding 机构码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构码设定
	 * @param orgsyscoding 机构码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 项目主键取得
	 * @return pid_eq 项目主键
	 */
	public Integer getPid_eq() {
		return pid_eq;
	}

	/**
	 * 项目主键设定
	 * @param pid_eq 项目主键
	 */
	public void setPid_eq(Integer pid_eq) {
		this.pid_eq = pid_eq;
	}
	
}
