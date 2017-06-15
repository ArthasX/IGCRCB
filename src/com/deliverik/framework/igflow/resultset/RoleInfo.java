/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 角色信息
 */
public interface RoleInfo {
	
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
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoletype();

	/**
	 * 机构管理范围取得
	 * @return 机构管理范围
	 */
	public String getRoledomain();

	/**
	 * 资产管理内容取得
	 * @return 资产管理内容
	 */
	public String getAssetdomain();

}
