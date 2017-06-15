/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import com.deliverik.framework.workflow.prr.model.IG602Info;

/**
 * 概述: 流程执行人信息实体
 * 功能描述: 流程执行人信息实体
 * 创建记录: 2012/04/11
 * 修改记录: 
 */
@SuppressWarnings("serial")
@Entity
@IdClass(IG602PK.class)
public class IG602VW implements Serializable,
	Cloneable, IG602Info {
	
	/** 用户ID */
	@Id
	protected String userid;
	
	/** 用户姓名 */
	protected String username;

	/** 用户角色ID */
	@Id
	protected Integer roleid;

	/** 用户角色名称 */
	protected String rolename;
	
	/** 用户机构层次码 */
	protected String orgsyscoding;

	/** 用户机构名称 */
	protected String orgname;
	
	/** 处理完成标识（0未指定，1未处理，2已处理） */
	protected String doneFlag;

	/** 用户手机号 */
	protected String usermobile;
	
	/** 用户工号 */
	protected String userinfo;
	
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
	 * 用户姓名取得
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户姓名设定
	 *
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
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

	/**
	 * 用户角色名称取得
	 * @return 用户角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 用户角色名称设定
	 *
	 * @param rolename 用户角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	
	/**
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	/**
	 * 用户机构层次码设定
	 *
	 * @param orgname 用户机构层次码
	 */
	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 用户机构名称取得
	 * @return 用户机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 用户机构名称设定
	 *
	 * @param orgname 用户机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 处理完成标识取得
	 * 
	 * @return 处理完成标识
	 */
	public String getDoneFlag() {
		return doneFlag;
	}

	/**
	 * 处理完成标识设定
	 * 
	 * @param doneFlag 处理完成标识
	 */
	public void setDoneFlag(String doneFlag) {
		this.doneFlag = doneFlag;
	}

	/**
	 * 用户手机号取得
	 * 
	 * @return 用户手机号
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * 用户手机号设定
	 * 
	 * @param usermobile 用户手机号
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * 用户工号取得
	 * 
	 * @return 用户工号
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * 用户工号设定
	 * 
	 * @param userinfo 用户工号
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	
}
