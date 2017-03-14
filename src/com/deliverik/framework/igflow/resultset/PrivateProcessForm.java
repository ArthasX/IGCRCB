/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 流程表单信息
 */
public class PrivateProcessForm implements PrivateProcessFormInfo {
	
	/** 参与者角色ID */
	private Integer roleid;
	
	/** 参与者用户ID */
	private String userid;

	/** 表单值 */
	private String value;
	
	/** 备注信息 */
	private String comment;
	
	/**
	 * 参与者角色ID取得
	 *
	 * @return 参与者角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 参与者用户ID取得
	 * 
	 * @return 参与者用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getValue() {
		return value;
	}

	/**
	 * 参与者角色ID设定
	 *
	 * @param roleid 参与者角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}
	
	/**
	 * 参与者用户ID设定
	 * 
	 * @param userid 参与者用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 表单值设定
	 *
	 * @param value 表单值
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * 备注信息取得
	 * @return comment 备注信息
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 备注信息设定
	 * @param comment 备注信息
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

}
