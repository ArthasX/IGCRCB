/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险监测表接口
  * 功能描述: 风险监测表接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface RiskMonitoringInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRmid();

	/**
	 * 风险策略主键id取得
	 *
	 * @return 风险策略主键id
	 */
	public Integer getRsid();

	/**
	 * 监测任务名称取得
	 *
	 * @return 监测任务名称
	 */
	public String getRmname();

	/**
	 * 计划开始时间取得
	 *
	 * @return 计划开始时间
	 */
	public String getRmstartdate();

	/**
	 * 实际完成时间取得
	 *
	 * @return 实际完成时间
	 */
	public String getRmenddate();

}