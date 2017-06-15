/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 工作日志接口
  * 功能描述: 工作日志接口
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public interface WorkLogInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWlid();

	/**
	 * 工作实例表主键取得
	 *
	 * @return 工作实例表主键
	 */
	public Integer getWiid();

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
	 * 操作 取得
	 *
	 * @return 操作 
	 */
	public String getOperation();

	/**
	 * 日期栏日期取得
	 *
	 * @return 日期栏日期
	 */
	public String getTitleDate();

	/**
	 * 执行时间取得
	 *
	 * @return 执行时间
	 */
	public String getExcuteTime();

	/**
	 * 实际处理日期取得
	 *
	 * @return 实际处理日期
	 */
	public String getActualDealwithDate();

	/**
	 * 执行情况描述取得
	 *
	 * @return 执行情况描述
	 */
	public String getWlDescription();

	/**
	 * 表记录创建日期 取得
	 *
	 * @return 表记录创建日期 
	 */
	public String getCrtDate();

}