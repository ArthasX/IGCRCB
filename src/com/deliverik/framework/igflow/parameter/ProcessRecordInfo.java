/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.parameter;

import java.util.Map;

/**
 * 流程发起信息
 */
public interface ProcessRecordInfo {
	
	/**
	 * 流程发起人ID取得
	 * 
	 * @return 流程发起人ID
	 */
	public String getCrtuserid();

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getDefid();
	
	/**
	 * 流程定义状态取得
	 * 
	 * @return 流程定义状态
	 */
	public String getDefstatus();

	/**
	 * 流程描述取得
	 * 
	 * @return 流程描述
	 */
	public String getDescription();

	/**
	 * 表单值集合取得
	 * 
	 * @return 表单值集合
	 */
	public Map<String, String> getFormvalue();
	
	/**
	 * 日志参数信息取得
	 * 
	 * @return 日志参数信息
	 */
	public WorkFlowLogInfo getLogInfo();

	/**
	 * 流程发起角色ID取得
	 * 
	 * @return 流程发起角色ID
	 */
	public Integer getRoleid();

	/**
	 * 流程名称取得
	 * 
	 * @return 流程名称
	 */
	public String getTitle();
	
	/**
	 * 流程组实例ID取得
	 * 
	 * @return 流程组实例ID
	 */
	public Integer getGroupID();

	/**
	 * 流程组定义ID取得
	 * 
	 * @return 流程组定义ID
	 */
	public String getGroupDefID();
	
}
