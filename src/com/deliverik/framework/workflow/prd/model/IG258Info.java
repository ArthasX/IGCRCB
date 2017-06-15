/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程状态参与者调整接口
  * 功能描述: 流程状态参与者调整接口
  * 创建记录: 2012/05/09
  * 修改记录: 
  */
public interface IG258Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPspcdid();

	/**
	 * 当前状态ID取得
	 *
	 * @return 当前状态ID
	 */
	public String getPsdid();

	/**
	 * 可改变状态id取得
	 *
	 * @return 可改变状态id
	 */
	public String getPspcdpsdid();

}