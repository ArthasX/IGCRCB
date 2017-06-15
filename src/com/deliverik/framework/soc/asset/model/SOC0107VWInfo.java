/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SOC0107VW接口
  * 功能描述: SOC0107VW接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0107VWInfo extends BaseModel {

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
	public Integer getCiid();

	/**
	 * 资产模型属性ID（外键）取得
	 *
	 * @return 资产模型属性ID（外键）
	 */
	public String getCid();

	/**
	 * 资产ID（外键）取得
	 *
	 * @return 资产ID（外键）
	 */
	public Integer getEiid();

	/**
	 * 资产模型ID取得
	 *
	 * @return 资产模型ID
	 */
	public String getEid();

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
	 * 资产属性版本号取得
	 *
	 * @return 资产属性版本号
	 */
	public String getCiversion();

	/**
	 * 资产属性版本信息取得
	 *
	 * @return 资产属性版本信息
	 */
	public String getCiverinfo();
	/**
	 * 资产模型属性信息取得
	 * @return 资产模型属性信息
	 */
	public SOC0109VWInfo getConfiguration();
}