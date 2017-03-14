/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * 角色用户信息
 */
public interface RoleUserInfo {
	
	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 角色用户ID列表取得
	 * @return 角色用户ID列表
	 */
	public List<String> getLst_Userid();

}
