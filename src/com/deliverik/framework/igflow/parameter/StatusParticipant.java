/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 状态参与者信息
 */
public class StatusParticipant implements StatusParticipantInfo {
	
	/** 日志参数信息 */
	private WorkFlowLogInfo logInfo;

	/** 流程处理角色ID */
	private Integer roleid;
	
	/** 流程状态名称 */
	private String statusname;

	/** 流程处理人ID */
	private String userid;
	
	/** 状态码 */
	private String statuscode;
	
	/**
	 * 构造函数
	 * 
	 * @param logInfo 日志参数信息
	 */
	public StatusParticipant(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo() {
		return logInfo;
	}

	/**
	 * 流程处理角色ID取得
	 * 
	 * @return 流程处理角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 流程状态名称取得
	 * 
	 * @return 流程状态名称
	 */
	public String getStatusname() {
		return statusname;
	}

	/**
	 * 流程处理人ID取得
	 * 
	 * @return 流程处理人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 日志参数信息设定
	 * 
	 * @param logInfo 日志参数信息
	 */
	public void setLogInfo(WorkFlowLogInfo logInfo) {
		this.logInfo = logInfo;
	}

	/**
	 * 流程处理角色ID设定
	 * 
	 * @param roleid 流程处理角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 流程状态名称设定
	 * 
	 * @param statusname 流程状态名称
	 */
	public void setStatusname(String statusname) {
		this.statusname = statusname;
	}

	/**
	 * 流程处理人ID设定
	 * 
	 * @param userid 流程处理人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}


	/**
	 * 状态码取得
	 * @return statuscode 状态码
	 */
	public String getStatuscode() {
		return statuscode;
	}

	/**
	 * 状态码设定
	 * @param statuscode 状态码
	 */
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}
}
