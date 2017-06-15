/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;

/**
  * 概述: SOC0117VW实体
  * 功能描述: SOC0117VW实体
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0117VWPK.class)
@Table(name="SOC0117VW")
public class SOC0117VW extends BaseEntity implements Serializable,
		Cloneable, SOC0117VWInfo {

	/** 主键 */
	@Id
	protected Integer id;

	/** 资产类型id */
	@Id
	protected String eid;

	/** 资产类型名称 */
	protected String ename;

	/** 系统预置模型标识 */
	protected String elabel;

	/** 资产模型的说明 */
	protected String edesc;

	/** 资产模型状态 */
	protected String estatus;

	/** 资产模型的分类 */
	protected String ecategory;

	/** 资产模型一级子类 */
	protected String ekey1;

	/** 资产模型二级子类 */
	protected String ekey2;

	/** 资产模型三级子类 */
	protected String ekey3;

	/** 资产模型的层次码 */
	protected String esyscoding;

	/** 资产模型的上级模型层次码 */
	protected String eparcoding;
	
	/**
	 * 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	protected String emodeltype;

	/**
	 * @return the emodeltype
	 */
	public String getEmodeltype() {
		return emodeltype;
	}

	/**
	 * @param emodeltype the emodeltype to set
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * 主键设定
	 *
	 * @param id 主键
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 资产类型id取得
	 *
	 * @return 资产类型id
	 */
	public String getEid() {
		return eid;
	}

	/**
	 * 资产类型id设定
	 *
	 * @param eid 资产类型id
	 */
	public void setEid(String eid) {
		this.eid = eid;
	}

	/**
	 * 资产类型名称取得
	 *
	 * @return 资产类型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产类型名称设定
	 *
	 * @param ename 资产类型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}

	/**
	 * 系统预置模型标识取得
	 *
	 * @return 系统预置模型标识
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 系统预置模型标识设定
	 *
	 * @param elabel 系统预置模型标识
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型的说明取得
	 *
	 * @return 资产模型的说明
	 */
	public String getEdesc() {
		return edesc;
	}

	/**
	 * 资产模型的说明设定
	 *
	 * @param edesc 资产模型的说明
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}

	/**
	 * 资产模型状态取得
	 *
	 * @return 资产模型状态
	 */
	public String getEstatus() {
		return estatus;
	}

	/**
	 * 资产模型状态设定
	 *
	 * @param estatus 资产模型状态
	 */
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}

	/**
	 * 资产模型的分类取得
	 *
	 * @return 资产模型的分类
	 */
	public String getEcategory() {
		return ecategory;
	}

	/**
	 * 资产模型的分类设定
	 *
	 * @param ecategory 资产模型的分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}

	/**
	 * 资产模型一级子类取得
	 *
	 * @return 资产模型一级子类
	 */
	public String getEkey1() {
		return ekey1;
	}

	/**
	 * 资产模型一级子类设定
	 *
	 * @param ekey1 资产模型一级子类
	 */
	public void setEkey1(String ekey1) {
		this.ekey1 = ekey1;
	}

	/**
	 * 资产模型二级子类取得
	 *
	 * @return 资产模型二级子类
	 */
	public String getEkey2() {
		return ekey2;
	}

	/**
	 * 资产模型二级子类设定
	 *
	 * @param ekey2 资产模型二级子类
	 */
	public void setEkey2(String ekey2) {
		this.ekey2 = ekey2;
	}

	/**
	 * 资产模型三级子类取得
	 *
	 * @return 资产模型三级子类
	 */
	public String getEkey3() {
		return ekey3;
	}

	/**
	 * 资产模型三级子类设定
	 *
	 * @param ekey3 资产模型三级子类
	 */
	public void setEkey3(String ekey3) {
		this.ekey3 = ekey3;
	}

	/**
	 * 资产模型的层次码取得
	 *
	 * @return 资产模型的层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型的层次码设定
	 *
	 * @param esyscoding 资产模型的层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 资产模型的上级模型层次码取得
	 *
	 * @return 资产模型的上级模型层次码
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * 资产模型的上级模型层次码设定
	 *
	 * @param eparcoding 资产模型的上级模型层次码
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0117VWPK(id, eid);
	}

}