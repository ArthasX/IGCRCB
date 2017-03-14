/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG701Info;

/**
  * 概述: 流程查看角色授权表单表实体
  * 功能描述: 流程查看角色授权表单表实体
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG701PK.class)
@Table(name="ig701")
public class IG701TB extends BaseEntity implements Serializable,
		Cloneable, IG701Info {

	/** 流程定义ID */
	@Id
	protected String pdid;

	/** 角色ID */
	@Id
	protected Integer roleid;

	/** 表单ID */
	@Id
	protected String pidid;
	
	/** 表单信息 */
	@ManyToOne
	@JoinColumn(name="pidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG007TB processInfoDef;

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 *
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 表单ID取得
	 *
	 * @return 表单ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单ID设定
	 *
	 * @param pidid 表单ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG701PK(pdid, roleid,pidid);
	}

	/**
	 * 表单信息取得
	 * @return 表单信息
	 */
	public IG007TB getProcessInfoDef() {
		return processInfoDef;
	}

	/**
	 * 表单信息设定
	 * @param processInfoDef表单信息
	 */
	public void setProcessInfoDef(IG007TB processInfoDef) {
		this.processInfoDef = processInfoDef;
	}

}