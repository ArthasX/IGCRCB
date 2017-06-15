/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程查看角色配置表接口
  * 功能描述: 流程查看角色配置表接口
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public interface IG700Info extends BaseModel {

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid();

}