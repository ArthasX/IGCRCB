/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG699Info;
import com.deliverik.framework.workflow.prd.model.IG007Info;

/**
 * 流程缺省参与者变量权限
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG699")
public class IG699TB extends BaseEntity implements Serializable, Cloneable, IG699Info {
	
	/** 流程缺省参与者变量权限ID */
	@Id
	protected String pdvid;
	
	/** 流程变量ID */
	protected String pidid;
	
	/** 流程状态的ID */
	protected String psdid;
	
	/** 表单信息 */
	@ManyToOne
	@JoinColumn(name="pidid", referencedColumnName="pidid", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected IG007TB processInfoDef;
	
	/** 流程变量权限 */
	protected String pidaccess;
	
	/** 流程变量是否必填 */
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
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return pdvid;
	}

	/**
	 * 流程缺省参与者变量权限ID取得
	 * @return 流程缺省参与者变量权限ID
	 */
	public String getPdvid() {
		return pdvid;
	}

	/**
	 * 流程缺省参与者变量权限ID设定
	 * @param pdvid 流程缺省参与者变量权限ID
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
	 * 表单信息取得
	 * @return 表单信息
	 */
	public IG007Info getProcessInfoDef() {
		return processInfoDef;
	}
	
	/**
	 * 流程缺省参与者变量权限取得
	 * @return 流程缺省参与者变量权限
	 */
	public String getPidaccess() {
		return pidaccess;
	}

	/**
	 * 流程缺省参与者变量权限设定
	 * @param pidaccess 流程缺省参与者变量权限
	 */
	public void setPidaccess(String pidaccess) {
		this.pidaccess = pidaccess;
	}

	/**
	 * 流程变量是否必填取得
	 *
	 * @return 流程变量是否必填
	 */
	public String getPidrequired() {
		return pidrequired;
	}

	/**
	 * 流程变量是否必填设定
	 *
	 * @param pidrequired 流程变量是否必填
	 */
	public void setPidrequired(String pidrequired) {
		this.pidrequired = pidrequired;
	}

}
