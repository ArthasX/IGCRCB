/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 角色负责人信息
 */
public class RoleMng implements RoleMngInfo {
	
	/** 角色负责人ID */
	private String userid;
	
	/** 角色负责人姓名 */
	private String username;
	
	/**
	 * 角色负责人ID取得
	 * @return 角色负责人ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 角色负责人姓名取得
	 *
	 * @return 角色负责人姓名
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 角色负责人ID设定
	 *
	 * @param userid 角色负责人ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 角色负责人姓名设定
	 *
	 * @param username 角色负责人姓名
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
}
