package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 角色信息
 * </p>
 */
public interface Role  extends BaseModel {
	
	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid();

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename();

	/**
	 * 角色说明取得
	 * @return 角色说明
	 */
	public String getRoledesc();

	/**
	 * 角色信息取得
	 * @return 角色信息
	 */
	public String getRoleinfo();

	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoletype();

	/**
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain();

	/**
	 * 角色资产管理范围取得
	 * @return 角色资产管理范围
	 */
	public String getAssetdomain();

}