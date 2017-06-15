/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;

/**
  * 概述: 流程查看角色授权表单表接口
  * 功能描述: 流程查看角色授权表单表接口
  * 创建记录: 2012/10/15
  * 修改记录: 
  */
public interface IG701Info extends BaseModel {

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

	/**
	 * 表单ID取得
	 *
	 * @return 表单ID
	 */
	public String getPidid();
	
	/**
	 * 表单信息取得
	 * @return 表单信息
	 */
	public IG007TB getProcessInfoDef();

}