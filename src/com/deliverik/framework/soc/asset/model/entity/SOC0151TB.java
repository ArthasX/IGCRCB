/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset.model.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.soc.asset.model.SOC0151Info;



/**
 * <p>
 * 资产模型属性取值范围实体
 * </p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="SOC0151")
public class SOC0151TB extends BaseEntity implements Serializable, Cloneable, SOC0151Info {

	/**
	 * 资产模型属性取值范围ID
	 */
	@Id
	@TableGenerator(
		    name="CONFIGURATIONCODEDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="CONFIGURATIONCODEDETAIL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="CONFIGURATIONCODEDETAIL_TABLE_GENERATOR")
	protected Integer ccdid;

	/**
	 * 资产模型属性取值范围标识
	 */
	public String ccdcategory;
	
	/**
	 * 资产模型属性取值范围标识名称
	 */
	public String ccdlabel;

	/**
	 * 资产模型属性取值范围值
	 */
	public String ccdvalue;

	/**
	 * 资产模型属性取值范围状态
	 */
	public String ccdstatus;

	/**
	 * 资产模型属性取值范围所属应用
	 */
	public String ccdtype;

	/**
	 * 资产模型属性取值范围预留字段
	 */
	public String ccdinfo;
	
	/**
	 * 主键
	 * @return 
	 */
	public Serializable getPK() {
		return ccdid;
	}

	/**
	 * 资产模型属性取值范围ID取得
	 * @return 资产模型属性取值范围ID
	 */
	public Integer getCcdid() {
		return ccdid;
	}
	
	/**
	 * 资产模型属性取值范围ID设定
	 *
	 * @param ccdid 资产模型属性取值范围ID
	 */
	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}
	
	/**
	 * 资产模型属性取值范围标识取得
	 * @return 资产模型属性取值范围标识
	 */
	public String getCcdcategory() {
		return ccdcategory;
	}

	/**
	 * 资产模型属性取值范围标识设定
	 *
	 * @param ccdcategory 资产模型属性取值范围标识
	 */
	public void setCcdcategory(String ccdcategory) {
		this.ccdcategory = ccdcategory;
	}

	/**
	 * 资产模型属性取值范围标识名称取得
	 * @return 资产模型属性取值范围标识名称
	 */
	public String getCcdlabel() {
		return ccdlabel;
	}

	/**
	 * 资产模型属性取值范围标识名称设定
	 *
	 * @param ccdlabel 资产模型属性取值范围标识名称
	 */
	public void setCcdlabel(String ccdlabel) {
		this.ccdlabel = ccdlabel;
	}

	/**
	 * 资产模型属性取值范围值取得
	 * @return 资产模型属性取值范围值
	 */
	public String getCcdvalue() {
		return ccdvalue;
	}

	/**
	 * 资产模型属性取值范围值设定
	 *
	 * @param ccdvalue 资产模型属性取值范围值
	 */
	public void setCcdvalue(String ccdvalue) {
		this.ccdvalue = ccdvalue;
	}

	/**
	 * 资产模型属性取值范围状态取得
	 * @return 资产模型属性取值范围状态
	 */
	public String getCcdstatus() {
		return ccdstatus;
	}

	/**
	 * 资产模型属性取值范围状态设定
	 *
	 * @param ccdstatus 资产模型属性取值范围状态
	 */
	public void setCcdstatus(String ccdstatus) {
		this.ccdstatus = ccdstatus;
	}

	/**
	 * 资产模型属性取值范围所属应用取得
	 * @return 资产模型属性取值范围所属应用
	 */
	public String getCcdtype() {
		return ccdtype;
	}

	/**
	 * 资产模型属性取值范围所属应用设定
	 *
	 * @param ccdtype 资产模型属性取值范围所属应用
	 */
	public void setCcdtype(String ccdtype) {
		this.ccdtype = ccdtype;
	}

	/**
	 * 资产模型属性取值范围预留字段取得
	 * @return 资产模型属性取值范围预留字段
	 */
	public String getCcdinfo() {
		return ccdinfo;
	}

	/**
	 * 资产模型属性取值范围预留字段设定
	 *
	 * @param ccdinfo 资产模型属性取值范围预留字段
	 */
	public void setCcdinfo(String ccdinfo) {
		this.ccdinfo = ccdinfo;
	}
	
	public SOC0151TB clone(SOC0151Info ccd){
		this.ccdid = ccd.getCcdid();
		this.ccdcategory = ccd.getCcdcategory();
		this.ccdlabel = ccd.getCcdlabel();
		this.ccdvalue = ccd.getCcdvalue();
		this.ccdstatus = ccd.getCcdstatus();
		this.ccdtype = ccd.getCcdtype();
		this.ccdinfo = ccd.getCcdinfo();
		return this;
	}

}
