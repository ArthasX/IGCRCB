/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: SOC0151VW检索条件接口
  * 功能描述: SOC0151VW检索条件接口
  * 创建记录: 2016/06/23
  * 修改记录: 
  */
public interface SOC0151VWSearchCond {
	/**
	 * 资产属性取值范围标识取得
	 * @return 资产属性取值范围标识
	 */
	public String getCcdcategory();

	/**
	 * 资产属性取值范围状态取得
	 * @return 资产属性取值范围状态
	 */
	public String getCcdstatus();

	/**
	 * 资产属性取值范围所属应用取得
	 * @return 资产属性取值范围所属应用
	 */
	public String getCcdtype();
	
	/**
	 * @return the id
	 */
	public Integer getId();
}