/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 流程状态级私有表单默认值表接口
  * 功能描述: 流程状态级私有表单默认值表接口
  * 创建记录: 2015/02/07
  * 修改记录: 
  */
public interface IG560VWInfo extends BaseModel {

	/**
	 * dvid取得
	 *
	 * @return dvid
	 */
	public Integer getDvid();

	/**
	 * 表单id取得
	 *
	 * @return 表单id
	 */
	public String getPidid();

	/**
	 * 状态id取得
	 *
	 * @return 状态id
	 */
	public String getPsdid();

	/**
	 * 默认值取得
	 *
	 * @return 默认值
	 */
	public String getDfvalue();

	/**
	 * 是否应用到整个流程T/F取得
	 *
	 * @return 是否应用到整个流程T/F
	 */
	public String getUsedtoall();
	
	public String getPidname();
	public String getPidoption();
	public String getPidtype();
	

}