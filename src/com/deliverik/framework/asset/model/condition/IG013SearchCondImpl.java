package com.deliverik.framework.asset.model.condition;

import java.util.List;

/**
 * 资产信息检索条件实现
 * 
 */
public class IG013SearchCondImpl implements IG013SearchCond {

	/** 资产模型ID */
	protected String eid;
	
	/** 资产编号 */
	protected String eilabel;
	
	/** 资产名称 */
	protected String einame;
	
	/** 资产版本号 */
	protected Integer eiversion;
	
	/** 资产小版本*/
	protected Integer eismallversion;
	
	/** 资产所属机构层次码 */
	protected String eiorgsyscoding;
	
	/** 资产ID（平台保留） */
	protected String eiid;
	
	protected List<String> eilabel_list;
	
	/** 资产名称（完全匹配 ）*/
	protected String einame_equal;
	
	
	/**
	 * 资产名称（完全匹配 ）取得
	 * @return 资产名称（完全匹配 ）
	 */
	public String getEiname_equal() {
		return einame_equal;
	}

	/**
	 * 资产名称（完全匹配 ）设定
	 *
	 * @param einame_equal 资产名称（完全匹配 ）
	 */
	public void setEiname_equal(String einame_equal) {
		this.einame_equal = einame_equal;
	}

	public List<String> getEilabel_list() {
		return eilabel_list;
	}

	public void setEilabel_list(List<String> eilabel_list) {
		this.eilabel_list = eilabel_list;
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
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}
	/**
	 * 资产所属机构层次码设定
	 *
	 * @param eiorgsyscoding 资产所属机构层次码
	 */
	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编号设定
	 *
	 * @param eilabel 资产编号
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname() {
		return einame;
	}


	/**
	 * 资产名称设定
	 *
	 * @param einame 资产名称
	 */
	public void setEiname(String einame) {
		this.einame = einame;
	}

	/**
	 * 资产版本号取得
	 * @return 资产版本号
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本号设定
	 *
	 * @param eiversion 资产版本号
	 */
	public void setEiversion(Integer eiversion) {
		this.eiversion = eiversion;
	}
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion() {
		return eismallversion;
	}
	
	/**
	 * 资产小版本设定
	 *
	 * @param eismallversion 资产小版本
	 */
	public void setEismallversion(Integer eismallversion) {
		this.eismallversion = eismallversion;
	}
}
