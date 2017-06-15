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
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;

/**
  * 概述: SOC0151VW实体
  * 功能描述: SOC0151VW实体
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(SOC0151VWPK.class)
@Table(name="SOC0151VW")
public class SOC0151VW extends BaseEntity implements Serializable,
		Cloneable, SOC0151VWInfo {

	/** 主键 */
	@Id
	protected Integer id;

	/** 无意义主键 */
	@Id
	protected Integer ccdid;

	/** 资产模型属性取值范围标识 */
	protected String ccdcategory;

	/** 资产模型属性取值范围标识名称 */
	protected String ccdlabel;

	/** 资产模型属性取值范围值 */
	protected String ccdvalue;

	/** 资产模型属性取值范围状态 */
	protected String ccdstatus;

	/** 资产模型属性取值范围所属应用 */
	protected String ccdtype;

	/** 资产模型属性取值范围预留字段 */
	protected String ccdinfo;

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
	 * 无意义主键取得
	 *
	 * @return 无意义主键
	 */
	public Integer getCcdid() {
		return ccdid;
	}

	/**
	 * 无意义主键设定
	 *
	 * @param ccdid 无意义主键
	 */
	public void setCcdid(Integer ccdid) {
		this.ccdid = ccdid;
	}

	/**
	 * 资产模型属性取值范围标识取得
	 *
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
	 *
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
	 *
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
	 *
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
	 *
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
	 *
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

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new SOC0151VWPK(id, ccdid);
	}

}