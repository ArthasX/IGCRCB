package com.deliverik.framework.user.model;

/**
 * <p>
 * 角色菜单授权信息
 * </p>
 */
public interface RoleActionInfo {

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
	
	/**
	 * 菜单显示名称取得
	 * @return 菜单显示名称
	 */
	public  String getActlabel();

	/**
	 * 菜单描述取得
	 * @return 菜单描述
	 */
	public  String getActdesc();

	/**
	 * 菜单URL取得
	 * @return 菜单URL
	 */
	public  String getActurl();

	/**
	 * 菜单类型取得
	 * @return 菜单类型
	 */
	public  String getActtype();
	
	/**
	 * 菜单排序ID取得
	 * @return 菜单排序ID
	 */
	public String getActsortid();
	
	/**
	 * 菜单URL类型取得
	 * @return 菜单URL类型
	 */
	public String getActurltype();

}