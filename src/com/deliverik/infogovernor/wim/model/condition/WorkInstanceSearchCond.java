/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * 概述: 工作实例检索条件接口
  * 功能描述: 工作实例检索条件接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkInstanceSearchCond {

	/**
	 * 工作实例名称取得
	 *
	 * @return 工作实例名称
	 */
	public String getWiname();

	/**
	 * 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）取得
	 *
	 * @return 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 */
	public Integer getWistatus();

	/**
	 * 部门（id）取得
	 *
	 * @return 部门（id）
	 */
	public String getWiDepartmentid();
	
	/**
	 * 人员（userid）取得
	 *
	 * @return 人员（userid）
	 */
	public String getWiuserid();

	/**
	 * 发起类型（1，自动发起；2，手动发起）取得
	 *
	 * @return 发起类型（1，自动发起；2，手动发起）
	 */
	public String getWiLunchType();

	/**
	 * 执行需所时间（小时）取得
	 *
	 * @return 执行需所时间（小时）
	 */
	public String getExcuteTime();

	/**
	 * 实际处理日期取得
	 *
	 * @return 实际处理日期
	 */
	public String getActualDealwithDate();

	/**
	 * 工作确认日期取得
	 *
	 * @return 工作确认日期
	 */
	public String getConfirmDate();

	/**
	 * 日期栏日期取得
	 *
	 * @return 日期栏日期
	 */
	public String getTitleDate();

	/**
	 * 表记录创建日期取得
	 *
	 * @return 表记录创建日期
	 */
	public String getCrtDate();
}