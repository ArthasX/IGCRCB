/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.sym.model.UserNotRole;

/**
 * @Description: 角色授权用户管理
 * @Author  masai
 * @History 2010-6-22     新建 
 * @Version V2.0
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "UserNotRoleVW")
@SuppressWarnings("serial")
public class UserNotRoleVW implements Serializable, Cloneable, UserNotRole {
	@Id
	protected String userid;
	
	protected String username;
	
	protected String userphone;
	
	protected String usermobile;
	
	protected String useremail;
	
	protected String orgid;
	
	protected String orgname;

	protected Integer roleid;
	
	protected String userstatus;

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public String getUsermobile() {
		return usermobile;
	}

	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
	}

	public String getUseremail() {
		return useremail;
	}

	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}

	public String getOrgid() {
		return orgid;
	}

	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	public Integer getRoleid() {
		return roleid;
	}

	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	public String getUserstatus() {
		return userstatus;
	}

	public void setUserstatus(String userstatus) {
		this.userstatus = userstatus;
	}

}

