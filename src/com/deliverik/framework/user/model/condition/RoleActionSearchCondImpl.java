package com.deliverik.framework.user.model.condition;

/**
 * 角色菜单授权信息检索条件实现
 * 
 */
public class RoleActionSearchCondImpl implements RoleActionSearchCond {

	/** 角色ID */
	protected Integer roleid;
	
	/** 菜单ID */
	protected String actname;
	
	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
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
	 * 菜单ID取得
	 * @return 菜单ID
	 */
	public String getActname() {
		return actname;
	}

	/**
	 * 菜单ID设定
	 *
	 * @param actname 菜单ID
	 */
	public void setActname(String actname) {
		this.actname = actname;
	}
}
