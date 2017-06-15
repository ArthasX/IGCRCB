package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.base.BaseEntity;


/**
 * 资产模型属性信息实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG225")
public class IG225TB extends BaseEntity implements Serializable, Cloneable, IG225Info {

	/** 资产模型属性ID */
	@Id
	@TableGenerator(
		    name="IG225_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IG225_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG225_TABLE_GENERATOR")
	protected Integer cid;
	
	/** 资产模型ID（外键） */
	protected Integer eid;
	
	/** 资产模型属性名称 */
	protected String cname;

	/** 资产模型属性说明 */
	protected String cdesc;
	
	/** 资产模型属性单位 */
	protected String cunit;

	/** 资产模型属性状态 */
	protected String cstatus;
	
	/** 资产模型属性是否显示标识（1显示，0不显示） */
	protected Integer cseq;
	
	/** 资产模型属性所属模型的模型分类 */
	protected String ccategory;
	
	/** 资产模型属性取值范围ID */
	protected String coption;
	
	/** 资产模型属性编号 */
	protected String clabel;

	/** 资产模型属性数据类型 */
	protected String cattach;
	
	/** 资产模型属性所属模型层次码 */
	public String esyscoding;
	
	/** 资产模型属性必填项 */
	protected String crequired;

	/**
	 * 资产模型属性所属模型层次码取得
	 * @return 资产模型属性所属模型层次码
	 */
	public String getEsyscoding() {
		return esyscoding;
	}

	/**
	 * 资产模型属性所属模型层次码设定
	 *
	 * @param esyscoding 资产模型属性所属模型层次码
	 */
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return cid;
	}

	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public Integer getCid() {
		return cid;
	}

	/**
	 * 资产模型属性ID设定
	 *
	 * @param cid 资产模型属性ID
	 */
	public void setCid(Integer cid) {
		this.cid = cid;
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

	/**
	 * 资产模型属性说明取得
	 * @return 资产模型属性说明
	 */
	public String getCdesc() {
		return cdesc;
	}

	/**
	 * 资产模型属性说明设定
	 *
	 * @param cdesc 资产模型属性说明
	 */
	public void setCdesc(String cdesc) {
		this.cdesc = cdesc;
	}

	/**
	 * 资产模型属性单位取得
	 * @return 资产模型属性单位
	 */
	public String getCunit() {
		return cunit;
	}

	/**
	 * 资产模型属性单位设定
	 *
	 * @param cunit 资产模型属性单位
	 */
	public void setCunit(String cunit) {
		this.cunit = cunit;
	}

	/**
	 * 资产模型属性分类取得
	 * @return 资产模型属性分类
	 */
	public String getCcategory() {
		return ccategory;
	}

	/**
	 * 资产模型属性分类设定
	 *
	 * @param ccategory 资产模型属性分类
	 */
	public void setCcategory(String ccategory) {
		this.ccategory = ccategory;
	}

	/**
	 * 资产模型属性状态取得
	 * @return 资产模型属性状态
	 */
	public String getCstatus() {
		return cstatus;
	}

	/**
	 * 资产模型属性状态设定
	 *
	 * @param cstatus 资产模型属性状态
	 */
	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	/**
	 * 资产模型属性是否显示标识取得
	 * @return 资产模型属性是否显示标识
	 */
	public Integer getCseq() {
		return cseq;
	}

	/**
	 * 资产模型属性是否显示标识设定
	 *
	 * @param cseq 资产模型属性是否显示标识
	 */
	public void setCseq(Integer cseq) {
		this.cseq = cseq;
	}

	/**
	 * 资产模型属性取值范围ID取得
	 * @return 资产模型属性取值范围ID
	 */
	public String getCoption() {
		return coption;
	}

	/**
	 * 资产模型属性取值范围ID设定
	 *
	 * @param coption 资产模型属性取值范围ID
	 */
	public void setCoption(String coption) {
		this.coption = coption;
	}

	/**
	 * 资产模型属性编号取得
	 * @return 资产模型属性编号
	 */
	public String getClabel() {
		return clabel;
	}

	/**
	 * 资产模型属性编号设定
	 *
	 * @param clabel 资产模型属性编号
	 */
	public void setClabel(String clabel) {
		this.clabel = clabel;
	}

	/**
	 * 资产模型属性数据类型取得
	 * @return 资产模型属性数据类型
	 */
	public String getCattach() {
		return cattach;
	}

	/**
	 * 资产模型属性数据类型设定
	 *
	 * @param cattach 资产模型属性数据类型
	 */
	public void setCattach(String cattach) {
		this.cattach = cattach;
	}

	/**
	 * 资产模型属性必填项取得
	 * @return 资产模型属性必填项
	 */
	public String getCrequired() {
		return crequired;
	}

	/**
	 * 资产模型属性必填项设定
	 *
	 * @param crequired 资产模型属性必填项
	 */
	public void setCrequired(String crequired) {
		this.crequired = crequired;
	}
	
}
