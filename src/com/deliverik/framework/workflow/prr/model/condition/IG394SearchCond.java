/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 提醒记录表检索条件接口
  * 功能描述: 提醒记录表检索条件接口
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public interface IG394SearchCond {
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPnssid();

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid();

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid();

	/**
	 * 接单状态取得
	 *
	 * @return 接单状态
	 */
	public String getPsdconfirm();

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid();

	/**
	 * 发给的用户ID取得
	 *
	 * @return 发给的用户ID
	 */
	public String getUserid();

	public String getNotifysmstime();

	public String getNotifyemailtime();

	public String getReportsmstime();

	public String getReportemailtime();
	
	public String getFlag();
	
}