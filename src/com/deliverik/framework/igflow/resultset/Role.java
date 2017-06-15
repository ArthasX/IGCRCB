/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 角色信息
 */
public class Role implements RoleInfo {
	
	/** 角色ID */
	private Integer roleid;

	/** 角色名称 */
	private String rolename;

	/** 角色类型 */
	private String roletype;

	/** 机构管理范围 */
	private String roledomain;

	/** 资产管理内容 */
	private String assetdomain;

	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 角色类型设定
	 * @param roletype 角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 机构管理范围取得
	 * @return 机构管理范围
	 */
	public String getRoledomain() {
		return roledomain;
	}

	/**
	 * 机构管理范围设定
	 * @param roledomain 机构管理范围
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * 资产管理内容取得
	 * @return 资产管理内容
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * 资产管理内容设定
	 * @param assetdomain 资产管理内容
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}
	
}