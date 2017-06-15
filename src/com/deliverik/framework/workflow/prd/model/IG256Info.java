/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程策略提醒接口
  * 功能描述: 流程策略提醒接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG256Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getFnid();

	/**
	 * 流程表主键取得
	 *
	 * @return 流程表主键
	 */
	public Integer getPrid();

	/**
	 * 流程类型表主键取得
	 *
	 * @return 流程类型表主键
	 */
	public String getPdid();

	/**
	 * 流程记录状态取得
	 *
	 * @return 流程记录状态
	 */
	public String getPrstatus();

	/**
	 * 当前流程参与人id取得
	 *
	 * @return 当前流程参与人id
	 */
	public String getPpuserid();
	
	/**
	 * 当前流程参与人名称取得
	 *
	 * @return 当前流程参与人名称
	 */
	public String getPpusername();

	/**
	 * 标识取得
	 *
	 * @return 标识
	 */
	public String getFlag();

}