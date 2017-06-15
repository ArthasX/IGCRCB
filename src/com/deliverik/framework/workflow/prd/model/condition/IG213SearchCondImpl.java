/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

import java.io.Serializable;


/**
 * 流程状态检索条件实现
 *
 */
public class IG213SearchCondImpl implements IG213SearchCond {
	
	/** 流程状态ID */
	protected String prtdid;
	
	/** 流程名称ID */
	protected String pdid;

	/** 流程状态名称 */
	protected String roletype;
	
	/** 流程状态ID */
	protected String prtdid_like;

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

	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPrtdid_like() {
		return prtdid_like;
	}

	/**
	 * 流程状态ID设定
	 * 
	 * @param prtdid_like 流程状态ID
	 */
	public void setPrtdid_like(String prtdid_like) {
		this.prtdid_like = prtdid_like;
	}
	
}
