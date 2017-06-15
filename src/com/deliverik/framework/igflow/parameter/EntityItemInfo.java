/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.igflow.parameter;

import java.util.List;

/**
 * 资产相关信息
 */
public interface EntityItemInfo {

	/**
	 * 资产名称取得
	 * @return 资产名称
	 */
	public String getEiname();
	
	/**
	 * 资产说明取得
	 * @return 资产说明
	 */
	public String getEidesc();
	
	/**
	 * 资产编号取得
	 * @return 资产编号
	 */
	public String getEilabel();
	
	/**
	 * 资产所属机构层次码取得
	 * @return 资产所属机构层次码
	 */
	public String getEiorgsyscoding();
	
	/**
	 * 资产所属模型层次码取得
	 * @return 资产所属模型层次码
	 */
	public String getEsyscoding();
	
	/**
	 * 资产管理人ID取得
	 * @return 资产管理人ID
	 */
	public String getEiuserid();
	
	/**
	 * 资产管理人姓名取得
	 * @return 资产管理人姓名
	 */
	public String getEiusername();
	
	/**
	 * 资产状态取得
	 * @return 资产状态
	 */
	public String getEistatus();
	
	/**
	 * 时间戳取得
	 * @return 时间戳
	 */
	public String getFingerPrint();
	
	/**
	 * 资产配置属性信息取得
	 * @return 资产配置属性信息
	 */
	public List<EntityItemConfigValueInfo> getConfigItems();
	
	/**
	 * 检查项登记日取得
	 * @return eiinsdate  检查项登记日
	 */
	public String getEiinsdate();
}
