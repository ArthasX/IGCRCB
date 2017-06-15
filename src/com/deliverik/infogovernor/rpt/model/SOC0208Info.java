/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 事件变更服务效率接口
  * 功能描述: 事件变更服务效率接口
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/09 将ServeEfficiencyInfo表名改为SOC0208Info
  */
public interface SOC0208Info extends BaseModel {

	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype();

	/**
	 * 流程来源取得
	 *
	 * @return 流程来源
	 */
	public String getPivaralue();

	/**
	 * 时间取得
	 *
	 * @return 时间
	 */
	public String getEfficiencyTime();

	/**
	 * 当前月服务效率取得
	 *
	 * @return 当前月服务效率
	 */
	public String getMonthEfficiency();

	/**
	 * 历史服务效率取得
	 *
	 * @return 历史服务效率
	 */
	public String getHistoryEfficiency();

}