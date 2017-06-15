/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 值班检查信息查询条件接口
 */
public interface DutyAuditDefSearchCond {

	
	/**
	 * 检查分类
	 */
	public String getDadtype();

	/**
	 * 检查名称
	 */
	public String getDadname();
	
	/**
	 * 值班类型
	 */
	public String getDadcategory();

}
