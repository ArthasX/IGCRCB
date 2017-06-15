/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 缺省状态参与者关联流程类型定义表接口
  * 功能描述: 缺省状态参与者关联流程类型定义表接口
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
public interface IG931Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getDpsprpid();

	/**
	 * 流程定义id取得
	 *
	 * @return 流程定义id
	 */
	public String getPdid();

	/**
	 * 流程状态id取得
	 *
	 * @return 流程状态id
	 */
	public String getPsdid();

	/**
	 * 关联的流程定义id取得
	 *
	 * @return 关联的流程定义id
	 */
	public String getRelevantPdid();

}