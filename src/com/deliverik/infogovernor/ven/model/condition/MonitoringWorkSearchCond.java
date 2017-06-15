/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * 概述: 监测工作填报表检索条件接口
  * 功能描述: 监测工作填报表检索条件接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface MonitoringWorkSearchCond {
	
	/**
	 * 风险策略主键id取得
	 * @return rmid  风险策略主键id
	 */
	public Integer getRmid();
	
	/**
	 * 监测结果null取得
	 * @return result_isNotNull  监测结果null
	 */
	public String getResult_isNotNull();
	
	/**
	 * 指标名称取得
	 * @return einame  指标名称
	 */
	public String getEiname();
	
	/**
	 * 指标编号取得
	 * @return eilabel  指标编号
	 */
	public String getEilabel();
}