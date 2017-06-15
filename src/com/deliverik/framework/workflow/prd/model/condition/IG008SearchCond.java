/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 人员表单角色限定检索条件接口
  * 功能描述: 人员表单角色限定检索条件接口
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
public interface IG008SearchCond {

	/**
	 * 表单定义主键取得
	 * @return pidid 表单定义主键
	 */
	public String getPidid();
	
	/**
	 * 流程定义主键取得
	 * @return pdid 流程定义主键
	 */
	public String getPdid();
}