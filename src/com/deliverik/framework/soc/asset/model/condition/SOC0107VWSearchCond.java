/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: SOC0107VW检索条件接口
  * 功能描述: SOC0107VW检索条件接口
  * 创建记录: 2016/06/21
  * 修改记录: 
  */
public interface SOC0107VWSearchCond {
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public String getEiid();
	
	/**
	 * 资产模型ID取得
	 * @return 资产模型ID
	 */
	public String getEid();

	/**
	 * 资产属性大版本号取得
	 * @return 资产属性大版本号
	 */
	public String getCiversion();
	
	/**
	 * 资产模型属性ID取得
	 * @return 资产模型属性ID
	 */
	public String getCid();
	
	/**
	 * 资产模型属性值取得
	 * @return 资产模型属性值
	 */
	public String getCivalue();
	
	/**
	 * 资产属性小版本号取得
	 * @return 资产属性小版本号
	 */
	public String getCismallversion();
	
	public String[] getCids();
	/**
	 * @return the id
	 */
	public Integer getId();
}