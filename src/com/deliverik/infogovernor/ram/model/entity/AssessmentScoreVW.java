/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ram.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.ram.model.AssessmentScoreVWInfo;

/**
  * 概述: 评分历史查询实体
  * 功能描述: 评分历史查询实体
  * 创建记录: 2013/10/10
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="AssessmentScoreVW")
public class AssessmentScoreVW extends BaseEntity implements Serializable,
		Cloneable, AssessmentScoreVWInfo {

	/** 主键 */
	@Id
	protected Integer ppiid;

	/** 公有表单id */
	protected Integer piid;

	/** 流程id */
	protected Integer prid;

	/** 表单名 */
	protected String pivarname;

	/** 表单内容 */
	protected String pivarlabel;

	/** 表单类型 */
	protected String pivartype;

	/** 表单id */
	protected String pidid;

	/** 角色id */
	protected String roleid;

	/** 用户id */
	protected String userid;

	/** 私有表单值 */
	protected String ppivalue;

	/** 机构码 */
	protected String orgid;

	/** 用户名 */
	protected String username;
	
	/** 私有表单内容  */
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
	 * @param ppiid 主键
	 */
	public void setPpiid(Integer ppiid) {
		this.ppiid = ppiid;
	}

	/**
	 * 公有表单id取得
	 *
	 * @return 公有表单id
	 */
	public Integer getPiid() {
		return piid;
	}

	/**
	 * 公有表单id设定
	 *
	 * @param piid 公有表单id
	 */
	public void setPiid(Integer piid) {
		this.piid = piid;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 表单名取得
	 *
	 * @return 表单名
	 */
	public String getPivarname() {
		return pivarname;
	}

	/**
	 * 表单名设定
	 *
	 * @param pivarname 表单名
	 */
	public void setPivarname(String pivarname) {
		this.pivarname = pivarname;
	}

	/**
	 * 表单内容取得
	 *
	 * @return 表单内容
	 */
	public String getPivarlabel() {
		return pivarlabel;
	}

	/**
	 * 表单内容设定
	 *
	 * @param pivarlabel 表单内容
	 */
	public void setPivarlabel(String pivarlabel) {
		this.pivarlabel = pivarlabel;
	}

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getPivartype() {
		return pivartype;
	}

	/**
	 * 表单类型设定
	 *
	 * @param pivartype 表单类型
	 */
	public void setPivartype(String pivartype) {
		this.pivartype = pivartype;
	}

	/**
	 * 表单id取得
	 *
	 * @return 表单id
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单id设定
	 *
	 * @param pidid 表单id
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 角色id取得
	 *
	 * @return 角色id
	 */
	public String getRoleid() {
		return roleid;
	}

	/**
	 * 角色id设定
	 *
	 * @param roleid 角色id
	 */
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户id设定
	 *
	 * @param userid 用户id
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 私有表单值取得
	 *
	 * @return 私有表单值
	 */
	public String getPpivalue() {
		return ppivalue;
	}

	/**
	 * 私有表单值设定
	 *
	 * @param ppivalue 私有表单值
	 */
	public void setPpivalue(String ppivalue) {
		this.ppivalue = ppivalue;
	}

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构码设定
	 *
	 * @param orgid 机构码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 用户名取得
	 *
	 * @return 用户名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户名设定
	 *
	 * @param username 用户名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * ppicommect取得
	 */
	public String getPpicommect() {
		return ppicommect;
	}

	/**
	 * ppicommect设定
	 */
	public void setPpicommect(String ppicommect) {
		this.ppicommect = ppicommect;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return ppiid;
	}

}