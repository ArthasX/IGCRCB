/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 自定义流程分派定义表检索条件接口
  * 功能描述: 自定义流程分派定义表检索条件接口
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
public interface IG233SearchCond {

	/**
	 * 被分派节点id取得
	 * @return 被分派节点id
	 */
	public String getPsdid();
	
	/**
	 * 流程定义主键取得
	 * @return 流程定义主键
	 */
	public String getPdid();
}