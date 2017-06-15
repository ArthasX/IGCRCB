/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 自定义流程机构范围表接口
  * 功能描述: 自定义流程机构范围表接口
  * 创建记录: 2013/03/07
  * 修改记录: 
  */
public interface IG123Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPotdid();

	/**
	 * 流程类型主键取得
	 *
	 * @return 流程类型主键
	 */
	public String getPdid();

	/**
	 * 机构码取得
	 *
	 * @return 机构码
	 */
	public String getOrgid();

	/**
	 * 机构名称取得
	 *
	 * @return 机构名称
	 */
	public String getOrgname();

}