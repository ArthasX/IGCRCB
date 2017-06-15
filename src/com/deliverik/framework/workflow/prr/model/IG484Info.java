/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程组成员实例接口
  * 功能描述: 流程组成员实例接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG484Info extends BaseModel {

	/**
	 * 流程实例ID取得
	 *
	 * @return 流程实例ID
	 */
	public Integer getPrid();

	/**
	 * 流程组实例ID取得
	 *
	 * @return 流程组实例ID
	 */
	public Integer getPgrid();
	
	/**
	 * 流程定义ID取得
	 * @return 流程定义ID
	 */
	public String getPdid();

}