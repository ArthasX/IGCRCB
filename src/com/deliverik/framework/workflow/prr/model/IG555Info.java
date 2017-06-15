/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程处理页返回配置信息接口
  * 功能描述: 流程处理页返回配置信息接口
  * 创建记录: 2013/08/29
  * 修改记录: 
  */
public interface IG555Info extends BaseModel {

	/**
	 * 标识取得
	 *
	 * @return 标识
	 */
	public String getJump();

	/**
	 * 返回路径取得
	 *
	 * @return 返回路径
	 */
	public String getUrl();

	/**
	 * 说明取得
	 * @return 说明
	 */
	public String getDescription();

}