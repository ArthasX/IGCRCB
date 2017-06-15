/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * 概述: 工作日志还检索条件接口
  * 功能描述: 工作日志检索条件接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkLogSearchCond {

	/**
	 * 工作日志名称取得
	 *
	 * @return 工作日志名称
	 */
	public String getWlname();

	/**
	 * 执行人（userid）取得
	 *
	 * @return 执行人（userid）
	 */
	public String getExcutorId();

	/**
	 * 日期栏日期取得
	 *
	 * @return 日期栏日期
	 */
	public String getTitleDate();
	/**
	 * 执行时间取得
	 *
	 * @return excuteTime
	 */
	public String getExcuteTime();

	/**
	 * 实际处理日期取得
	 *
	 * @return 实际处理日期
	 */
	public String getActualDealwithDate();

	/**
	 * 表记录创建日期取得
	 *
	 * @return 表记录创建日期
	 */
	public String getCrtDate();
}