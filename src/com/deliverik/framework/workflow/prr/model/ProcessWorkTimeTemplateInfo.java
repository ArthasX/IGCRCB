/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 作息时间模板定义表接口
  * 功能描述: 作息时间模板定义表接口
  * 创建记录: 2011/10/08
  * 修改记录: 
  */
public interface ProcessWorkTimeTemplateInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPwtId();

	/**
	 * 工作日期取得
	 *
	 * @return 工作日期
	 */
	public String getPwtDate();

	/**
	 * 工作开始时间取得
	 *
	 * @return 工作开始时间
	 */
	public String getPwtStartTime();

	/**
	 * 工作结束时间取得
	 *
	 * @return 工作结束时间
	 */
	public String getPwtEndTime();

	/**
	 * 休息时间取得
	 *
	 * @return 休息时间
	 */
	public Integer getPwtSleepTime();

	/**
	 * 有效时间取得
	 *
	 * @return 有效时间
	 */
	public Integer getFactTime();

}