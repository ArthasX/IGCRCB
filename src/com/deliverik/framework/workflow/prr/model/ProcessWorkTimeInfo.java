/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 用户作息时间定义表接口
  * 功能描述: 用户作息时间定义表接口
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public interface ProcessWorkTimeInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPwId();

	/**
	 * 用户ID取得
	 *
	 * @return 用户ID
	 */
	public String getUserId();

	/**
	 * 工作日期取得
	 *
	 * @return 工作日期
	 */
	public String getPwDate();

	/**
	 * 工作开始时间取得
	 *
	 * @return 工作开始时间
	 */
	public String getPwStartTime();

	/**
	 * 工作结束时间取得
	 *
	 * @return 工作结束时间
	 */
	public String getPwEndTime();

	/**
	 * 休息时间取得
	 *
	 * @return 休息时间
	 */
	public Integer getPwSleep();

	/**
	 * 用户修改标志位取得
	 *
	 * @return 用户修改标志位
	 */
	public String getPwFlg();

	/**
	 * 有效时间取得
	 *
	 * @return 有效时间
	 */
	public Integer getFactTime();


}