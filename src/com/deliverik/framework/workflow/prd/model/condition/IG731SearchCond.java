/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.framework.workflow.prd.model.condition;

/**
 * 
 * 流程资产关系查询接口
 *
 */
public interface IG731SearchCond {
	
	/**
	*自增无意义主键
	*/
	public Integer getPieid();
	
	/**
	*流程ID(IG500表)
	*/
	public Integer getPrid();

	/**
	 * 流程表单主键取得
	 *
	 * @return piid 流程表单主键
	 */
	public Integer getPiid();
	
	/**
	*动态表单ID（IG007表）
	*/
	public Integer getPidid();

	/**
	*资产ID(EntityItem表)
	*/
	public Integer getEiid();
	
	/**
	 * 是否为表格类表单关联资产取得
	 * @return tableColumnValue 是否为表格类表单关联资产
	 */
	public String getTableColumnValue();
}
