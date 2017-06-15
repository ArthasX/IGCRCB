/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.resultset;

import java.util.List;

/**
 * 资产信息
 */
public interface EntityItemInfo {
	
	/**
	 * 资产ID取得
	 * @return 资产ID
	 */
	public Integer getEiid();

	/**
	 * 资产名称取得
	 * 
	 * @return 资产名称
	 */
	public String getEiname();

	/**
	 * 资产编号取得
	 * 
	 * @return 资产编号
	 */
	public String getEilabel();

	/**
	 * 资产所属机构层次码取得
	 * 
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();

	/**
	 * 资产所属模型层次码取得
	 * 
	 * @return 资产所属模型层次码
	 */
	public String getEsyscoding();

	/**
	 * 资产管理人ID取得
	 * 
	 * @return 资产管理人ID
	 */
	public String getEiuserid();

	/**
	 * 资产管理人姓名取得
	 * 
	 * @return 资产管理人姓名
	 */
	public String getEiusername();

	/**
	 * 资产版本取得
	 * @return 资产版本
	 */
	public Integer getEiversion();
	
	/**
	 * 资产小版本取得
	 * @return 资产小版本
	 */
	public Integer getEismallversion();

	/**
	 * 资产属性信息列表取得
	 * 
	 * @return 资产属性信息列表
	 */
	public List<ConfigItemInfo> getConfigItems();

}