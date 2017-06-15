/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG108Info;

/**
  * 概述: 自定义流程表单查询条件定义表实体
  * 功能描述: 自定义流程表单查询条件定义表实体
  * 创建记录: 2013/03/13
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG108")
public class IG108TB extends BaseEntity implements Serializable, Cloneable, IG108Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG108_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG108_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG108_TABLE_GENERATOR")
	protected Integer pqid;

	/** 流程类型主键 */
	protected String pdid;

	/** 表单定义主键 */
	protected String pidid;
	
	@ManyToOne
	@JoinColumn(name="pidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	/** 表单定义信息 */
	protected IG007TB pidTB;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPqid() {
		return pqid;
	}

	/**
	 * 主键设定
	 *
	 * @param pqid 主键
	 */
	public void setPqid(Integer pqid) {
		this.pqid = pqid;
	}

	/**
	 * 流程类型主键取得
	 *
	 * @return 流程类型主键
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程类型主键设定
	 *
	 * @param pdid 流程类型主键
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 表单定义主键取得
	 *
	 * @return 表单定义主键
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义主键设定
	 *
	 * @param pidid 表单定义主键
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 表单定义信息取得
	 * @return 表单定义信息
	 */
	public IG007TB getPidTB() {
		return pidTB;
	}

	/**
	 * 表单定义信息设定
	 * @param pidTB 表单定义信息
	 */
	public void setPidTB(IG007TB pidTB) {
		this.pidTB = pidTB;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pqid;
	}

}