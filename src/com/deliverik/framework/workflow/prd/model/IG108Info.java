/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;

/**
  * 概述: 自定义流程表单查询条件定义表接口
  * 功能描述: 自定义流程表单查询条件定义表接口
  * 创建记录: 2013/03/13
  * 修改记录: 
  */
public interface IG108Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPqid();

	/**
	 * 流程类型主键取得
	 *
	 * @return 流程类型主键
	 */
	public String getPdid();

	/**
	 * 表单定义主键取得
	 *
	 * @return 表单定义主键
	 */
	public String getPidid();
	
	/**
	 * 表单定义信息取得
	 * @return 表单定义信息
	 */
	public IG007TB getPidTB();

}