/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;

/**
  * 概述: 配置所属关系视图接口
  * 功能描述: 配置所属关系视图接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface SOC0127Info {

	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public Integer getBrpareiid();

	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public Integer getBrparversion();

	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public Integer getBrparsmallversion();

	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public Integer getBrcldeiid();

	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public Integer getBrcldversion();

	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public Integer getBrcldsmallversion();

	/**
	 * 源资产取得
	 *
	 * @return 源资产
	 */
	public SOC0123VW getParEntityItemVW();
	
	/**
	 * 目的资产取得
	 *
	 * @return 目的资产
	 */
	public SOC0123VW getCldEntityItemVW();
	
}