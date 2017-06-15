/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * 概述: 流程执行人信息实体主键
 * 功能描述: 流程执行人信息实体主键
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IG602PK extends BasePK implements Serializable {

	/** 用户ID */
	protected String userid;

	/** 用户角色ID */
	protected Integer roleid;
	
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid 用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 用户角色ID设定
	 *
	 * @param roleid 用户角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public IG602PK(){}
	
	public IG602PK(String userid, Integer roleid) {
		super();
		this.userid = userid;
		this.roleid = roleid;
	}
}
