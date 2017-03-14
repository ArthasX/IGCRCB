/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程状态可分派角色定义信息检索条件接口
  * 功能描述: 流程状态可分派角色定义信息检索条件接口
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public interface IG298SearchCond {
	
	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid();
	
	/**
	 * 角色ID取得
	 * 
	 * @return 角色ID
	 */
	public Integer getRoleid();

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPsrdid_like();

}