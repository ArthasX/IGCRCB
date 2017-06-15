/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG213Info;

/**
 * 流程角色类型定义
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="IG213")
public class IG213TB extends BaseEntity implements Serializable, Cloneable, IG213Info {
	
	/** 流程状态ID */
	@Id
	protected String prtdid;
	
	/**
	 * 流程名称ID
	 */
	protected String pdid;

	/**
	 * 流程状态名称
	 */
	protected String roletype;

	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return prtdid;
	}
	
	/**
	 * 流程角色类型定义ID取得
	 * @return 流程角色类型定义ID
	 */
	public String getPrtdid() {
		return prtdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPrtdid(String prtdid) {
		this.prtdid = prtdid;
	}

	/**
	 * 流程名称ID取得
	 * @return 流程名称ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程名称ID设定
	 * @param pdid 流程名称ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程角色类型取得
	 * @return 流程角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 流程角色类型设定
	 * @param psdname 流程角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}
	
	
}
