/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
  * 概述: 实体链路图检索条件接口
  * 功能描述: 实体链路图检索条件接口
  * 创建记录: 2011/05/24
  * 修改记录: 
  */
public interface SOC0114SearchCond {
	
	/**
	 * 域ID取得
	 * 
	 * @return 域ID
	 */
	public Integer getDomainid_eq();

	/**
	 * 域版本取得
	 * 
	 * @return 域版本
	 */
	public Integer getDomainversion_eq();

	/**
	 * 资产ID取得
	 * 
	 * @return 资产ID
	 */
	public Integer getEiid_eq();

	/**
	 * 创建时间取得
	 * 
	 * @return 创建时间
	 */
	public String getCreatetime_eq();
	
	/**
	 * 绘图标记取得
	 * 
	 * @return 绘图标记
	 */
	public String getLinkflag_eq();
	
	/**
	 * 资产层次码取得
	 *
	 * @return 资产层次码
	 */
	public String getEsyscoding_eq();

}