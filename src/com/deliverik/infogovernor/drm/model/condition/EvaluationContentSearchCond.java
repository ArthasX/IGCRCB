/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.condition;

/**
  * 概述: 项目周报人员工作量检索条件接口
  * 功能描述: 项目周报人员工作量检索条件接口
  * 创建记录: 2016/08/11
  * 修改记录: 
  */
public interface EvaluationContentSearchCond {
	/**
	 * 评估ID取得
	 *
	 * @return 评估ID
	 */
	public Integer getEvid();

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid();

	/**
	 * 序号取得
	 *
	 * @return 序号
	 */
	public Integer getSortId();

	/**
	 * 节点名称取得
	 *
	 * @return 节点名称
	 */
	public String getStepName();

	/**
	 * 参与人取得
	 *
	 * @return 参与人
	 */
	public String getPeoples();

	/**
	 * 开始时间取得
	 *
	 * @return 开始时间
	 */
	public String getStartTime();

	/**
	 * 结束时间取得
	 *
	 * @return 结束时间
	 */
	public String getStopTime();


	/**
	 * 意见取得
	 *
	 * @return 意见
	 */
	public String getSuggestion();

	/**
	 * 评估人取得
	 *
	 * @return 评估人
	 */
	public String getEvpeople();

	
	/**  
	 * 获取psdid  
	 * @return psdid 
	 */
	public String getPsdid();
	
	/**  
	 * 获取doTime  
	 * @return doTime 
	 */
	public String getDoTime();
	
	/**  
	 * 获取flowType  
	 * @return flowType 
	 */
	public String getFlowType();
}