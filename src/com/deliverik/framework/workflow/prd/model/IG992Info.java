/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程外部调用定义表接口
  * 功能描述: 流程外部调用定义表接口
  * 创建记录: 2012/04/20
  * 修改记录: 
  */
public interface IG992Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPedid();

	/**
	 * 事件ID取得
	 *
	 * @return 事件ID
	 */
	public String getPedeventid();

	/**
	 * 调用BL取得
	 *
	 * @return 调用BL
	 */
	public String getPedaction();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPeddesc();

}