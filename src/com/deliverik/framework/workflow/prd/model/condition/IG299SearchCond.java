/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 状态可分派机构定义表检索条件接口
  * 功能描述: 状态可分派机构定义表检索条件接口
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public interface IG299SearchCond {

	/**
	 * 流程状态节点取得
	 *
	 * @return psdid 流程状态节点
	 */
	public String getPsdid_eq() ;
	
	/**
	 * 流程状态节点指定可分派机构主键模糊查询取得
	 *
	 * @return psodid_like 流程状态节点指定可分派机构模糊查询
	 */
	public String getPsodid_like();
	
	/**
	 * 流程状态节点指定可分派机构码精确查询取得
	 *
	 * @return orgsyscoding_eq 流程状态节点指定可分派机构码精确查询
	 */
	public String getOrgsyscoding_eq() ;
	
	/**
	 * 流程状态节点like取得
	 * @return 流程状态节点like
	 */
	public String getPsdid_like();
	
}