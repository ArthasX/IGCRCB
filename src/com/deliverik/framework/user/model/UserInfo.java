package com.deliverik.framework.user.model;

/**
 * <p>
 * 用户信息
 * </p>
 */
public interface UserInfo {

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserida();

	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername();

	/**
	 * 用户口令取得
	 * @return 用户口令
	 */
	public String getPassword();

	/**
	 * 用户说明取得
	 * @return 用户说明
	 */
	public String getUserdesc();

	/**
	 * 用户信息取得
	 * @return 用户信息
	 */
	public String getUserinfo();

	/**
	 * 用户类型取得
	 * @return 用户类型
	 */
	public String getUsertype();

	/**
	 * 用户状态取得
	 * @return 用户状态
	 */
	public String getUserstatus();

	/**
	 * 用户电话取得
	 * @return 用户电话
	 */
	public String getUserphone();

	/**
	 * 用户手机取得
	 * @return 用户手机
	 */
	public String getUsermobile();

	/**
	 * 用户邮箱取得
	 * @return 用户邮箱
	 */
	public String getUseremail();

	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleida();

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
	 * 用户角色信息取得
	 * @return 用户角色信息
	 */
	public String getRoleinfo();

	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoletype();

	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgida();

	/**
	 * 用户机构名称取得
	 * @return 用户机构名称
	 */
	public String getOrgname();

	/**
	 * 用户机构说明取得
	 * @return 用户机构说明
	 */
	public String getOrgdesc();

	/**
	 * 用户机构信息取得
	 * @return 用户机构信息
	 */
	public String getOrginfo();

	/**
	 * 用户机构类型取得
	 * @return 用户机构类型
	 */
	public String getOrgtype();

	/**
	 * 用户机构的上级机构层次码取得
	 * @return 用户机构的上级机构层次码
	 */
	public String getOrgpar();

	/**
	 * 用户机构的上级机构名称取得
	 * @return 用户机构的上级机构名称
	 */
	public String getOrgparname();

	/**
	 * 用户机构地址取得
	 * @return 用户机构地址
	 */
	public String getOrgaddr();

	/**
	 * 用户机构电话取得
	 * @return 用户机构电话
	 */
	public String getOrgphone();

	/**
	 * 用户机构传真取得
	 * @return 用户机构传真
	 */
	public String getOrgfax();

	/**
	 * 用户机构联系人取得
	 * @return 用户机构联系人
	 */
	public String getOrgcontact();

	/**
	 * 用户机构状态取得
	 * @return 用户机构状态
	 */
	public String getOrgstatus();

	/**
	 * 用户角色资产管理范围取得
	 * @return 用户角色资产管理范围
	 */
	public String getRolemanager();
	
	/**
	 * 值班人标识取得
	 * @return 值班人标识
	 */
	public String getDutyflag();

	/**
	 * 逻辑删除标志位取得
	 * @return 逻辑删除标志位
	 */
	public String getDeleteflag();
}