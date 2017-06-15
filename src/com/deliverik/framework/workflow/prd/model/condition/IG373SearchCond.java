/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程表单初始化事件定义表检索条件接口
  * 功能描述: 流程表单初始化事件定义表检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 
  */
public interface IG373SearchCond {

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid();

	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid();

}