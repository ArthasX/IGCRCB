package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.user.model.UserRoleInfo;

/**
 * <p>
 * 用户角色授权信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="UserRoleVW")
public class UserRoleVW implements Serializable, Cloneable, UserRoleInfo {

	/** 用户角色授权ID */
	@Id
	protected Integer urid;
	
	/** 用户ID */
	protected String userid;
	
	/** 用户姓名 */
	protected String username;

	/** 用户角色ID */
	protected Integer roleid;

	/** 用户角色名称 */
	protected String rolename;
	
	/** 用户角色说明 */
	protected String roledesc;
	
	/** 用户角色类型 */
	protected String roletype;
	
	/** 用户角色机构管理范围 */
	protected String roledomain;
	
	/** 用户角色资产管理范围 */
	protected String assetdomain;
	
	/** 用户是否角色负责人标识 */
	protected String rolemanager;
	
	/** 机构syscoding */
	protected String orgid;
	
	/** 机构名称*/
	protected String orgname;
	
	/** 用户是否值班人标识 */
	protected String dutyflag;
	
	/** 用户工号 */
	protected String userinfo;
	
	/** 用户手机 */
	protected String usermobile;
	
	/** 用户邮箱 */
	protected String useremail;

	/**
	 * 用户角色授权ID取得
	 * @return 用户角色授权ID
	 */
	public Integer getUrid() {
		return urid;
	}

	/**
	 * 用户角色授权ID设定
	 *
	 * @param urid 用户角色授权ID
	 */
	public void setUrid(Integer urid) {
		this.urid = urid;
	}

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
	 *
	 * @return username 用户姓名
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
	 * 机构syscoding取得
	 *
	 * @return orgid 机构syscoding
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构syscoding设定
	 *
	 * @param orgid 机构syscoding
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 *
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 *
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * 用户角色说明取得
	 * @return 用户角色说明
	 */
	public String getRoledesc() {
		return roledesc;
	}

	/**
	 * 用户角色说明设定
	 *
	 * @param roledesc 用户角色说明
	 */
	public void setRoledesc(String roledesc) {
		this.roledesc = roledesc;
	}

	/**
	 * 用户角色类型取得
	 * @return 用户角色类型
	 */
	public String getRoletype() {
		return roletype;
	}

	/**
	 * 用户角色类型设定
	 *
	 * @param roletype 用户角色类型
	 */
	public void setRoletype(String roletype) {
		this.roletype = roletype;
	}

	/**
	 * 用户角色机构管理范围取得
	 * @return 用户角色机构管理范围
	 */
	public String getRoledomain() {
		return roledomain;
	}

	/**
	 * 用户角色机构管理范围设定
	 *
	 * @param roledomain 用户角色机构管理范围
	 */
	public void setRoledomain(String roledomain) {
		this.roledomain = roledomain;
	}

	/**
	 * 用户角色资产管理范围取得
	 * @return 用户角色资产管理范围
	 */
	public String getAssetdomain() {
		return assetdomain;
	}

	/**
	 * 用户角色资产管理范围设定
	 *
	 * @param assetdomain 用户角色资产管理范围
	 */
	public void setAssetdomain(String assetdomain) {
		this.assetdomain = assetdomain;
	}

	/**
	 * 用户是否角色负责人标识取得
	 * @return 用户是否角色负责人标识
	 */
	public String getRolemanager() {
		return rolemanager;
	}

	/**
	 * 用户是否角色负责人标识设定
	 *
	 * @param rolemanager 用户是否角色负责人标识
	 */
	public void setRolemanager(String rolemanager) {
		this.rolemanager = rolemanager;
	}

	/**
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return urid;
	}

	/**
	 * 用户是否值班人标识取得
	 * @return 用户是否值班人标识
	 */
	public String getDutyflag() {
		return dutyflag;
	}

	/**
	 * 用户是否值班人标识设定
	 *
	 * @param rolemanager 用户是否值班人标识
	 */
	public void setDutyflag(String dutyflag) {
		this.dutyflag = dutyflag;
	}
	
	/**
	 * 用户工号取得
	 * @return userinfo 用户工号
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * 用户工号设定
	 * @param userinfo 用户工号
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * 用户手机取得
	 * @return usermobile 用户手机
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * 用户手机设定
	 * @param usermobile 用户手机
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * 用户邮箱取得
	 * @return useremail 用户邮箱
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * 用户邮箱设定
	 * @param useremail 用户邮箱
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

}
