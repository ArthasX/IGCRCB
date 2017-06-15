package com.deliverik.framework.user.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.dao.hibernate.LogicalDelete;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.StringEncrypt;


/**
 * <p>
 * 用户信息实体
 * </p>
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IgUser")
public class UserTB extends BaseEntity implements Serializable, Cloneable, User ,LogicalDelete {

	/** 用户ID */
	@Id
	protected String userid;
	
	/** 用户名称 */
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

	/** 用户机构层次码 */
	protected String orgid;

	/** 用户机构名称 */
	protected String orgname;
	
	/** 逻辑删除标志位 */
	protected String deleteflag;
	
	/** 用户机构信息实体 */
	@Transient
	protected OrganizationTB organizationTB;
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
	 * 用户名称取得
	 * @return 用户名称
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 用户名称设定
	 *
	 * @param username 用户名称
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * 用户口令取得
	 * @return 用户口令
	 */
	public String getPassword() {
		if(StringUtils.isEmpty(password)) {
			return password;
		} else {
			return StringEncrypt.asciiToChar(password);
		}
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
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 用户机构层次码设定
	 *
	 * @param orgid 用户机构层次码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
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
	 * 获取主键
	 * @return 主键
	 */
	public Serializable getPK() {
		return userid;
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
//业务连续性 drm


	
	
	/**
	 * 用户机构信息实体取得
	 * @return 用户机构信息实体
	 */
	public OrganizationTB getOrganizationTB() {
		if(this.organizationTB == null){
			if(StringUtils.isNotEmpty(this.orgid)){
				OrganizationBL bl = (OrganizationBL) WebApplicationSupport.getBean("organizationBL");
				OrganizationSearchCondImpl cond = new OrganizationSearchCondImpl();
				cond.setOrgsyscoding(this.orgid);
				List<Organization> list = bl.searchOrganization(cond);
				if(list.size() == 1){
					this.organizationTB = (OrganizationTB) list.get(0);
				}
			}
		}
		return organizationTB;
	}

	/**
	 * 用户机构信息实体设定
	 *
	 * @param organizationTB 用户机构信息实体
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

}
