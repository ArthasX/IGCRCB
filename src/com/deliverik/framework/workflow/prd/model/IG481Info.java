/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程组成员表接口
  * 功能描述: 流程组成员表接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG481Info extends BaseModel {

	/**
	 * 流程组id取得
	 *
	 * @return 流程组id
	 */
	public String getPgdid();

	/**
	 * 单体流程id取得
	 *
	 * @return 单体流程id
	 */
	public String getPdid();

	/**
	 * 发起方式取得
	 *
	 * @return 发起方式
	 */
	public String getCreateType();

	/**
	 * 流程版本取得
	 *
	 * @return 流程版本
	 */
	public String getPdversion();

}