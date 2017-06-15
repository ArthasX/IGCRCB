/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;



/**
 * 流程组发起信息
 */
public interface ProcessGroupInfo {
	
	/**
	 * 流程组发起人ID取得
	 * 
	 * @return 流程组发起人ID
	 */
	public String getCrtuserid();

	/**
	 * 流程组定义ID取得
	 * 
	 * @return 流程组定义ID
	 */
	public String getDefid();
	
	/**
	 * 流程组定义状态取得
	 * 
	 * @return 流程组定义状态
	 */
	public String getDefstatus();

	/**
	 * 流程组描述取得
	 * 
	 * @return 流程组描述
	 */
	public String getDescription();

	/**
	 * 流程组名称取得
	 * 
	 * @return 流程组名称
	 */
	public String getTitle();
	
	/**
	 * 流程实例名称取得
	 * @param pdid 流程定义ID
	 * @return 流程实例名称
	 */
	public String getProcessTitle(String pdid);
	
}
