/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 资产模型属性缺省值接口
  * 功能描述: 资产模型属性缺省值接口
  * 创建记录: 2012/07/20
  * 修改记录: 
  */
public interface IG611Info extends BaseModel {

	/**
	 * 模型ID取得
	 *
	 * @return 模型ID
	 */
	public Integer getEid();

	/**
	 * 属性ID取得
	 *
	 * @return 属性ID
	 */
	public Integer getCid();

	/**
	 * 属性值取得
	 *
	 * @return 属性值
	 */
	public String getCvalue();

}