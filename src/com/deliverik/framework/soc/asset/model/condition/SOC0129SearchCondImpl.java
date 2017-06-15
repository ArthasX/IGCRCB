package com.deliverik.framework.soc.asset.model.condition;

import java.util.List;

import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;

/**
 * 资产属性信息检索条件实现
 * 
 */
public class SOC0129SearchCondImpl implements SOC0129SearchCond {
	
	/** 数据库ID */
	protected String id;

	/** 资产ID */
	protected String eiid;
	
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
	
	/** 检查项版本 */
	protected int checkersion;
	

	/**
	 * @return the 数据库ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * 检查项版本取得
	 * @return checkersion 检查项版本
	 */
	public int getCheckersion() {
		return checkersion;
	}

	/**
	 * 检查项版本设定
	 * @param checkersion 检查项版本
	 */
	public void setCheckersion(int checkersion) {
		this.checkersion = checkersion;
	}

	/** 是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承*/
	protected String ekey2;
	
	public String getEkey2() {
		return ekey2;
	}

	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
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
	public String getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 *
	 * @param eiid 资产ID
	 */
	public void setEiid(String eiid) {
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
	
}
