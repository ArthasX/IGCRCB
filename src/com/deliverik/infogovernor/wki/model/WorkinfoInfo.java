/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 工作信息接口
  * 功能描述: 工作信息接口
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
public interface WorkinfoInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getWorkinfoid();

	/**
	 * 工作名称取得
	 *
	 * @return 工作名称
	 */
	public String getWorkname();

	/**
	 * 周期取得
	 *
	 * @return 周期
	 */
	public Integer getWorkperiod();

	/**
	 * 预计完成时间取得
	 *
	 * @return 预计完成时间
	 */
	public String getEstFinDate();

	/**
	 * 实际完成时间取得
	 *
	 * @return 实际完成时间
	 */
	public String getActFinDate();

	/**
	 * 超时提醒期限取得
	 *
	 * @return 超时提醒期限
	 */
	public Integer getTimeOutPeriod();

	/**
	 * 发起人id取得
	 *
	 * @return 发起人id
	 */
	public Integer getInitid();

	/**
	 * 发起人姓名取得
	 *
	 * @return 发起人姓名
	 */
	public String getInitname();

	/**
	 * 执行人id取得
	 *
	 * @return 执行人id
	 */
	public Integer getExecid();

	/**
	 * 执行人姓名取得
	 *
	 * @return 执行人姓名
	 */
	public String getExecname();

	/**
	 * 工作状态取得
	 *
	 * @return 工作状态
	 */
	public Integer getWorkstatus();

	/**
	 * 备注取得
	 *
	 * @return 备注
	 */
	public String getRemark();

}