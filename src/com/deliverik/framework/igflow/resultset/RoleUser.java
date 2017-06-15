/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * 角色用户信息
 */
public class RoleUser implements RoleUserInfo {
	
	/** 角色ID */
	private Integer roleid;
	
	/** 角色用户ID列表 */
	private List<String> lst_Userid;

	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色用户ID列表取得
	 * @return 角色用户ID列表
	 */
	public List<String> getLst_Userid() {
		return lst_Userid;
	}

	/**
	 * 角色ID设定
	 * 
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 角色用户ID列表设定
	 * 
	 * @param lst_Userid 角色用户ID列表
	 */
	public void setLst_Userid(List<String> lst_Userid) {
		this.lst_Userid = lst_Userid;
	}
	
}
