/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.asset.model.CompareTemplateInfo;
import com.deliverik.framework.base.BaseEntity;

/**
  * 概述: compareTemplate实体
  * 功能描述: compareTemplate实体
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareTemplate")
public class CompareTemplateTB extends BaseEntity implements Serializable,
		Cloneable, CompareTemplateInfo {

	/** 主键 */
	@Id
	@TableGenerator(
		name="COMPARETEMPLATE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="COMPARETEMPLATE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="COMPARETEMPLATE_TABLE_GENERATOR")
	protected Integer ctpid;

	/** 类别ID */
	protected String ctcategory;

	/** 类型 */
	protected String cttype;

	/** 横向宽度 */
	protected String ctxwidth;

	/** 纵向宽度 */
	protected String ctywidth;

	/** 值 */
	protected String ctvalue;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCtpid() {
		return ctpid;
	}

	/**
	 * 主键设定
	 *
	 * @param ctid 主键
	 */
	public void setCtpid(Integer ctpid) {
		this.ctpid = ctpid;
	}

	/**
	 * 类别ID取得
	 *
	 * @return 类别ID
	 */
	public String getCtcategory() {
		return ctcategory;
	}

	/**
	 * 类别ID设定
	 *
	 * @param ctcategory 类别ID
	 */
	public void setCtcategory(String ctcategory) {
		this.ctcategory = ctcategory;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getCttype() {
		return cttype;
	}

	/**
	 * 类型设定
	 *
	 * @param cttype 类型
	 */
	public void setCttype(String cttype) {
		this.cttype = cttype;
	}

	/**
	 * 横向宽度取得
	 *
	 * @return 横向宽度
	 */
	public String getCtxwidth() {
		return ctxwidth;
	}

	/**
	 * 横向宽度设定
	 *
	 * @param ctxwidth 横向宽度
	 */
	public void setCtxwidth(String ctxwidth) {
		this.ctxwidth = ctxwidth;
	}

	/**
	 * 纵向宽度取得
	 *
	 * @return 纵向宽度
	 */
	public String getCtywidth() {
		return ctywidth;
	}

	/**
	 * 纵向宽度设定
	 *
	 * @param ctywidth 纵向宽度
	 */
	public void setCtywidth(String ctywidth) {
		this.ctywidth = ctywidth;
	}

	/**
	 * 值取得
	 *
	 * @return 值
	 */
	public String getCtvalue() {
		return ctvalue;
	}

	/**
	 * 值设定
	 *
	 * @param ctvalue 值
	 */
	public void setCtvalue(String ctvalue) {
		this.ctvalue = ctvalue;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ctpid;
	}

}