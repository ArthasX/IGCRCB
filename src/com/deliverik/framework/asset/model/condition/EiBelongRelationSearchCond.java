/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 配置所属关系表检索条件接口
  * 功能描述: 配置所属关系表检索条件接口
  * 创建记录: 2011/04/20
  * 修改记录: 
  */
public interface EiBelongRelationSearchCond {
	/**
	 * 源资产ID取得
	 *
	 * @return 源资产ID
	 */
	public String getBrpareiid();
	/**
	 * 源资产大版本取得
	 *
	 * @return 源资产大版本
	 */
	public String getBrparversion();
	
	/**
	 * 源资产小版本取得
	 *
	 * @return 源资产小版本
	 */
	public String getBrparsmallversion();
	
	/**
	 * 逻辑删除标识取得
	 *
	 * @return 逻辑删除标识
	 */
	public String getDeleteflag();
	
	/**
	 * 目的资产ID取得
	 *
	 * @return 目的资产ID
	 */
	public String getBrcldeiid();
	
	/**
	 * 目的资产大版本取得
	 *
	 * @return 目的资产大版本
	 */
	public String getBrcldversion() ;
	
	/**
	 * 目的资产小版本取得
	 *
	 * @return 目的资产小版本
	 */
	public String getBrcldsmallversion();
	
	/**
	 * 资产所属树根节点实体标识取得
	 * @return 资产所属树根节点实体标识
	 */
	public String getEirootmark();
}