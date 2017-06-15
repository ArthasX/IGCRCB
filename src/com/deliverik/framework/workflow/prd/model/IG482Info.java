/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程组关联关系定义表接口
  * 功能描述: 流程组关联关系定义表接口
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public interface IG482Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPgreid();

	/**
	 * 流程组id取得
	 *
	 * @return 流程组id
	 */
	public String getPgdid();

	/**
	 * 参考流程定义取得
	 *
	 * @return 参考流程定义
	 */
	public String getRpdid();

	/**
	 * 影响流程定义取得
	 *
	 * @return 影响流程定义
	 */
	public String getIpdid();

	/**
	 * 跃迁规则取得
	 *
	 * @return 跃迁规则
	 */
	public String getPgrerule();

	/**
	 * 参考流程状态取得
	 *
	 * @return 参考流程状态
	 */
	public String getRpsdid();
	
	/**
	 * 参考流程目的状态取得
	 * @return 参考流程目的状态
	 */
	public String getRtpsdid();

	/**
	 * 影响流程状态取得
	 *
	 * @return 影响流程状态
	 */
	public String getIpsdid();

	/**
	 * 传递特殊处理取得
	 *
	 * @return 传递特殊处理
	 */
	public String getTransferHandler();

}