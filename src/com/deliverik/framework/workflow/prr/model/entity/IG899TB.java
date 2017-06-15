/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;
import com.deliverik.framework.user.model.entity.RoleTB;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;
import com.deliverik.framework.workflow.prr.model.IG899Info;

/**
  * 概述: 流程私有变量表实体
  * 功能描述: 流程私有变量表实体
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG899")
public class IG899TB extends BaseEntity implements Serializable,
		Cloneable, IG899Info {

	/** 主键 */
	@Id
	@TableGenerator(
		name="IG899_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="IG899_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IG899_TABLE_GENERATOR")
	protected Integer ppiid;

	/** 流程变量定义ID */
	protected String pidid;

	/** 流程变量值ID */
	protected Integer piid;

	/** 流程参与者的角色ID */
	protected Integer roleid;
	
	/** 流程参与者ID */
	protected String userid;

	/** 值 */
	protected String ppivalue;

	/** 附件索引 */
	protected String ppiattkey;
	
	/** 机构码 */
	protected String orgid;
	
	/** 备注 */
	protected String ppicommect;

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPpiid() {
		return ppiid;
	}

	/**
	 * 主键设定
	 *
	 * @param Ppiid 主键
	 */
	public void setPpiid(Integer ppiid) {
		this.ppiid = ppiid;
	}

	/**
	 * 流程变量定义ID取得
	 *
	 * @return 流程变量定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程变量定义ID设定
	 *
	 * @param Pidid 流程变量定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程变量值ID取得
	 *
	 * @return 流程变量值ID
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 流程变量值ID设定
	 *
	 * @param Piid 流程变量值ID
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * 流程参与者的角色ID取得
	 *
	 * @return 流程参与者的角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程参与者的角色ID设定
	 *
	 * @param roleid 流程参与者的角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 值取得
	 *
	 * @return 值
	 */
	public String getPpivalue() {
		return ppivalue;
	}

	/**
	 * 值设定
	 *
	 * @param Ppivalue 值
	 */
	public void setPpivalue(String ppivalue) {
		this.ppivalue = ppivalue;
	}

	/**
	 * 附件索引取得
	 *
	 * @return 附件索引
	 */
	public String getPpiattkey() {
		return ppiattkey;
	}

	/**
	 * 附件索引设定
	 *
	 * @param Ppiattkey 附件索引
	 */
	public void setPpiattkey(String ppiattkey) {
		this.ppiattkey = ppiattkey;
	}

	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 流程参与者ID设定
	 * 
	 * @param userid 流程参与者ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ppiid;
	}

	/** 用户信息实体 */
	@OneToOne
	@JoinColumn(name="userid", referencedColumnName="userid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected UserTB userTB;
	
	public UserTB getUserTB() {
		return userTB;
	}
	public void setUserTB(UserTB userTB) {
		this.userTB = userTB;
	}
	
	/** 角色实体 */
	@OneToOne
	@JoinColumn(name="roleid", referencedColumnName="roleid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected RoleTB roleTB;
	
	public RoleTB getRoleTB() {
		return roleTB;
	}
	public void setRoleTB(RoleTB roleTB) {
		this.roleTB = roleTB;
	}
	
	/**
	 * 流程状态前处理变量
	 */
	@ManyToOne
	@JoinColumn(name = "piid", referencedColumnName="pidgid", insertable=false, updatable=false)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG007TB processInfoDef;

	/**
	 * 机构码取得
	 * @return 机构码设定
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
	
	/** 机构信息 */
	@OneToOne
	@JoinColumn(name="orgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB org;

	/**
	 * 机构信息取得
	 * @return 机构信息
	 */
	public OrganizationTB getOrg() {
		return org;
	}

	/**
	 * 机构信息设定
	 * @param org 机构信息
	 */
	public void setOrg(OrganizationTB org) {
		this.org = org;
	}

	/**
	 * 备注取得
	 * @return ppicommect 备注
	 */
	public String getPpicommect() {
		return ppicommect;
	}

	/**
	 * 备注设定
	 * @param ppicommect 备注
	 */
	public void setPpicommect(String ppicommect) {
		this.ppicommect = ppicommect;
	}
}