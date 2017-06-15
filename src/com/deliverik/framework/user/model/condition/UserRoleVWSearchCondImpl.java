package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * 用户角色授权信息检索条件实现
 * 
 */
public class UserRoleVWSearchCondImpl implements UserRoleVWSearchCond {

	/** 用户ID */
	protected String userid;
	
	/** 用户角色ID */
	protected Integer roleid;
	
	/** 用户角色类型 */
	protected String roletype;
	
	/** 用户角色类型 */
	protected String roles_Like;
	
	/** 扩展角色类型 */
	protected String[] roles_BP_EX;
	
	/** 是否角色负责人 */
	protected boolean rolemanager;
	
	/** 是否角色值班人 */
	protected boolean dutyflag;
	
	/** 角色管理内容 */
	public String assetdomain;
	
	/** 角色机构管理范围 */
	protected String roledomain_like;
	
	/** 角色机构管理范围 */
	protected String roledomain;
	
	/** 机构syscoding左侧模糊查询 */
	protected String orgid_like;
	
	/** 角色范围 */
	protected List<Integer> roleid_in;
	
	/** 按角色用户授权ID查询 */
	protected Integer urid_eq;
	
	/** 按角色名称模糊查询 */
	protected String rolename_like;

	/** 用户名 */
	protected String username_like;
	
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
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoles_Like() {
		return roles_Like;
	}

	/**
	 * 用户角色类型设定
	 *
	 * @param roles_Like 用户角色类型
	 */
	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	/**
	 * 扩展用户角色类型取得
	 * @return 扩展用户角色类型
	 */
	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	/**
	 * 扩展用户角色类型设定
	 *
	 * @param roles_BP_EX 扩展用户角色类型
	 */
	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	/**
	 * 角色负责人取得
	 * @return 角色负责人
	 */
	public boolean isRolemanager() {
		return rolemanager;
	}

	/**
	 * 角色负责人设定
	 *
	 * @param rolemanager 角色负责人
	 */
	public void setRolemanager(boolean rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * 角色值班人取得
	 * @return 角色值班人
	 */
	public boolean isDutyflag() {
		return dutyflag;
	}

	/**
	 * 角色值班人设定
	 *
	 * @param dutyflag 角色值班人
	 */
	public void setDutyflag(boolean dutyflag) {
		this.dutyflag = dutyflag;
	}

	/**
	 * 角色管理内容取得
	 * 
	 * @return 角色管理内容
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * 角色管理内容设定
	 * 
	 * @param assetdomain 角色管理内容
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * 角色机构管理范围取得
	 * 
	 * @return 角色机构管理范围
	 */
	public String getRoledomain_like() {
		return roledomain_like;
	}

	/**
	 * 角色机构管理范围设定
	 * 
	 * @param roledomain_like 角色机构管理范围
	 */
	public void setRoledomain_like(String roledomain_like) {
		this.roledomain_like = roledomain_like;
	}
	
	/**
	 * 角色机构管理范围取得
	 * 
	 * @return 角色机构管理范围
	 */
	public String getRoledomain() {
		return roledomain;
	}

	/**
	 * 角色机构管理范围设定
	 * 
	 * @param roledomain 角色机构管理范围
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * 机构syscoding左侧模糊查询取得
	 *
	 * @return orgid_like 机构syscoding左侧模糊查询
	 */
	public String getOrgid_like() {
		return orgid_like;
	}

	/**
	 * 机构syscoding左侧模糊查询设定
	 *
	 * @param orgid_like 机构syscoding左侧模糊查询
	 */
	public void setOrgid_like(String orgid_like) {
		this.orgid_like = orgid_like;
	}
	
	/**
	 * 角色范围取得
	 *
	 * @return roleid_in 角色范围
	 */
	public List<Integer> getRoleid_in() {
		return roleid_in;
	}

	/**
	 * 角色范围设定
	 *
	 * @param roleid_in 角色范围
	 */
	public void setRoleid_in(List<Integer> roleid_in) {
		this.roleid_in = roleid_in;
	}
	
	/**
	 * 按角色名称模糊查询取得
	 *
	 * @return rolename_like 按角色名称模糊查询
	 */
	public String getRolename_like() {
		return rolename_like;
	}
	
	/**
	 * 按角色用户授权ID查询取得
	 *
	 * @return urid_eq 按角色用户授权ID查询
	 */
	public Integer getUrid_eq() {
		return urid_eq;
	}

	/**
	 * 按角色用户授权ID查询设定
	 *
	 * @param urid 按角色用户授权ID查询
	 */
	public void setUrid_eq(Integer urid_eq) {
		this.urid_eq = urid_eq;
	}

	/**
	 * 按角色名称模糊查询设定
	 *
	 * @param rolename_like 按角色名称模糊查询
	 */
	public void setRolename_like(String rolename_like) {
		this.rolename_like = rolename_like;
	}
	
	/**
	 * 用户名取得
	 * @return username_like 用户名
	 */
	public String getUsername_like() {
		return username_like;
	}

	/**
	 * 用户名设定
	 * @param username_like 用户名
	 */
	public void setUsername_like(String username_like) {
		this.username_like = username_like;
	}
	
}
