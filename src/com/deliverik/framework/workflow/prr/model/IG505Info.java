/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程表单值表接口
  * 功能描述: 流程表单值表接口
  * 创建记录: 2013/08/28
  * 修改记录: 
  */
public interface IG505Info extends BaseModel {


	/**
	 * 主键取得
	 * @return piprrid 主键
	 */
	public Integer getPiprrid();

	/**
	 * 流程主键取得
	 * @return prid 流程主键
	 */
	public Integer getPrid();

	/**
	 * piprid取得
	 * @return piprid piprid
	 */
	public Integer getPiprid();

	/**
	 * 流程类型取得
	 * @return piprtype 流程类型
	 */
	public String getPiprtype();

	/**
	 * 流程名称取得
	 * @return piprtitle 流程名称
	 */
	public String getPiprtitle();

}