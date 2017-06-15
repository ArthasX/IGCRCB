/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.kgm.model.condition;

/**
 * 
 * 流程资产关系查询接口
 *
 */
public interface ProcessInfoEntityKnSearchCond {
	
	/**
	*自增无意义主键
	*/
	public Integer getPiekid();
	
	/**
	*流程ID(Ig500Kn表)
	*/
	public Integer getPrkid();

	/**
	*动态表单ID（IG007表）
	*/
	public Integer getPidid();

	/**
	*资产ID(EntityItem表)
	*/
	public Integer getEiid();
}
