/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * 资产信息
 */
public class EntityItem implements EntityItemInfo {

	/** 资产ID */
	protected Integer eiid;
	
	/** 资产名称 */
	protected String einame;

	/** 资产编 */
	protected String eilabel;

	/** 资产所属机构层次码 */
	protected String eiorgsyscoding;

	/** 资产所属模型层次码 */
	protected String esyscoding;

	/** 资产管理人ID */
	protected String eiuserid;

	/** 资产管理人姓名 */
	protected String eiusername;
	
	/** 资产版本 */
	protected Integer eiversion;
	
	/** 资产小版本*/
	protected Integer eismallversion;

	/** 资产属性信息列表 */
	protected List<ConfigItemInfo> configItems;
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid() {
		return eiid;
	}

	/**
	 * 资产ID设定
	 * @param eiid 资产ID
	 */
	public void setEiid(Integer eiid) {
		this.eiid = eiid;
	}

	/**
	 * 资产名称取得
	 * 
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
	 * 资产编取得
	 * 
	 * @return 资产编
	 */
	public String getEilabel() {
		return eilabel;
	}

	/**
	 * 资产编设定
	 * 
	 * @param eilabel 资产编
	 */
	public void setEilabel(String eilabel) {
		this.eilabel = eilabel;
	}

	/**
	 * 资产所属机构层次码取得
	 * 
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
	 * 资产所属模型层次码取得
	 * 
	 * @return 资产所属模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产所属模型层次码设定
	 * 
	 * @param esyscoding 资产所属模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产管理人ID取得
	 * 
	 * @return 资产管理人ID
	 */
	public String getEiuserid() {
		return eiuserid;
	}

	/**
	 * 资产管理人ID信息设定
	 * 
	 * @param eiuserid 资产管理人ID
	 */
	public void setEiuserid(String eiuserid) {
		this.eiuserid = eiuserid;
	}

	/**
	 * 资产管理人姓名取得
	 * 
	 * @return 资产管理人姓名
	 */
	public String getEiusername() {
		return eiusername;
	}

	/**
	 * 资产管理人姓名设定
	 * 
	 * @param eiusername 资产管理人姓名
	 */
	public void setEiusername(String eiusername) {
		this.eiusername = eiusername;
	}

	/**
	 * 资产版本取得
	 * @return 资产版本
	 */
	public Integer getEiversion() {
		return eiversion;
	}

	/**
	 * 资产版本设定
	 *
	 * @param eiversion 资产版本
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

	/**
	 * 资产属性信息列表取得
	 * 
	 * @return 资产属性信息列表
	 */
	public List<ConfigItemInfo> getConfigItems() {
		return configItems;
	}

	/**
	 * 资产属性信息列表
	 * 
	 * @param configItems 资产属性信息列表设定
	 */
	public void setConfigItems(List<ConfigItemInfo> configItems) {
		this.configItems = configItems;
	}
	
}
