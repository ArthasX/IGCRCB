/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.soc.asset.model.condition;

/**
 * 概述: 资产域明细表检索条件接口
 * 功能描述: 资产域明细表检索条件接口
 * 创建记录: 2011/05/25
 * 修改记录: 
 */
public interface SOC0126SearchCond {
	
	
	/**获取资产域ID**/
	public String getEiddid();
	
	/**
	 * 查询类型取得
	 * @return 查询类型
	 */
	public String getTypeId();
	
	/** 影响CI */
	public String getEilabel();
	
	/**获取资产域版本**/
	public String getEiddversion();
	
	public String getEiname();
	
	public String getEiid();
	
	
}
