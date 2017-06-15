/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: compareTemplate接口
  * 功能描述: compareTemplate接口
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public interface CompareTemplateInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCtpid();

	/**
	 * 类别ID取得
	 *
	 * @return 类别ID
	 */
	public String getCtcategory();

	/**
	 * 类型取得
	 *
	 * @return 类型
	 */
	public String getCttype();

	/**
	 * 横向宽度取得
	 *
	 * @return 横向宽度
	 */
	public String getCtxwidth();

	/**
	 * 纵向宽度取得
	 *
	 * @return 纵向宽度
	 */
	public String getCtywidth();

	/**
	 * 值取得
	 *
	 * @return 值
	 */
	public String getCtvalue();

}