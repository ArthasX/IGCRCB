/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程组关联关系定义表检索条件接口
  * 功能描述: 流程组关联关系定义表检索条件接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG482SearchCond {

	/**
	 * 流程组定义ID取得
	 * @return 流程组定义ID
	 */
	public String getPgdid();

	/**
	 * 参考流程定义ID取得
	 * @return 参考流程定义ID
	 */
	public String getRpdid();

	/**
	 * 参考流程状态ID取得
	 * @return 参考流程状态ID
	 */
	public String getRpsdid();

}