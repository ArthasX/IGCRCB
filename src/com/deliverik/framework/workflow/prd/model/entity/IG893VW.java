/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prd.model.IG893Info;


/**
 * 流程参与者变量权限视图实体
 * 
 */
@SuppressWarnings("serial")
@Entity
public class IG893VW implements Serializable, Cloneable,
		IG893Info {
	
	/** 流程变量ID */
	@Id
	protected String pidid;
	
	/** 流程状态的ID */
	protected String psdid;
	
	/** 流程参与者角色ID */
	protected Integer roleid;

	/** 流程变量名称 */
	protected String pidname;
	
	/** 流程变量显示名称 */
	protected String pidlabel;
	
	/** 流程变量描述 */
	protected String piddesc;
	
	/** 流程变量类型 */
	protected String pidtype;

	/** 流程变量权限 */
	protected String pidaccess;
	
	protected String pidrequired;

	/**
	 * 流程状态的ID取得
	 * @return 流程状态的ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态的ID设定
	 * @param psdid 流程状态的ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}


	/**
	 * 流程参与者角色ID取得
	 * @return 流程参与者角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程参与者角色ID设定
	 * @param roleid 流程参与者角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return pidid;
	}

	/**
	 * 流程变量ID取得
	 * @return 流程变量ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 流程变量ID设定
	 * @param pidid 流程变量ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * 流程变量名称取得
	 * @return 流程变量名称
	 */
	public String getPidname() {
		return pidname;
	}

	/**
	 * 流程变量名称设定
	 * @param pidname 流程变量名称
	 */
	public void setPidname(String pidname) {
		this.pidname = pidname;
	}

	/**
	 * 流程变量显示名称取得
	 * @return 流程变量显示名称
	 */
	public String getPidlabel() {
		return pidlabel;
	}

	/**
	 * 流程变量显示名称设定
	 * @param pidlabel 流程变量显示名称
	 */
	public void setPidlabel(String pidlabel) {
		this.pidlabel = pidlabel;
	}

	/**
	 * 流程变量描述取得
	 * @return 流程变量描述
	 */
	public String getPiddesc() {
		return piddesc;
	}

	/**
	 * 流程变量描述设定
	 * @param piddesc 流程变量描述
	 */
	public void setPiddesc(String piddesc) {
		this.piddesc = piddesc;
	}

	/**
	 * 流程变量类型取得
	 * @return 流程变量类型
	 */
	public String getPidtype() {
		return pidtype;
	}

	/**
	 * 流程变量类型设定
	 * @param pidtype 流程变量类型
	 */
	public void setPidtype(String pidtype) {
		this.pidtype = pidtype;
	}

	/**
	 * 流程参与者变量权限取得
	 * @return 流程参与者变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流程参与者变量权限设定
	 * @param pidaccess 流程参与者变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	public String getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

}
