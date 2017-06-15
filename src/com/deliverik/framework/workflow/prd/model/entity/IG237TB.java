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
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.IG237Info;

/**
  * 概述: 流程策略通知人实体
  * 功能描述: 流程策略通知人实体
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@IdClass(IG237PK.class)
@Table(name="IG237")
public class IG237TB extends BaseEntity implements Serializable,
		Cloneable, IG237Info {

	/** 状态ID */
	@Id
	protected String psdid;

	/** 是否确认 */
	@Id
	protected String psdconfirm;

	/** 用户ID */
	@Id
	protected String userid;
	
	/** 表单值 */
	@Id
	protected String pivalue;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 用户信息 */
	@ManyToOne
	@JoinColumn(name="userid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;

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
	 * 是否确认取得
	 *
	 * @return 是否确认
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 是否确认设定
	 *
	 * @param psdconfirm 是否确认
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 表单值取得
	 * @return pivalue 表单值
	 */
	public String getPivalue() {
		return pivalue;
	}

	/**
	 * 表单值设定
	 * @param pivalue 表单值
	 */
	public void setPivalue(String pivalue) {
		this.pivalue = pivalue;
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
	 * 用户信息取得
	 * 
	 * @return 用户信息
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return new IG237PK(psdid, psdconfirm, userid, pivalue);
	}

}