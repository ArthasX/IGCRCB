/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控对象KPI信息视图检索条件接口
  * 功能描述: 监控对象KPI信息视图检索条件接口
  * 创建记录: 2012/02/13
  * 修改记录: 
  */
public interface MonitorObjectDefVWSearchCond {

	/**
	 * 监控对象名称取得
	 *
	 * @return 监控对象名称
	 */
	public String getMoName();
	
	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag();
}