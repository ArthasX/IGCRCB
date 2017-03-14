/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: OA角色配置表接口
  * 功能描述: OA角色配置表接口
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public interface IG001Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getProid();

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getProtype();

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getProroleid();

	/**
	 * 角色名称取得
	 *
	 * @return 角色名称
	 */
	public String getProrolename();

}