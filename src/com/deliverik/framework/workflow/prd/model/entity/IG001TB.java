/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG001Info;

/**
  * 概述: OA角色配置表实体
  * 功能描述: OA角色配置表实体
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG001")
public class IG001TB extends BaseEntity implements Serializable,
		Cloneable, IG001Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG001_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG001_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG001_TABLE_GENERATOR")
	protected Integer proid;

	/** 类型 */
	protected String protype;

	/** 角色ID */
	protected Integer proroleid;

	/** 角色名称 */
	protected String prorolename;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getProid() {
		return proid;
	}

	/**
	 * 主键设定
	 *
	 * @param proid 主键
	 */
	public void setProid(Integer proid) {
		this.proid = proid;
	}

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getProtype() {
		return protype;
	}

	/**
	 * 类型设定
	 *
	 * @param protype 类型
	 */
	public void setProtype(String protype) {
		this.protype = protype;
	}

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getProroleid() {
		return proroleid;
	}

	/**
	 * 角色ID设定
	 *
	 * @param proroleid 角色ID
	 */
	public void setProroleid(Integer proroleid) {
		this.proroleid = proroleid;
	}

	/**
	 * 角色名称取得
	 *
	 * @return 角色名称
	 */
	public String getProrolename() {
		return prorolename;
	}

	/**
	 * 角色名称设定
	 *
	 * @param prorolename 角色名称
	 */
	public void setProrolename(String prorolename) {
		this.prorolename = prorolename;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return proid;
	}

}