/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;

/**
 * 概述: 资产域定义表检索条件接口 功能描述: 资产域定义表检索条件接口 创建记录: 2011/04/20 修改记录:
 * <tr>
 * <td>name</td>
 * <td>资产域定义名称</td>
 * </tr>
 * <tr>
 * <td>createtime_from</td>
 * <td>资产域定义登记开始时间（大于等于）</td>
 * </tr>
 * <tr>
 * <td>createtime_to</td>
 * <td>资产域定义登记截止时间（小于等于）</td>
 * </tr>
 */
public interface SOC0111SearchCond {
	/**
	 * 资产域定义名称取得
	 */
	public String getName_like();
	
	/**
	 * 资产域定义开始时间
	 */
	public String getCreatetime_from();

	/**
	 * 资产域定义截止时间
	 */
	public String getCreatetime_to();
	
	/**
	 * 域定义ID取得
	 * 
	 * @return 域定义ID
	 */
	public String getEiddid_eq();
	
	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public Integer getEiddid();
	
	/**
	 * 版本号取得
	 * 
	 * @return 版本号
	 */
	public Integer getVersion();

}