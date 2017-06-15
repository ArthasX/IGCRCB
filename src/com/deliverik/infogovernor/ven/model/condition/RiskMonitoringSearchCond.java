/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.condition;


/**
  * 概述: 风险监测表检索条件接口
  * 功能描述: 风险监测表检索条件接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface RiskMonitoringSearchCond {
	/**
	 * rmid取得
	 * @return rmid  rmid
	 */
	public Integer getRmid();

	

	/**
	 * 风险策略主键id取得
	 * @return rsid  风险策略主键id
	 */
	public Integer getRsid();

	/**
	 * 监测任务名称取得
	 * @return rmname  监测任务名称
	 */
	public String getRmname();

	/**
	 * 计划开始时间取得
	 * @return rmstartdate  计划开始时间
	 */
	public String getRmstartdate();


	/**
	 * 查询条件计划开始时间取得
	 * @return rmstartdate_from  查询条件计划开始时间
	 */
	public String getRmstartdate_from();

	/**
	 * 查询条件计划开始时间取得
	 * @return rmstartdate_to  查询条件计划开始时间
	 */
	public String getRmstartdate_to();


	/**
	 * 实际完成时间取得
	 * @return rmenddate  实际完成时间
	 */
	public String getRmenddate();

	/**
	 * 查询条件实际完成时间取得
	 * @return rmenddate_from  查询条件实际完成时间
	 */
	public String getRmenddate_from();

	
	/**
	 * 查询条件实际完成时间取得
	 * @return rmenddate_to  查询条件实际完成时间
	 */
	public String getRmenddate_to();
	
}