/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 流程日志参数信息
 */
public class WorkFlowLog implements WorkFlowLogInfo {

	/** 授权用户ID */
	private String authuserid;

	/** 备注 */
	private String comment;

	/** 当前用户ID */
	private String executorid;
	
	/** 流程处理角色ID */
	private Integer executorRoleid;
	
	/** 流程ID */
	private Integer prid;

	/**
	 * 授权用户ID取得
	 * 
	 * @return 授权用户ID
	 */
	public String getAuthuserid() {
		return authuserid;
	}

	/**
	 * 备注取得
	 * 
	 * @return 备注
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 当前用户ID取得
	 * 
	 * @return 当前用户ID
	 */
	public String getExecutorid() {
		return executorid;
	}

	/**
	 * 流程处理角色ID取得
	 * 
	 * @return 流程处理角色ID
	 */
	public Integer getExecutorRoleid() {
		return executorRoleid;
	}

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 授权用户ID设定
	 * 
	 * @param authuserid 授权用户ID（可为空）
	 */
	public void setAuthuserid(String authuserid) {
		this.authuserid = authuserid;
	}

	/**
	 * 备注设定
	 * 
	 * @param comment 备注
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 当前用户ID设定
	 * 
	 * @param executorid 当前用户ID
	 */
	public void setExecutorid(String executorid) {
		this.executorid = executorid;
	}

	/**
	 * 流程处理角色ID设定
	 * 
	 * @param executorRoleid 流程处理角色ID
	 */
	public void setExecutorRoleid(Integer executorRoleid) {
		this.executorRoleid = executorRoleid;
	}

	/**
	 * 流程ID设定
	 * 
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
}
