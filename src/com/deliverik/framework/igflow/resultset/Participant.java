/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程参与者信息
 */
public class Participant implements ParticipantInfo {
	
	/** 机构层次码 */
	private String orgid;

	/** 机构名称 */
	private String orgname;

	/** 角色ID */
	private Integer roleid;

	/** 角色名称 */
	private String rolename;
	
	/** 用户ID */
	private String userid;
	
	/** 用户姓名 */
	private String username;
	
	/** 手机号 */
	private String phone;
	
	/** 处理开始时间 */
	private String ppinittime; 
	
	/** 处理结束时间 */
	private String ppproctime;
	
	/**
	 * 机构层次码取得
	 * @return 机构层次码
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 机构层次码设定
	 * @param orgid 机构层次码
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 机构名称取得
	 * @return 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
	}

	/**
	 * 角色ID取得
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色名称取得
	 * @return 角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 用户ID取得
	 * @return 用户ID
	 */
	public String getUserid() {
		return userid;
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
	 * 角色ID设定
	 *
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 角色名称设定
	 *
	 * @param rolename 角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
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
	 * 用户姓名设定
	 *
	 * @param username 用户姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * 手机号取得
	 * @return 手机号
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * 手机号设定
	 * @param phone 手机号
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * 处理开始时间取得
	 * @return 处理开始时间
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * 处理开始时间设定 
	 * @return 处理开始时间
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}

	/**
	 * 处理结束时间取得
	 * @param ppopentime 处理结束时间 
	 */
	public String getPpproctime() {
		return ppproctime;
	}

	/**
	 * 处理结束时间设定
	 * @param ppproctime 处理结束时间
	 */
	public void setPpproctime(String ppproctime) {
		this.ppproctime = ppproctime;
	}
}