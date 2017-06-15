/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程外部调用定义表检索条件接口
  * 功能描述: 流程外部调用定义表检索条件接口
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
public interface IG992SearchCond {
	/**
	 * 外部事件ID取得
	 * 
	 * @return 外部事件ID
	 */
	public Integer getPedid();
	/**
	 * 外部事件取得
	 *
	 * @return 外部事件
	 */
	public String getPedeventid();

	/**
	 * 外部动作取得
	 *
	 * @return 外部动作
	 */
	public String getPedaction();
	/**
	 * 流程状态取得
	 *
	 * @return 流程状态
	 */
	public String getPeddesc();
}