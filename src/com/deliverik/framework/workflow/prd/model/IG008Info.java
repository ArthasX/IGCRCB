/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 人员表单角色限定接口
  * 功能描述: 人员表单角色限定接口
  * 创建记录: 2013/11/27
  * 修改记录: 
  */
public interface IG008Info extends BaseModel {

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
	 */
	public String getPidid();

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid();

	/**
	 * 角色名称取得
	 *
	 * @return 角色名称
	 */
	public String getRolename();

}