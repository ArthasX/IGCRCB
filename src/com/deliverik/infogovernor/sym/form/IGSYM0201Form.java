/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sym.form;

import java.util.List;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.condition.UserSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 系统管理_用户管理_查询删除Form
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSYM0201Form extends BaseForm implements UserSearchCond{
	
	/**
	 * 用户主键
	 */
	
	protected String userid;
	
	/**
	 * 用户id(查询)
	 */
	
	protected String userid_q;
	
	/**
	 * 用户名称
	 */
	
	protected String username;
	
	/**
	 * 用户名称(查询)
	 */
	
	protected String username_q;
	
	/**
	 * 密码
	 */
	
	protected String password;
	
	/**
	 * 机构id
	 */
	
	protected String orgid;
	
	/**
	 * 机构id
	 */
	
	protected String orgidstr;
	/**
	 * 机构name
	 */
	
	protected String orgname;
	
	/** 逻辑删除标志位 */
	protected String deleteflag;
	/**
	 * 
	 */
	protected String changeUserid;
	/**
	 * 工号
	 * */
	protected String userinfo;
	
	public String getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	public String getChangeUserid() {
		return changeUserid;
	}

	public void setChangeUserid(String changeUserid) {
		this.changeUserid = changeUserid;
	}

	public String getOrgname() {
		return orgname;
	}

	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 获取用户主键
	 * @return String
	 */
	
	public String getUserid() {
		return userid;
	}
	
	/**
	 * 设置用户主键
	 * @param userid String
	 */
	
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 获取用户名称
	 * @return String
	 */
	
	public String getUsername() {
		return username;
	}
	
	/**
	 * 设置用户名称
	 * @param username String
	 */
	
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 获取密码
	 * @return String
	 */
	
	public String getPassword() {
		return password;
	}

	/**
	 * 设置密码
	 * @param password String
	 */
	
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * 获取机构id
	 * @return String
	 */
	
	public String getOrgid() {
		if( (this.orgidstr == null) || ("".equals(this.orgidstr))){
			return null;
		} else {
			return this.orgidstr;
		}
	}

	/**
	 * 设置机构id
	 * @param orgid Integer
	 */
	
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 获取机构id
	 * @return String
	 */
	
	public String getOrgidstr() {
		return orgidstr;
	}

	/**
	 * 设置机构id
	 * @param orgid String
	 */
	
	public void setOrgidstr(String orgidstr) {
		this.orgidstr = orgidstr;
	}

	/**
	 * 获取用户名称（查询）
	 * @return String
	 */
	
	public String getUsername_q() {
		return username_q;
	}

	/**
	 * 设置用户名称（查询）
	 * @param username_q String
	 */
	
	public void setUsername_q(String username_q) {
		this.username_q = username_q;
	}

	/**
	 * 获取用户id（查询）
	 * @return String
	 */
	
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * 设置用户id（查询）
	 * @param userid_q String
	 */
	
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
	}

	public String getUsermobile() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDeleteflag() {
		return deleteflag;
	}

	public void setDeleteflag(String deleteflag) {
		this.deleteflag = deleteflag;
	}

	public String getUserinfo_like() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<String> getUserid_in() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getOrgid_like() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
