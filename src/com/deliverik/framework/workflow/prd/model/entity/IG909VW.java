/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prd.model.IG909Info;

/**
 * 流程缺省变量权限
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(IG909PK.class)
public class IG909VW implements Serializable, Cloneable, IG909Info {
	
	/** 流程缺省变量权限ID */
	@Id
	protected String pdvid;
	
	/** 流程变量ID */
	protected String pidid;
	
	/** 流程变量显示名称 */
	protected String pidlabel;
	
	/** 流程变量权限 */
	protected String pidaccess;
	
	/** 表单信息的模式 */
	protected String pidmode;
	
	/** 类型（0：已设定权限表单，1：未设定权限表单） */
	@Id
	protected String type;
	
	protected String pidrequired;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return new IG100PK(pdvid, type);
	}

	/**
	 * 流程缺省变量权限ID取得
	 * @return 流程缺省变量权限ID
	 */
	public String getPdvid() {
		return pdvid;
	}

	/**
	 * 流程缺省变量权限ID设定
	 * @param pdvid 流程缺省变量权限ID
	 */
	public void setPdvid(String pdvid) {
		this.pdvid = pdvid;
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
	 * 流程缺省变量权限取得
	 * @return 流程缺省变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流程缺省变量权限设定
	 * @param pidaccess 流程缺省变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}
	
	/**
	 * 表单信息的模式取得
	 *
	 * @return 表单信息的模式
	 */
	public String getPidmode() {
		return pidmode;
	}

	/**
	 * 表单信息的模式设定
	 *
	 * @param pidmode 表单信息的模式
	 */
	public void setPidmode(String pidmode) {
		this.pidmode = pidmode;
	}

	/**
	 * 类型取得
	 * 
	 * @return 类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 类型设定
	 * 
	 * @param type 类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	public String getPidrequired() {
		return pidrequired;
	}

	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}
	
}
