/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 流程查看角色配置表实体主键
  * 功能描述: 流程查看角色配置表实体主键
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG700PK extends BasePK implements Serializable {

	/** 流程定义ID */
	protected String pdid;

	/** 角色ID */
	protected Integer roleid;

	/**
	 * 构造函数
	 */
	public IG700PK() {

	}

	/**
	 * 构造函数
	 */
	public IG700PK(String pdid, Integer roleid) {
		super();
		this.pdid = pdid;
		this.roleid = roleid;
	}

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 *
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
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

}