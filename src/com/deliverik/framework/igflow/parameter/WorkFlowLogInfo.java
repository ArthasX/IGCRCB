/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

/**
 * 流程日志参数信息
 */
public interface WorkFlowLogInfo {
	
	/**
	 * 授权用户ID取得
	 * 
	 * @return 授权用户ID
	 */
	public String getAuthuserid();

	/**
	 * 备注取得
	 * 
	 * @return 备注
	 */
	public String getComment();

	/**
	 * 当前用户ID取得
	 * 
	 * @return 当前用户ID
	 */
	public String getExecutorid();

	/**
	 * 流程处理角色ID取得
	 * 
	 * @return 流程处理角色ID
	 */
	public Integer getExecutorRoleid();

	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid();

}
