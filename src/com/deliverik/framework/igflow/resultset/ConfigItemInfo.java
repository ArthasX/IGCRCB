/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.igflow.resultset;

/**
 * 资产属性信息
 */
public interface ConfigItemInfo {
	
	/**
	 * 资产属性ID取得
	 * 
	 * @return 资产属性ID
	 */
	public Integer getCiid();
	
	/**
	 * 资产属性定义ID取得
	 * 
	 * @return 资产属性定义ID
	 */
	public String getCid();

	/**
	 * 资产属性名称取得
	 * 
	 * @return 资产属性名称
	 */
	public String getName();

	/**
	 * 资产属性值取得
	 * 
	 * @return 资产属性值
	 */
	public String getValue();

}
