/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.pdf.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 报表字段与流程公有表单值映射关系视图接口
  * 功能描述: 报表字段与流程公有表单值映射关系视图接口
  * 创建记录: 2013/07/31
  * 修改记录: 
  */
public interface PdfIg599MapVWInfo extends BaseModel {

	/**
	 * 流程ID取得
	 *
	 * @return 流程ID
	 */
	public Integer getPrid();

	/**
	 * 表单定义ID取得
	 *
	 * @return 表单定义ID
	 */
	public String getPidid();

	/**
	 * 表单值取得
	 *
	 * @return 表单值
	 */
	public String getPivarvalue();

	/**
	 * 表单定义名称取得
	 *
	 * @return 表单定义名称
	 */
	public String getPivarname();

	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();

	/**
	 * 报表字段名称取得
	 *
	 * @return 报表字段名称
	 */
	public String getPdfpidname();

	/**
	 * 表单父绑定信息取得
	 *
	 * @return 表单父绑定信息
	 */
	public String getPdatabinding();

	/**
	 * 表单绑定信息取得
	 *
	 * @return 表单绑定信息
	 */
	public String getDatabinding();

	/**
	 * 表单类型取得
	 *
	 * @return 表单类型
	 */
	public String getFormtype();

}