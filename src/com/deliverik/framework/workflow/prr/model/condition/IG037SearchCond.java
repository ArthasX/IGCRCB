/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程导入日志表检索条件接口
  * 功能描述: 流程导入日志表检索条件接口
  * 创建记录: 2014/11/14
  * 修改记录: 
  */
public interface IG037SearchCond {
	
	/**
	 * 流程主键取得
	 * @return 流程主键
	 */
	public Integer getPrid();
	
	/**
	 * 流程导入用户ID取得
	 * @return 流程导入用户ID
	 */
	public String getIruserid();
	
	/**
	 * 流程导入部门ID取得
	 * @return 流程导入部门ID
	 */
	public String getIrorgid();
	
	/**
	 * 流程导入部门ID左匹配取得
	 * @return 流程导入部门ID左匹配
	 */
	public String getIrorgid_like_l();

}