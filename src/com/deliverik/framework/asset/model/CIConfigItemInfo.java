/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CI变更资产属性表接口
  * 功能描述: CI变更资产属性表接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface CIConfigItemInfo extends BaseModel {

	/**
	 * 资产属性ID取得
	 *
	 * @return 资产属性ID
	 */
	public Integer getCiid();

	/**
	 * 资产模型属性ID取得
	 *
	 * @return 资产模型属性ID
	 */
	public Integer getCid();

	/**
	 * 资产ID取得
	 *
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public Integer getEid();

	/**
	 * 资产属性值取得
	 *
	 * @return 资产属性值
	 */
	public String getCivalue();

	/**
	 * 资产属性更新时间取得
	 *
	 * @return 资产属性更新时间
	 */
	public String getCiupdtime();

	/**
	 * 资产模型层次码取得
	 *
	 * @return 资产模型层次码
	 */
	public String getEsyscoding();

	/**
	 * 资产属性失效时间取得
	 *
	 * @return 资产属性失效时间
	 */
	public String getCiexpire();

	/**
	 * 资产属性状态取得
	 *
	 * @return 资产属性状态
	 */
	public String getCistatus();

	/**
	 * 资产属性当前版本号取得
	 *
	 * @return 资产属性当前版本号
	 */
	public String getCicurver();

	/**
	 * 资产属性版本信息取得
	 *
	 * @return 资产属性版本信息
	 */
	public String getCiverinfo();

	/**
	 * 大版本取得
	 * @return 大版本
	 */
	public Integer getCiversion();

	/**
	 * 小版本取得
	 * @return 小版本
	 */
	public Integer getCismallversion();

}