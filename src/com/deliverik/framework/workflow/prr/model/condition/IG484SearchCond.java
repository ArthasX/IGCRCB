/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程组成员实例检索条件接口
  * 功能描述: 流程组成员实例检索条件接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG484SearchCond {

	/**
	 * 流程组ID取得
	 * @return 流程组ID
	 */
	public Integer getPgrid();
	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public Integer getPrid();

}