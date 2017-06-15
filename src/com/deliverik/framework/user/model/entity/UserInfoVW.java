package com.deliverik.framework.user.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.deliverik.framework.user.model.UserInfo;


/**
 * <p>
 * 用户信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@IdClass(UserInfoVWPK.class)
@Table(name="UserInfoVW")
public class UserInfoVW implements Serializable, Cloneable, UserInfo {

	/** 用户ID */
	@Id
	protected String userida;
	
	/** 用户姓名 */
	protected String username;

	/** 用户口令 */
	protected String password;

	/** 用户说明 */
	protected String userdesc;

	/** 用户信息 */
	protected String userinfo;

	/** 用户类型 */
	protected String usertype;

	/** 用户状态 */
	protected String userstatus;

	/** 用户电话 */
	protected String userphone;

	/** 用户手机 */
	protected String usermobile;

	/** 用户邮箱 */
	protected String useremail;
	
	/** 用户角色ID */
	@Id
	protected Integer roleida;

	/** 用户角色名称 */
	protected String rolename;

	/** 用户角色说明 */
	protected String roledesc;

	/** 用户角色信息 */
	protected String roleinfo;

	/** 用户角色类型 */
	protected String roletype;

	/** 用户机构层次码 */
	protected String orgida;

	/** 用户机构名称 */
	protected String orgname;

	/** 用户机构说明 */
	protected String orgdesc;

	/** 用户机构信息 */
	protected String orginfo;

	/** 用户机构类型 */
	protected String orgtype;

	/** 用户机构的上级机构层次码 */
	protected String orgpar;

	/** 用户机构的上级机构名称 */
	protected String orgparname;

	/** 用户机构地址 */
	protected String orgaddr;

	/** 用户机构电话 */
	protected String orgphone;

	/** 用户机构传真 */
	protected String orgfax;

	/** 用户机构联系人 */
	protected String orgcontact;

	/** 用户机构状态 */
	protected String orgstatus;

	/** 用户角色资产管理范围 */
	protected String rolemanager;
	
	/** 逻辑删除标志位 */
	protected String deleteflag;
	
	/** 用户是否值班人标识 */
	protected String dutyflag;
	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserida() {
		return userida;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userida 用户ID
	 */
	public void setUserida(String userida) {
		this.userida = userida;
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
	 * 用户口令取得
	 * @return 用户口令
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 用户口令设定
	 *
	 * @param password 用户口令
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 用户说明取得
	 * @return 用户说明
	 */
	public String getUserdesc() {
		return userdesc;
	}

	/**
	 * 用户说明设定
	 *
	 * @param userdesc 用户说明
	 */
	public void setUserdesc(String userdesc) {
		this.userdesc = userdesc;
	}

	/**
	 * 用户信息取得
	 * @return 用户信息
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * 用户信息设定
	 *
	 * @param userinfo 用户信息
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * 用户类型取得
	 * @return 用户类型
	 */
	public String getUsertype() {
		return usertype;
	}

	/**
	 * 用户类型设定
	 *
	 * @param usertype 用户类型
	 */
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}

	/**
	 * 用户状态取得
	 * @return 用户状态
	 */
	public String getUserstatus() {
		return userstatus;
	}

	/**
	 * 用户状态设定
	 *
	 * @param userstatus 用户状态
	 */
	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

	/**
	 * 用户电话取得
	 * @return 用户电话
	 */
	public String getUserphone() {
		return userphone;
	}

	/**
	 * 用户电话设定
	 *
	 * @param userphone 用户电话
	 */
	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	/**
	 * 用户手机取得
	 * @return 用户手机
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * 用户手机设定
	 *
	 * @param usermobile 用户手机
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	/**
	 * 用户邮箱取得
	 * @return 用户邮箱
	 */
	public String getUseremail() {
		return useremail;
	}

	/**
	 * 用户邮箱设定
	 *
	 * @param useremail 用户邮箱
	 */
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	/**
	 * 用户角色ID取得
	 * @return 用户角色ID
	 */
	public Integer getRoleida() {
		return roleida;
	}

	/**
	 * 用户角色ID设定
	 *
	 * @param roleida 用户角色ID
	 */
	public void setRoleida(Integer roleida) {
		this.roleida = roleida;
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
	 * 用户角色信息取得
	 * @return 用户角色信息
	 */
	public String getRoleinfo() {
		return roleinfo;
	}

	/**
	 * 用户角色信息设定
	 *
	 * @param roleinfo 用户角色信息
	 */
	public void setRoleinfo(String roleinfo) {
		this.roleinfo = roleinfo;
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
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgida() {
		return orgida;
	}

	/**
	 * 用户机构层次码设定
	 *
	 * @param orgida 用户机构层次码
	 */
	public void setOrgida(String orgida) {
		this.orgida = orgida;
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
	 * 用户机构说明取得
	 * @return 用户机构说明
	 */
	public String getOrgdesc() {
		return orgdesc;
	}

	/**
	 * 用户机构说明设定
	 *
	 * @param orgdesc 用户机构说明
	 */
	public void setOrgdesc(String orgdesc) {
		this.orgdesc = orgdesc;
	}

	/**
	 * 用户机构信息取得
	 * @return 用户机构信息
	 */
	public String getOrginfo() {
		return orginfo;
	}

	/**
	 * 用户机构信息设定
	 *
	 * @param orginfo 用户机构信息
	 */
	public void setOrginfo(String orginfo) {
		this.orginfo = orginfo;
	}

	/**
	 * 用户机构类型取得
	 * @return 用户机构类型
	 */
	public String getOrgtype() {
		return orgtype;
	}

	/**
	 * 用户机构类型设定
	 *
	 * @param orgtype 用户机构类型
	 */
	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	/**
	 * 用户机构的上级机构层次码取得
	 * @return 用户机构的上级机构层次码
	 */
	public String getOrgpar() {
		return orgpar;
	}

	/**
	 * 用户机构的上级机构层次码设定
	 *
	 * @param orgpar 用户机构的上级机构层次码
	 */
	public void setOrgpar(String orgpar) {
		this.orgpar = orgpar;
	}

	/**
	 * 用户机构的上级机构名称取得
	 * @return 用户机构的上级机构名称
	 */
	public String getOrgparname() {
		return orgparname;
	}

	/**
	 * 用户机构的上级机构名称设定
	 *
	 * @param orgparname 用户机构的上级机构名称
	 */
	public void setOrgparname(String orgparname) {
		this.orgparname = orgparname;
	}

	/**
	 * 用户机构地址取得
	 * @return 用户机构地址
	 */
	public String getOrgaddr() {
		return orgaddr;
	}

	/**
	 * 用户机构地址设定
	 *
	 * @param orgaddr 用户机构地址
	 */
	public void setOrgaddr(String orgaddr) {
		this.orgaddr = orgaddr;
	}

	/**
	 * 用户机构电话取得
	 * @return 用户机构电话
	 */
	public String getOrgphone() {
		return orgphone;
	}

	/**
	 * 用户机构电话设定
	 *
	 * @param orgphone 用户机构电话
	 */
	public void setOrgphone(String orgphone) {
		this.orgphone = orgphone;
	}

	/**
	 * 用户机构传真取得
	 * @return 用户机构传真
	 */
	public String getOrgfax() {
		return orgfax;
	}

	/**
	 * 用户机构传真设定
	 *
	 * @param orgfax 用户机构传真
	 */
	public void setOrgfax(String orgfax) {
		this.orgfax = orgfax;
	}

	/**
	 * 用户机构联系人取得
	 * @return 用户机构联系人
	 */
	public String getOrgcontact() {
		return orgcontact;
	}

	/**
	 * 用户机构联系人设定
	 *
	 * @param orgcontact 用户机构联系人
	 */
	public void setOrgcontact(String orgcontact) {
		this.orgcontact = orgcontact;
	}

	/**
	 * 用户机构状态取得
	 * @return 用户机构状态
	 */
	public String getOrgstatus() {
		return orgstatus;
	}

	/**
	 * 用户机构状态设定
	 *
	 * @param orgstatus 用户机构状态
	 */
	public void setOrgstatus(String orgstatus) {
		this.orgstatus = orgstatus;
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
		return new UserInfoVWPK(userida, roleida);
	}

	/**
	 * 逻辑删除标志位取得
	 * @return 逻辑删除标志位
	 */
	public String getDeleteflag() {
		return deleteflag;
	}

	/**
	 * 逻辑删除标志位设定
	 *
	 * @param deleteflag 逻辑删除标志位
	 */
	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
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
}