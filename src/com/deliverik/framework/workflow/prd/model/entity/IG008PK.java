/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 人员表单角色限定实体主键
  * 功能描述: 人员表单角色限定实体主键
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG008PK extends BasePK implements Serializable {

	/** 表单定义ID */
	protected String pidid;

	/** 角色ID */
	protected Integer roleid;

	/**
	 * 构造函数
	 */
	public IG008PK() {

	}

	/**
	 * 构造函数
	 */
	public IG008PK(String pidid, Integer roleid) {
		super();
		this.pidid = pidid;
		this.roleid = roleid;
	}

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * 表单定义ID设定
	 *
	 * @param pidid 表单定义ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
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