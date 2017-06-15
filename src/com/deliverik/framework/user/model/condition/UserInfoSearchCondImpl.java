package com.deliverik.framework.user.model.condition;

/**
 * 用户角色机构信息检索条件实现
 * 
 */
public class UserInfoSearchCondImpl implements UserInfoSearchCond {

	/** 用户ID */
	protected String userida;
	
	/** 用户姓名 */
	protected String username;
	
	/** 用户角色ID */
	protected Integer roleida;

	/** 用户角色名称 */
	protected String rolename;
	
	/** 用户角色类型 */
	protected String roletype;
	
	/** 用户机构层次码 */
	protected String orgida;

	/** 用户机构名称 */
	protected String orgname;
	
	/** 工号 */
	protected String userinfo;
	
	/** 工号 */
	protected String userinfo_like;
	
	/** 用户名称 ，PMS系统对接专用*/
	protected String username_forPms;
	
	
	
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserida() {
		return userida;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userida 用户ID
	 */
	public void setUserida(String userida) {
		this.userida = userida;
	}

	/**
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户姓名设定
	 *
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleida() {
		return roleida;
	}

	/**
	 * 用户角色ID设定
	 *
	 * @param roleid 用户角色ID
	 */
	public void setRoleida(Integer roleida) {
		this.roleida = roleida;
	}

	/**
	 * 用户角色名称取得
	 * @return 用户角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 用户角色名称设定
	 *
	 * @param rolename 用户角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	
	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgida() {
		return orgida;
	}

	/**
	 * 用户机构层次码设定
	 *
	 * @param orgida 用户机构层次码
	 */
	public void setOrgida(String orgida) {
		this.orgida = orgida;
	}

	/**
	 * 用户机构名称取得
	 * @return 用户机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 用户机构名称设定
	 *
	 * @param orgname 用户机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 用户角色类型设定
	 *
	 * @param roletype 用户角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo() {
		return userinfo;
	}
	
	/**
	 * 工号设定
	 *
	 * @param userinfo 工号 
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo_like() {
		return userinfo_like;
	}
	
	/**
	 * 工号设定
	 *
	 * @param userinfo_like 工号 
	 */
	public void setUserinfo_like(String userinfo_like) {
		this.userinfo_like = userinfo_like;
	}

	/**
	 * 用户名称，PMS系统对接专用取得
	 * @return username_forPms 用户名称，PMS系统对接专用
	 */
	
	public String getUsername_forPms() {
		return username_forPms;
	}

	/**
	 * 用户名称，PMS系统对接专用设定
	 * @param username_forPms 用户名称，PMS系统对接专用
	 */
	public void setUsername_forPms(String username_forPms) {
		this.username_forPms = username_forPms;
	}
	
}
