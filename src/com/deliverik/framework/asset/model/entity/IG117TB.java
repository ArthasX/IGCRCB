package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.base.BaseEntity;

/**
 * <p>
 * 资产模型信息实体
 * </p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG117")
public class IG117TB extends BaseEntity implements Serializable, Cloneable, IG117Info {

	/** 
	 * 资产模型ID 
	 */
	@Id
	@TableGenerator(
		    name="IG117_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG117_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG117_TABLE_GENERATOR")
	protected Integer eid;
	
	/** 资产模型名称 */
	protected String ename;
	
	/** 资产模型编号 */
	protected String elabel;

	/** 资产模型说明 */
	protected String edesc;

	/** 资产模型状态 */
	protected String estatus;
	
	/** 资产模型分类 */
	protected String ecategory;
	
	/** 资产模型一级子类 */
	protected String ekey1;
	
	/** 资产模型二级子类 */
	protected String ekey2;
	
	/** 资产模型三级子类 */
	protected String ekey3;
	
	/**
	 * 资产模型层次码
	 */
	protected String esyscoding;
	
	/**
	 * 资产模型父级层次码
	 */
	protected String eparcoding;
	
	/**
	 * 资产模型类别（0：一般资产模型 1：配置资产模型）
	 */
	protected String emodeltype;

	/**
	 * 资产模型父级层次码取得
	 * @return 资产模型父级层次码
	 */
	public String getEparcoding() {
		return eparcoding;
	}

	/**
	 * 资产模型父级层次码设定
	 *
	 * @param eparcoding 资产模型父级层次码
	 */
	public void setEparcoding(String eparcoding) {
		this.eparcoding = eparcoding;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return eid;
	}

	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public Integer getEid() {
		return eid;
	}

	/**
	 * 资产模型ID设定
	 *
	 * @param eid 资产模型ID
	 */
	public void setEid(Integer eid) {
		this.eid = eid;
	}

	/**
	 * 资产模型名称取得
	 * @return 资产模型名称
	 */
	public String getEname() {
		return ename;
	}

	/**
	 * 资产模型名称设定
	 *
	 * @param ename 资产模型名称
	 */
	public void setEname(String ename) {
		this.ename = ename;
	}


	/**
	 * 资产模型说明取得
	 * @return 资产模型说明
	 */
	public String getEdesc() {
		return edesc;
	}


	/**
	 * 资产模型说明设定
	 *
	 * @param edesc 资产模型说明
	 */
	public void setEdesc(String edesc) {
		this.edesc = edesc;
	}


	/**
	 * 资产模型状态取得
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
	 * 资产模型分类取得
	 * @return 资产模型分类
	 */
	public String getEcategory() {
		return ecategory;
	}


	/**
	 * 资产模型分类设定
	 *
	 * @param ecategory 资产模型分类
	 */
	public void setEcategory(String ecategory) {
		this.ecategory = ecategory;
	}


	/**
	 * 资产模型一级子类取得
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
	 * 资产模型编号取得
	 * @return 资产模型编号
	 */
	public String getElabel() {
		return elabel;
	}

	/**
	 * 资产模型编号设定
	 *
	 * @param elabel 资产模型编号
	 */
	public void setElabel(String elabel) {
		this.elabel = elabel;
	}

	/**
	 * 资产模型层次码取得
	 * @return 资产模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型层次码设定
	 *
	 * @param esyscoding 资产模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	/**
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype() {
		return emodeltype;
	}
	
	/**
	 * 资产模型类别设定
	 *
	 * @param eparcoding 资产模型类别
	 */
	public void setEmodeltype(String emodeltype) {
		this.emodeltype = emodeltype;
	}

}
