package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 用户角色授权信息
 * </p>
 */
public interface UserRole  extends BaseModel {

	/**
	 * 用户角色授权ID取得
	 * @return 用户角色授权ID
	 */
	public Integer getUrid();

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();

	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid();

	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid();

	/**
	 * 用户是否角色负责人标识取得
	 * @return 用户是否角色负责人标识
	 */
	public String getRolemanager();
	
	/**
	 * 用户是否值班人标识取得
	 * @return 用户是否为值班人标识
	 */
	public String getDutyflag();

}