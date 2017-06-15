package com.deliverik.framework.user.model;

import com.deliverik.framework.base.BaseModel;

/**
 * <p>
 * 用户信息
 * </p>
 */
public interface User  extends BaseModel {
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid();

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
	 * 用户信息取得
	 * @return 用户信息
	 */
	public String getUserinfo();

	/**
	 * 用户说明取得
	 * @return 用户说明
	 */
	public String getUserdesc();

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
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid();

	/**
	 * 用户机构名称取得
	 * @return 用户机构名称
	 */
	public String getOrgname();

	/**
	 * 逻辑删除标志位取得
	 * @return 逻辑删除标志位
	 */
	public String getDeleteflag();
	//业务连续性 drm
	/**
	 * 用户所属机构取得
	 * @return 用户所属机构
	 */
	public Organization getOrganizationTB();
	

}