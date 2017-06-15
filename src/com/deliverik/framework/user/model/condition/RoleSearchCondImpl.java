package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * 角色信息检索条件实现
 * 
 */
public class RoleSearchCondImpl implements RoleSearchCond {

	/** 角色名称 */
	protected String rolename;
	
	/** 角色名称 */
	protected String rolename_q;

	/** 角色类型*/
	protected String roletype;

	/** 角色类型 */
	protected String roles_Like;

	/** 扩展角色类型 */
	protected String[] roles_BP_EX;
	
	/** SQL语句比较关系 */
	protected int roletypeEqual;

	/** 角色机构管理范围 */
	protected String roledomain;

	/** 角色机构管理范围 */
	protected String roledomain_Like;

	/** 角色资产管理范围 */
	protected String assetdomain;

	/** 角色资产管理范围 */
	protected String assetdomain_q;
	
	/** 角色类型查询条件（角色类型大于）*/
	protected String roletype_gt;
	
	/** 自定义流程ID */
	protected String pdid;
	
	/** 角色ID范围 */
	protected List<Integer> roleid_in;
	
	/** 角色ID不在此范围 */
	protected String roleid_not_in;
	
	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 角色类型查询条件取得
	 * @return 角色类型查询条件
	 */
	public String getRoletype_gt() {
		return roletype_gt;
	}

	/**
	 * 角色类型查询条件设定
	 *
	 * @param roletype_gt 角色类型查询条件
	 */
	public void setRoletype_gt(String roletype_gt) {
		this.roletype_gt = roletype_gt;
	}

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 角色名称设定
	 *
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename_q() {
		return rolename_q;
	}

	/**
	 * 角色名称设定
	 *
	 * @param rolename_q 角色名称
	 */
	public void setRolename_q(String rolename_q) {
		this.rolename_q = rolename_q;
	}

	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 角色类型设定
	 *
	 * @param roletype 角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 角色类型取得
	 * @return 角色类型
	 */
	public String getRoles_Like() {
		return roles_Like;
	}

	/**
	 * 角色类型设定
	 *
	 * @param roles_Like 角色类型
	 */
	public void setRoles_Like(String roles_Like) {
		this.roles_Like = roles_Like;
	}

	/**
	 * 扩展角色类型取得
	 * @return 扩展角色类型
	 */
	public String[] getRoles_BP_EX() {
		return roles_BP_EX;
	}

	/**
	 * 扩展角色类型设定
	 *
	 * @param roles_BP_EX 扩展角色类型
	 */
	public void setRoles_BP_EX(String[] roles_BP_EX) {
		this.roles_BP_EX = roles_BP_EX;
	}

	/**
	 * SQL语句比较关系取得
	 * @return SQL语句比较关系
	 */
	public int getRoletypeEqual() {
		return roletypeEqual;
	}

	/**
	 * SQL语句比较关系设定
	 *
	 * @param roletypeEqual SQL语句比较关系
	 */
	public void setRoletypeEqual(int roletypeEqual) {
		this.roletypeEqual = roletypeEqual;
	}

	/**
	 * 角色机构管理范围取得
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
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain_Like() {
		return roledomain_Like;
	}

	/**
	 * 角色机构管理范围设定
	 *
	 * @param roledomain_Like 角色机构管理范围
	 */
	public void setRoledomain_Like(String roledomain_Like) {
		this.roledomain_Like = roledomain_Like;
	}

	/**
	 * 角色资产管理范围取得
	 * @return 角色资产管理范围
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * 角色资产管理范围设定
	 *
	 * @param assetdomain 角色资产管理范围
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * 角色资产管理范围取得
	 * @return 角色资产管理范围
	 */
	public String getAssetdomain_q() {
		return assetdomain_q;
	}

	/**
	 * 角色资产管理范围设定
	 *
	 * @param assetdomain_q 角色资产管理范围
	 */
	public void setAssetdomain_q(String assetdomain_q) {
		this.assetdomain_q = assetdomain_q;
	}
	
	/**
	 * 角色ID范围取得
	 * @return roleid_in 角色ID范围
	 */
	public List<Integer> getRoleid_in() {
		return roleid_in;
	}

	/**
	 * 角色ID范围设定
	 * @param roleid_in 角色ID范围
	 */
	public void setRoleid_in(List<Integer> roleid_in) {
		this.roleid_in = roleid_in;
	}
	
	/**
	 * 角色ID不在此范围取得
	 * @return 角色ID不在此范围
	 */
	public String getRoleid_not_in() {
		return roleid_not_in;
	}

	/**
	 * 角色ID不在此范围设定
	 * @param roleid_not_in 角色ID不在此范围
	 */
	public void setRoleid_not_in(String roleid_not_in) {
		this.roleid_not_in = roleid_not_in;
	}
}
