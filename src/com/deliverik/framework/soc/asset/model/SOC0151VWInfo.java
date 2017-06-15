/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SOC0151VW接口
  * 功能描述: SOC0151VW接口
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
public interface SOC0151VWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 无意义主键取得
	 *
	 * @return 无意义主键
	 */
	public Integer getCcdid();

	/**
	 * 资产模型属性取值范围标识取得
	 *
	 * @return 资产模型属性取值范围标识
	 */
	public String getCcdcategory();

	/**
	 * 资产模型属性取值范围标识名称取得
	 *
	 * @return 资产模型属性取值范围标识名称
	 */
	public String getCcdlabel();

	/**
	 * 资产模型属性取值范围值取得
	 *
	 * @return 资产模型属性取值范围值
	 */
	public String getCcdvalue();

	/**
	 * 资产模型属性取值范围状态取得
	 *
	 * @return 资产模型属性取值范围状态
	 */
	public String getCcdstatus();

	/**
	 * 资产模型属性取值范围所属应用取得
	 *
	 * @return 资产模型属性取值范围所属应用
	 */
	public String getCcdtype();

	/**
	 * 资产模型属性取值范围预留字段取得
	 *
	 * @return 资产模型属性取值范围预留字段
	 */
	public String getCcdinfo();

}