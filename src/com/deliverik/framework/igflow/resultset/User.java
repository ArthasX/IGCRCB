/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 用户信息
 */
public class User implements UserInfo {
	
	/** 所属机构层次码 */
	private String orgid;

	/** 所属机构名称 */
	private String orgname;

	/** 用户ID */
	private String userid;

	/** 工号 */
	private String userinfo;

	/** 手机号 */
	private String usermobile;

	/** 用户姓名 */
	private String username;
	
	/** 用户邮箱 */
	private String useremail;
	
	/**
	 * 所属机构层次码取得
	 *
	 * @return 所属机构层次码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 所属机构名称取得
	 *
	 * @return 所属机构名称
	 */
	
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 工号取得
	 *
	 * @return 工号
	 */
	public String getUserinfo() {
		return userinfo;
	}

	/**
	 * 手机号取得
	 *
	 * @return 手机号
	 */
	public String getUsermobile() {
		return usermobile;
	}

	/**
	 * 用户姓名取得
	 *
	 * @return 用户姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 所属机构层次码设定
	 *
	 * @param orgid 所属机构层次码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 所属机构名称设定
	 *
	 * @param orgname 所属机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * 工号设定
	 *
	 * @param userinfo 工号
	 */
	public void setUserinfo(String userinfo) {
		this.userinfo = userinfo;
	}

	/**
	 * 手机号设定
	 *
	 * @param usermobile 手机号
	 */
	public void setUsermobile(String usermobile) {
		this.usermobile = usermobile;
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
	 * 用户邮箱取得
	 * @return 用户邮箱
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