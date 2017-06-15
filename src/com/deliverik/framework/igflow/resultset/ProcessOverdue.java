/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

/**
 * 流程逾期未处理参与者信息
 */
public class ProcessOverdue implements ProcessOverdueInfo {

	/** 参与人ID */
	protected String userid;
	
	/** 参与人姓名 */
	protected String username;

	/**
	 * 参与人ID设定
	 * @return 参与人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 参与人ID取得
	 * @param userid 参与人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 参与人姓名取得
	 * @return 参与人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 参与人姓名设定
	 * @param username 参与人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
