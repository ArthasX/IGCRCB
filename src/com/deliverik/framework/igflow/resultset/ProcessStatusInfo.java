/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;


/**
 * 流程状态定义信息
 */
public interface ProcessStatusInfo {
	
	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 流程状态名称取得
	 * @return 流程状态名称
	 */
	public String getPsdname();
	
	/**
	 * 流程状态标识取得
	 * @return 流程状态标识
	 */
	public String getPsdcode();
	
	/**
	 * 排序取得
	 * @return 排序
	 */
	public String getBysequence();

	/**
	 * 上级状态ID取得
	 * @return 上级状态ID
	 */
	public String getPpsdid();

	/**
	 * 状态开始时间取得
	 * @return 状态开始时间
	 */
	public String getOpentime();

	/**
	 * 状态结束时间取得
	 * @return 状态结束时间
	 */
	public String getClosetime();

	/**
	 * 状态分支编号取得
	 * @return 状态分支编号
	 */
	public String getStatusnum();
	
	/**
	 * 时间戳取得
	 * @return fingerPrint 时间戳
	 */
	public String getFingerPrint();

}
