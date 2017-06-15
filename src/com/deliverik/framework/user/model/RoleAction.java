package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 角色菜单授权信息
 * </p>
 */
public interface RoleAction  extends BaseModel {

	/**
	 * 角色菜单授权ID取得
	 * @return 角色菜单授权ID
	 */
	public  Integer getRaid();
	
	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public  Integer getRoleid();

	/**
	 * 菜单ID取得
	 * @return 菜单ID
	 */
	public  String getActname();

	/**
	 * 角色对于菜单的权限取得
	 * @return 角色对于菜单的权限
	 */
	public  String getRaperm();

	/**
	 * 角色对于菜单的权限的说明取得
	 * @return 角色对于菜单的权限的说明
	 */
	public  String getRadesc();

}