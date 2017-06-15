package com.deliverik.framework.user.model;

/**
 * <p>
 * 用户角色授权信息
 * </p>
 */
public interface UserRoleInfo {
	
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
	 * 用户姓名取得
	 *
	 * @return username 用户姓名
	 */
	public String getUsername();
	
	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid();

	/**
	 * 用户角色名称取得
	 * @return 用户角色名称
	 */
	public String getRolename();

	/**
	 * 用户角色说明取得
	 * @return 用户角色说明
	 */
	public String getRoledesc();

	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoletype();

	/**
	 * 用户角色机构管理范围取得
	 * @return 用户角色机构管理范围
	 */
	public String getRoledomain();

	/**
	 * 用户角色资产管理范围取得
	 * @return 用户角色资产管理范围
	 */
	public String getAssetdomain();

	/**
	 * 用户是否角色负责人标识取得
	 * @return 用户是否角色负责人标识
	 */
	public String getRolemanager();
	
	/**
	 * 机构syscoding取得
	 *
	 * @return orgid 机构syscoding
	 */
	public String getOrgid();
	
	/**
	 * 机构名称取得
	 *
	 * @return orgname 机构名称
	 */
	public String getOrgname();
	
	/**
	 * 用户是否值班人标识取得
	 * @return 用户是否值班人标识
	 */
	public String getDutyflag();


	/**
	 * 用户工号取得
	 * @return userinfo 用户工号
	 */
	public String getUserinfo();

	/**
	 * 用户手机取得
	 * @return usermobile 用户手机
	 */
	public String getUsermobile();

	/**
	 * 用户邮箱取得
	 * @return useremail 用户邮箱
	 */
	public String getUseremail();
}