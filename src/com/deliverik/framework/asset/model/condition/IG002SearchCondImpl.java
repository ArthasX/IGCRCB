package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * 资产属性信息检索条件实现
 * 
 */
public class IG002SearchCondImpl implements IG002SearchCond {

	/** 资产ID */
	protected Integer eiid;
	
	/** 资产模型属性名称 */
	protected String cname;
	
	/** 资产模型层次码 */
	protected String esyscoding_q;
	
	/** 属性编号（SOC） */
	protected String clabel_q;
	
	/** 资产ID集合（SOC） */
	protected List<Integer> eiid_list;
	
	/** 资产层次编码集合（SOC） */
	protected List<String> esyscode_list;
	
	protected String sreilabel_q;
	
	protected String srname_q;
	
	/** 资产模型id */
	protected String eid_q;
	
	/** 版本 */
	protected String civersion;

	/**
	 * 资产模型id取得
	 *
	 * @return eid_q 资产模型id
	 */
	
	public String getEid_q() {
		return eid_q;
	}

	/**
	 * 资产模型id设定
	 *
	 * @param eid_q 资产模型id
	 */
	
	public void setEid_q(String eid_q) {
		this.eid_q = eid_q;
	}

	public String getSrname_q() {
		return srname_q;
	}

	public void setSrname_q(String srname_q) {
		this.srname_q = srname_q;
	}

	public String getSreilabel_q() {
		return sreilabel_q;
	}

	public void setSreilabel_q(String sreilabel_q) {
		this.sreilabel_q = sreilabel_q;
	}

	/**
	 * 资产ID集合（SOC）
	 * @return 资产ID集合（SOC）
	 */
	public List<Integer> getEiid_list() {
		return eiid_list;
	}

	/**
	 * 资产ID集合（SOC）设定
	 *
	 * @param eiid_list 资产ID集合（SOC）
	 */
	public void setEiid_list(List<Integer> eiid_list) {
		this.eiid_list = eiid_list;
	}

	/**
	 * 资产层次编码集合（SOC）
	 * @return 资产层次编码集合（SOC）
	 */
	public List<String> getEsyscode_list() {
		return esyscode_list;
	}

	/**
	 * 资产层次编码集合（SOC）设定
	 *
	 * @param esyscode_list 资产层次编码集合（SOC）
	 */
	public void setEsyscode_list(List<String> esyscode_list) {
		this.esyscode_list = esyscode_list;
	}

	/**
	 * 资产模型层次码取得（SOC）
	 * @return 资产模型层次码
	 */
	public String getClabel_q() {
		return clabel_q;
	}

	/**
	 * 资产模型层次码设定（SOC）
	 *
	 * @param clabel_q 资产模型层次码
	 */
	public void setClabel_q(String clabel_q) {
		this.clabel_q = clabel_q;
	}


	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding_q() {
		return esyscoding_q;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding_q 资产模型层次码
	 */
	public void setEsyscoding_q(String esyscoding_q) {
		this.esyscoding_q = esyscoding_q;
	}

	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产模型属性名称取得
	 * @return 资产模型属性名称
	 */
	public String getCname() {
		return cname;
	}

	/**
	 * 资产模型属性名称设定
	 *
	 * @param cname 资产模型属性名称
	 */
	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCiversion() {
		return civersion;
	}

	public void setCiversion(String civersion) {
		this.civersion = civersion;
	}
	
}
