/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 用户信息
 */
public interface UserInfo {
	
	/**
	 * 所属机构层次码取得
	 *
	 * @return 所属机构层次码
	 */
	public String getOrgid();

	/**
	 * 所属机构名称取得
	 *
	 * @return 所属机构名称
	 */
	
	public String getOrgname();

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid();

	/**
	 * 工号取得
	 *
	 * @return 工号
	 */
	public String getUserinfo();

	/**
	 * 手机号取得
	 *
	 * @return 手机号
	 */
	public String getUsermobile();

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUsername();
	
	/**
	 * 用户邮箱取得
	 * @return 用户邮箱
	 */
	public String getUseremail();

}
