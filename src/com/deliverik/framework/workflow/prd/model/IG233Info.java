/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 自定义流程分派定义表接口
  * 功能描述: 自定义流程分派定义表接口
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
public interface IG233Info extends BaseModel {

	/**
	 * 被分派节点主键取得
	 *
	 * @return 被分派节点主键
	 */
	public String getPsdid();

	/**
	 * 分派节点主键取得
	 *
	 * @return 分派节点主键
	 */
	public String getAssignpsdid();

	/**
	 * 分派按钮主键取得
	 *
	 * @return 分派按钮主键
	 */
	public String getAssignpbdid();

	/**
	 * 是否必须分派标识取得
	 *
	 * @return 是否必须分派标识
	 */
	public String getAssignflag();

}