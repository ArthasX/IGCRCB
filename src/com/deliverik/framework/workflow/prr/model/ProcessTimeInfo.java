/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程计时表接口
  * 功能描述: 流程计时表接口
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public interface ProcessTimeInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPrtid();

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid();

	/**
	 * 计时用户ID取得
	 *
	 * @return 计时用户ID
	 */
	public String getUserid();

	/**
	 * 计时开始时间取得
	 *
	 * @return 计时开始时间
	 */
	public String getPrtstartTime();

	/**
	 * 开始计时状态取得
	 *
	 * @return 开始计时状态
	 */
	public String getPrtstartStatus();

	/**
	 * 计时结束时间取得
	 *
	 * @return 计时结束时间
	 */
	public String getPrtEndTime();

	/**
	 * 计时结束状态取得
	 *
	 * @return 计时结束状态
	 */
	public String getPrtEndStatus();

	/**
	 * 有效分钟数取得
	 *
	 * @return 有效分钟数
	 */
	public Integer getFactTime();

}