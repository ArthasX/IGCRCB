/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prr.model.IG505Info;

/**
  * 概述: 流程表单值表实体
  * 功能描述: 流程表单值表实体
  * 创建记录: 2013/08/28
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG505")
public class IG505TB extends BaseEntity implements Serializable,
		Cloneable, IG505Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG505_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG505_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG505_TABLE_GENERATOR")
	protected Integer piprrid;

	/** 流程主键 */
	protected Integer prid;
	
	protected Integer piprid;

	/** 流程类型 */
	protected String piprtype;

	/** 流程名称 */
	protected String piprtitle;

	/**
	 * 主键取得
	 * @return piprrid 主键
	 */
	public Integer getPiprrid() {
		return piprrid;
	}

	/**
	 * 主键设定
	 * @param piprrid 主键
	 */
	public void setPiprrid(Integer piprrid) {
		this.piprrid = piprrid;
	}

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程主键设定
	 * @param prid 流程主键
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * piprid取得
	 * @return piprid piprid
	 */
	public Integer getPiprid() {
		return piprid;
	}

	/**
	 * piprid设定
	 * @param piprid piprid
	 */
	public void setPiprid(Integer piprid) {
		this.piprid = piprid;
	}

	/**
	 * 流程类型取得
	 * @return piprtype 流程类型
	 */
	public String getPiprtype() {
		return piprtype;
	}

	/**
	 * 流程类型设定
	 * @param piprtype 流程类型
	 */
	public void setPiprtype(String piprtype) {
		this.piprtype = piprtype;
	}

	/**
	 * 流程名称取得
	 * @return piprtitle 流程名称
	 */
	public String getPiprtitle() {
		return piprtitle;
	}

	/**
	 * 流程名称设定
	 * @param piprtitle 流程名称
	 */
	public void setPiprtitle(String piprtitle) {
		this.piprtitle = piprtitle;
	}

	/**
	 * 主键取得
	 * @return 主键
	 */
	public Serializable getPK() {
		return this.piprrid;
	}

}