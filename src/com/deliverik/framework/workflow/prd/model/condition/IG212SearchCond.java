/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程通知策略检索条件接口
  * 功能描述: 流程通知策略检索条件接口
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
public interface IG212SearchCond {

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid_like();
	
	/**
	 * 流程定义ID获取
	 * @return
	 */
	public String getPdid();
}