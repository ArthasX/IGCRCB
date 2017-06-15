/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.Role;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.workflow.prd.model.IG298Info;

/**
  * 概述: 流程状态可分派角色定义信息实体
  * 功能描述: 流程状态可分派角色定义信息实体
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG298")
public class IG298TB extends BaseEntity implements Serializable,
		Cloneable, IG298Info {

	/** 主键 */
	@Id
	protected String psrdid;

	/** 状态ID */
	protected String psdid;

	/** 角色ID */
	protected Integer roleid;
	
	/** 角色信息 */
	@ManyToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB role;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPsrdid() {
		return psrdid;
	}

	/**
	 * 主键设定
	 *
	 * @param psrdid 主键
	 */
	public void setPsrdid(String psrdid) {
		this.psrdid = psrdid;
	}

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 *
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
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
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return psrdid;
	}

	/**
	 * 角色信息取得
	 * 
	 * @return 角色信息
	 */
	public Role getRole() {
		return role;
	}

}