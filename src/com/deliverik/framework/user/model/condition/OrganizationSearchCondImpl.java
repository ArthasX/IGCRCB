package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * 机构信息检索条件实现
 * 
 */
public class OrganizationSearchCondImpl implements OrganizationSearchCond {

	/** 机构名称 */
	protected String orgname;
	
	/** 机构名称 */
	protected String orgname_q;
	
	/** 机构名称(模糊查询) */
	protected String orgname_like;

	/** 上级机构层次码 */
	protected String orgpar;

	/** 机构状态 */
	protected String is_in_use;

	/** 上级机构层次码 */
	protected String orgparid;

	/** 上级机构层次码 */
	protected Integer orgsuper;

	/** 机构层次码 */
	protected String orgsyscoding;

	/** 机构层次码集合 */
	protected List<String> syscoding_area;
	
	/** 角色机构管理范围 */
	protected String roledomain_q;
	
	/** 角色机构管理范围结点全名（平台保留） */
	protected String complete_name;
	
	/** 上级机构层次码 */
	protected String orgparstr_q;
	
	/** 机构层次码 */
	protected String orgsyscoding_q;
	
	/** 排序方式 */
	protected String sortType;

	/** 机构层次码集合（平台保留） */
	protected List<String> not_in_syscoding_area;
	
	/** 需要过滤的机构层次码（平台保留） */
	protected String xbtype;
	
	
	
	/**
	 * 机构名称(模糊查询)取得
	 *
	 * @return orgname_like 机构名称(模糊查询)
	 */
	public String getOrgname_like() {
		return orgname_like;
	}

	/**
	 * 机构名称(模糊查询)设定
	 *
	 * @param orgname_like 机构名称(模糊查询)
	 */
	public void setOrgname_like(String orgname_like) {
		this.orgname_like = orgname_like;
	}

	/**
	 * 需要过滤的机构层次码取得（平台保留）
	 * @return 需要过滤的机构层次码
	 */
	public String getXbtype() {
		return xbtype;
	}

	/**
	 * 需要过滤的机构层次码设定
	 *
	 * @param xbtype 需要过滤的机构层次码
	 */
	public void setXbtype(String xbtype) {
		this.xbtype = xbtype;
	}

	/**
	 * 机构层次码集合取得（平台保留）
	 * @return 机构层次码集合
	 */
	public List<String> getNot_in_syscoding_area() {
		return not_in_syscoding_area;
	}

	/**
	 * 机构层次码集合设定
	 *
	 * @param not_in_syscoding_area 机构层次码集合
	 */
	public void setNot_in_syscoding_area(List<String> not_in_syscoding_area) {
		this.not_in_syscoding_area = not_in_syscoding_area;
	}
	
	/**
	 * 排序方式取得
	 * @return 排序方式
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * 排序方式设定
	 *
	 * @param sortType 排序方式
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}
	
	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname_q() {
		return orgname_q;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname_q 机构名称
	 */
	public void setOrgname_q(String orgname_q) {
		this.orgname_q = orgname_q;
	}

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgpar() {
		return orgpar;
	}

	/**
	 * 上级机构层次码设定
	 *
	 * @param orgpar 上级机构层次码
	 */
	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * 机构状态取得
	 * @return 机构状态
	 */
	public String getIs_in_use() {
		return is_in_use;
	}

	/**
	 * 机构状态设定
	 *
	 * @param is_in_use 机构状态
	 */
	public void setIs_in_use(String is_in_use) {
		this.is_in_use = is_in_use;
	}

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgparid() {
		return orgparid;
	}

	/**
	 * 上级机构层次码设定
	 *
	 * @param orgparid 上级机构层次码
	 */
	public void setOrgparid(String orgparid) {
		this.orgparid = orgparid;
	}

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public Integer getOrgsuper() {
		return orgsuper;
	}

	/**
	 * 上级机构层次码设定
	 *
	 * @param orgsuper 上级机构层次码
	 */
	public void setOrgsuper(Integer orgsuper) {
		this.orgsuper = orgsuper;
	}

	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param orgsyscoding 机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 机构层次码集合取得
	 * @return 机构层次码集合
	 */
	public List<String> getSyscoding_area() {
		return syscoding_area;
	}

	/**
	 * 机构层次码集合设定
	 *
	 * @param syscoding_area 机构层次码集合
	 */
	public void setSyscoding_area(List<String> syscoding_area) {
		this.syscoding_area = syscoding_area;
	}

	/**
	 * 角色机构管理范围取得
	 * @return 角色机构管理范围
	 */
	public String getRoledomain_q() {
		return roledomain_q;
	}

	/**
	 * 角色机构管理范围设定
	 *
	 * @param roledomain_q 角色机构管理范围
	 */
	public void setRoledomain_q(String roledomain_q) {
		this.roledomain_q = roledomain_q;
	}

	/**
	 * 角色机构管理范围结点全名取得
	 * @return 角色机构管理范围结点全名
	 */
	public String getComplete_name() {
		return complete_name;
	}

	/**
	 * 角色机构管理范围结点全名设定
	 *
	 * @param complete_name 角色机构管理范围结点全名
	 */
	public void setComplete_name(String complete_name) {
		this.complete_name = complete_name;
	}

	/**
	 * 上级机构层次码取得
	 * @return 上级机构层次码
	 */
	public String getOrgparstr_q() {
		return orgparstr_q;
	}

	/**
	 * 上级机构层次码设定
	 *
	 * @param orgparstr_q 上级机构层次码
	 */
	public void setOrgparstr_q(String orgparstr_q) {
		this.orgparstr_q = orgparstr_q;
	}

	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgsyscoding_q() {
		return orgsyscoding_q;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param orgsyscoding_q 机构层次码
	 */
	public void setOrgsyscoding_q(String orgsyscoding_q) {
		this.orgsyscoding_q = orgsyscoding_q;
	}

}
