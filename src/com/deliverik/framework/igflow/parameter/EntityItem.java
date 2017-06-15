/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.parameter;

import java.util.List;

/**
 * 资产相关信息
 */
public class EntityItem implements EntityItemInfo {

	/** 资产名称 */
	protected String einame;

	/** 资产说明 */
	protected String eidesc;

	/** 资产编号 */
	protected String eilabel;

	/** 资产所属机构层次码 */
	protected String eiorgsyscoding;

	/** 资产所属模型层次码 */
	protected String esyscoding;

	/** 资产管理人ID */
	protected String eiuserid;

	/** 资产管理人姓名 */
	protected String eiusername;

	/** 资产状态 */
	protected String eistatus;

	/** 时间戳 */
	protected String fingerPrint;

	/** 资产配置属性信息 */
	protected List<EntityItemConfigValueInfo> configItems;
	
	/** 检查项登记日 */
	protected String eiinsdate;
	
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
	 * 资产说明取得
	 * 
	 * @return 资产说明
	 */
	public String getEidesc() {
		return eidesc;
	}

	/**
	 * 资产说明设定
	 * 
	 * @param eidesc 资产说明
	 */
	public void setEidesc(String eidesc) {
		this.eidesc = eidesc;
	}

	/**
	 * 资产编号取得
	 * 
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
	 * 资产管理人ID设定
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
	 * 资产状态取得
	 * 
	 * @return 资产状态
	 */
	public String getEistatus() {
		return eistatus;
	}

	/**
	 * 资产状态设定
	 * 
	 * @param eistatus 资产状态
	 */
	public void setEistatus(String eistatus) {
		this.eistatus = eistatus;
	}

	/**
	 * 时间戳取得
	 * 
	 * @return 时间戳
	 */
	public String getFingerPrint() {
		return fingerPrint;
	}

	/**
	 * 时间戳设定
	 * 
	 * @param fingerPrint 时间戳
	 */
	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}

	/**
	 * 资产配置属性信息取得
	 * 
	 * @return 资产配置属性信息
	 */
	public List<EntityItemConfigValueInfo> getConfigItems() {
		return configItems;
	}

	/**
	 * 资产配置属性信息设定
	 * 
	 * @param configItems 资产配置属性信息
	 */
	public void setConfigItems(List<EntityItemConfigValueInfo> configItems) {
		this.configItems = configItems;
	}

	/**
	 * 检查项登记日取得
	 * @return eiinsdate  检查项登记日
	 */
	public String getEiinsdate() {
		return eiinsdate;
	}

	/**
	 * 检查项登记日设定
	 * @param eiinsdate  检查项登记日
	 */
	public void setEiinsdate(String eiinsdate) {
		this.eiinsdate = eiinsdate;
	}
}
