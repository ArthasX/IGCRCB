/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.scheduling.model.condition;

/**
 * 
 * 流程资产关系查询接口
 *
 */
public interface QuartzProcessInfoEntitySearchCond {
	
	/**
	*自增无意义主键
	*/
	public Integer getQpieid();
	
	/**
	*流程ID(QuartzProcessRecord表)
	*/
	public Integer getQprid();

	/**
	*动态表单ID（QuartzProcessInfoDef表）
	*/
	public Integer getQpiid();

	/**
	*资产ID(EntityItem表)
	*/
	public Integer getQeiid();
}
