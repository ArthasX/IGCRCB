/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 处理日志信息
 */
public interface ProcessLogInfo {

	/**
	 * 提交时间取得
	 * @return 提交时间
	 */
	public String getCommittime();

	/**
	 * 日志ID取得
	 * @return 日志ID
	 */
	public Integer getPlid();

	/**
	 * 状态ID取得
	 * @return 状态ID
	 */
	public String getPsdid();

	/**
	 * 处理记录取得
	 * @return 处理记录
	 */
	public String getRecord();

	/**
	 * 处理角色ID取得
	 * @return 处理角色ID
	 */
	public Integer getRoleid();

	/**
	 * 处理角色名称取得
	 * @return 处理角色名称
	 */
	public String getRolename();
	/**
	 * 处理人ID取得
	 * @return 处理人ID
	 */
	public String getUserid();
	
	/**
	 * 处理人姓名取得
	 * @return 处理人姓名
	 */
	public String getUsername();
	
}
