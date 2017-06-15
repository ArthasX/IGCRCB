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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.workflow.prd.model.IG299Info;

/**
  * 概述: 状态可分派机构定义表实体
  * 功能描述: 状态可分派机构定义表实体
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="ig299")
public class IG299TB extends BaseEntity implements Serializable,
		Cloneable, IG299Info {

	/** 状态配置机构主键主键 */
	@Id
	protected String psodid;

	/** 状态节点ID */
	protected String psdid;

	/** 机构层次码 */
	protected String orgsyscoding;
	
	/** 机构名称 */
	protected String orgname;
	
	/** 机构 */
	@OneToOne
	@JoinColumn(name="orgsyscoding",referencedColumnName="orgsyscoding", updatable=false, insertable= false )
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB org;

	/**
	 * 状态配置机构主键主键取得
	 *
	 * @return 状态配置机构主键主键
	 */
	public String getPsodid() {
		return psodid;
	}

	/**
	 * 状态配置机构主键主键设定
	 *
	 * @param psodid 状态配置机构主键主键
	 */
	public void setPsodid(String psodid) {
		this.psodid = psodid;
	}

	/**
	 * 状态节点ID取得
	 *
	 * @return psdid 状态节点ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态节点ID设定
	 *
	 * @param psdid 状态节点ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 机构层次码取得
	 *
	 * @return orgsyscoding 机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 机构层次码设定
	 *
	 * @param orgsyscoding 机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 机构名称取得
	 *
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 机构取得
	 * @return 机构
	 */
	public OrganizationTB getOrg() {
		return org;
	}

	/**
	 * 机构设定
	 * @param org 机构
	 */
	public void setOrg(OrganizationTB org) {
		this.org = org;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return psodid;
	}

}