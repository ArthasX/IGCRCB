/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.IG222Info;

/**
 * <p>概述:流程参与者定义实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG222")
public class IG222TB extends BaseEntity implements Serializable, Cloneable, IG222Info {
	
	/** 流程参与者ID */
	@Id
	protected String ppdid;
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;
	
	/**
	 * 流程参与者角色ID
	 */
	protected Integer roleid;
	
	/**
	 * 流程参与者ID
	 */
	protected String userid;
	
	/**
	 * 流程super参与者标识
	 */
	protected String ppdsuper;
	
	/** 机构码 */
	protected String orgid;
	

	
	/** 角色 */
	@OneToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid",  updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB role;
	
	/** 用户 */
	@OneToOne
	@JoinColumn(name="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB user;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="ppdid", referencedColumnName="ppdid", updatable=false, insertable= false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected List<IG132TB> ProcessParticipantButtonDefList;
	
	/** 机构 */
	@OneToOne
	@JoinColumn(name="orgid",referencedColumnName="orgsyscoding", updatable=false, insertable= false )
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB org;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return ppdid;
	}
	
	/**
	 * 功能：流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getPpdid() {
		return ppdid;
	}

	/**
	 * 功能：流程参与者ID设定
	 * @param ppdid 流程参与者ID
	 */
	public void setPpdid(String ppdid) {
		this.ppdid = ppdid;
	}

	/**
	 * 功能：流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 功能：流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 功能：流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 功能：流程参与者角色ID设定
	 * @param roleid 流程参与者角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	
	/**
	 * 功能：流程super参与者标识取得
	 * @return 流程super参与者标识
	 */
	public String getPpdsuper() {
		return ppdsuper;
	}

	/**
	 * 功能：流程super参与者标识设定
	 * @param ppdsuper 流程super参与者标识
	 */
	public void setPpdsuper(String ppdsuper) {
		this.ppdsuper = ppdsuper;
	}

	/**
	 * 功能：角色取得
	 * @return 角色
	 */
	public RoleTB getRole() {
		return role;
	}

	/**
	 * 功能：角色设定
	 * @param role 角色
	 */
	public void setRole(RoleTB role) {
		this.role = role;
	}

	/**
	 * 功能：流程参与者ID取得
	 * @return 流程参与者ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 功能：流程参与者ID设定
	 * @param userid 流程参与者ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 功能：用户取得
	 * @return 用户
	 */
	public UserTB getUser() {
		return user;
	}

	/**
	 * 功能：用户设定
	 * @param user 用户
	 */
	public void setUser(UserTB user) {
		this.user = user;
	}
	
	public List<IG132TB> getProcessParticipantButtonDefList() {
		return ProcessParticipantButtonDefList;
	}

	public void setProcessParticipantButtonDefList(
			List<IG132TB> processParticipantButtonDefList) {
		ProcessParticipantButtonDefList = processParticipantButtonDefList;
	}

	/**
	 * 机构码取得
	 * @return 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
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

}
