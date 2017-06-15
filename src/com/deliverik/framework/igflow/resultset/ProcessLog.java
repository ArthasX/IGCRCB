/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 处理日志信息
 */
public class ProcessLog implements ProcessLogInfo {
	
	/** 提交时间 */
	private String committime;

	/** 日志ID */
	public Integer plid;

	/** 状态ID */
	private String psdid;

	/** 处理记录 */
	private String record;
	
	/** 处理角色ID */
	private Integer roleid;

	/** 处理角色姓名 */
	private String rolename;

	/** 处理人ID */
	private String userid;
	
	/** 处理人姓名 */
	private String username;
	
	/**
	 * 提交时间取得
	 * @return 提交时间
	 */
	public String getCommittime() {
		return committime;
	}

	/**
	 * 日志ID设定
	 * @param committime 日志ID
	 */
	public void setCommittime(String committime) {
		this.committime = committime;
	}

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getPlid() {
		return plid;
	}


	/**
	 * 提交时间设定
	 * @param committime 提交时间
	 */
	public void setPlid(Integer plid) {
		this.plid = plid;
	}

	/**
	 * 状态ID取得
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 处理记录取得
	 * @return 处理记录
	 */
	public String getRecord() {
		return record;
	}

	/**
	 * 处理记录设定
	 * @param record 处理记录
	 */
	public void setRecord(String record) {
		this.record = record;
	}

	/**
	 * 处理角色ID取得
	 * @return 处理角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 处理角色ID设定
	 * @param roleid 处理角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 处理角色名称取得
	 * @return 处理角色名称
	 */
	public String getRolename() {
		return rolename;
	}

	/**
	 * 处理角色名称设定
	 * @param rolename 处理角色名称
	 */
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	/**
	 * 处理人ID取得
	 * @return 处理人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 处理人ID设定
	 * @param userid 处理人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	/**
	 * 处理人姓名取得
	 * @return 处理人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 处理人姓名设定
	 * @param username 处理人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}