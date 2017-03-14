package com.deliverik.framework.user.model.condition;

/**
 * 用户角色授权信息检索条件实现
 * 
 */
public class UserRoleSearchCondImpl implements UserRoleSearchCond {

	/** 用户ID */
	protected String userid;
	
	/** 用户角色ID */
	protected Integer roleid;
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 用户角色ID设定
	 *
	 * @param roleid 用户角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
}
