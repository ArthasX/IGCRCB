/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: PDF报表与流程表单映射表接口
  * 功能描述: PDF报表与流程表单映射表接口
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public interface PdfFieldMapInfo extends BaseModel {

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 流程表单定义ID取得
	 *
	 * @return 流程表单定义ID
	 */
	public String getPidid();

	/**
	 * 流程表单名称取得
	 *
	 * @return 流程表单名称
	 */
	public String getPidname();

	/**
	 * 父绑定名称取得
	 *
	 * @return 父绑定名称
	 */
	public String getPdatabinding();

	/**
	 * 绑定名称取得
	 *
	 * @return 绑定名称
	 */
	public String getDatabinding();

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getFormtype();

}