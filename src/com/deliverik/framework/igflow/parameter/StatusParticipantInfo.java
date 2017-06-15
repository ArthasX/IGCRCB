/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 状态参与者信息
 */
public interface StatusParticipantInfo {
	
	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo();

	/**
	 * 流程处理角色ID取得
	 * 
	 * @return 流程处理角色ID
	 */
	public Integer getRoleid();

	/**
	 * 流程状态名称取得
	 * 
	 * @return 流程状态名称
	 */
	public String getStatusname();

	/**
	 * 流程处理人ID取得
	 * 
	 * @return 流程处理人ID
	 */
	public String getUserid();
	
	/**
	 * 状态码取得
	 * @return statuscode 状态码
	 */
	public String getStatuscode();
	
}
