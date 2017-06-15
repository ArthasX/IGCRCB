package com.deliverik.framework.user.model.condition;

import java.util.List;

/**
 * 用户信息检索条件实现
 * 
 */
public class UserSearchCondImpl implements UserSearchCond {

	/** 用户ID */
	protected String userid;
	
	/** 用户ID */
	protected String userid_q;
	
	/** 用户名称 */
	protected String username;
	
	/** 用户名称 */
	protected String username_q;

	/** 用户口令 */
	protected String password;
	
	/** 用户机构层次码 */
	protected String orgid;
	
	/** 用户机构层次码 */
	protected String orgid_like;
	
	/** 用户手机 */
	protected String usermobile;

	/** 逻辑删除标志位 */
	protected String deleteflag;
	
	/** 工号 */
	protected String userinfo;
	
	/** 工号 */
	protected String userinfo_like;
	
	/** 用户ID范围 */
	protected List<String> userid_in;

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
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid_q() {
		return userid_q;
	}

	/**
	 * 用户ID设定
	 *
	 * @param userid_q 用户ID
	 */
	public void setUserid_q(String userid_q) {
		this.userid_q = userid_q;
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
	 * 用户名称取得
	 * @return 用户名称
	 */
	public String getUsername_q() {
		return username_q;
	}

	/**
	 * 用户名称设定
	 *
	 * @param username_q 用户名称
	 */
	public void setUsername_q(String username_q) {
		this.username_q = username_q;
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
	 * 用户机构层次码取得
	 * @return 用户机构层次码
	 */
	public String getOrgid_like() {
		return orgid_like;
	}

	/**
	 * 用户机构层次码设定
	 *
	 * @param orgid 用户机构层次码
	 */
	public void setOrgid_like(String orgid_like) {
		this.orgid_like = orgid_like;
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
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo() {
		return userinfo;
	}
	
	/**
	 * 工号设定
	 *
	 * @param userinfo 工号 
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}
	
	/**
	 * 工号取得
	 * @return 工号
	 */
	public String getUserinfo_like() {
		return userinfo_like;
	}
	
	/**
	 * 工号设定
	 *
	 * @param userinfo_like 工号 
	 */
	public void setUserinfo_like(String userinfo_like) {
		this.userinfo_like = userinfo_like;
	}
	
	/**
	 * 用户ID范围取得
	 * @return userid_in 用户ID范围
	 */
	public List<String> getUserid_in() {
		return userid_in;
	}

	/**
	 * 用户ID范围设定
	 * @param userid_in 用户ID范围
	 */
	public void setUserid_in(List<String> userid_in) {
		this.userid_in = userid_in;
	}
}
