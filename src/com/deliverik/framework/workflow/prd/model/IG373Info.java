/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程表单初始化事件定义表接口
  * 功能描述: 流程表单初始化事件定义表接口
  * 创建记录: 2012/07/03
  * 修改记录: 
  */
public interface IG373Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPiidid();

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid();

	/**
	 * BL名称取得
	 *
	 * @return BL名称
	 */
	public String getPiidblid();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPiiddec();
	
	/**
	 * 流程状态信息取得
	 * 
	 * @return 流程状态信息
	 */
	public IG333Info getIg333Info();

}