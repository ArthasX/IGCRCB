/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SOC0117VW接口
  * 功能描述: SOC0117VW接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0117VWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 资产类型id取得
	 *
	 * @return 资产类型id
	 */
	public String getEid();

	/**
	 * 资产类型名称取得
	 *
	 * @return 资产类型名称
	 */
	public String getEname();

	/**
	 * 系统预置模型标识取得
	 *
	 * @return 系统预置模型标识
	 */
	public String getElabel();

	/**
	 * 资产模型的说明取得
	 *
	 * @return 资产模型的说明
	 */
	public String getEdesc();

	/**
	 * 资产模型状态取得
	 *
	 * @return 资产模型状态
	 */
	public String getEstatus();

	/**
	 * 资产模型的分类取得
	 *
	 * @return 资产模型的分类
	 */
	public String getEcategory();

	/**
	 * 资产模型一级子类取得
	 *
	 * @return 资产模型一级子类
	 */
	public String getEkey1();

	/**
	 * 资产模型二级子类取得
	 *
	 * @return 资产模型二级子类
	 */
	public String getEkey2();

	/**
	 * 资产模型三级子类取得
	 *
	 * @return 资产模型三级子类
	 */
	public String getEkey3();

	/**
	 * 资产模型的层次码取得
	 *
	 * @return 资产模型的层次码
	 */
	public String getEsyscoding();

	/**
	 * 资产模型的上级模型层次码取得
	 *
	 * @return 资产模型的上级模型层次码
	 */
	public String getEparcoding();

	/**
	 * 资产模型类别取得
	 * @return 资产模型类别
	 */
	public String getEmodeltype();

}