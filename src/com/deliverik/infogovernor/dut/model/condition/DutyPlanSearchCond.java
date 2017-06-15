/*
 * 北京递蓝科软件技术有限公司版权所有,保留所有权利.
 */
package com.deliverik.infogovernor.dut.model.condition;
/**
 * 
 * 值班计划查询接口
 *
 */
public interface DutyPlanSearchCond {
	
	/**
	 * 值班计划状态取得
	 * @return 值班计划状态
	 */
	public String getDpstatus();
	
	/**
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDadcategory();
	
	/**
	 * 值班日期取得
	 * @return 值班日期
	 */
	public String getDptime();
	
	/**
	 * 值班日期（大于等于匹配）取得
	 * @return 值班日期（大于等于匹配）
	 */
	public String getDptime_ge();
	
	/**
	 * 值班日期（小于等于匹配）取得
	 * @return 值班日期（小于等于匹配）
	 */
	public String getDptime_le();

	/**
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDptype();
	
	/**
	 * 值班计划表主键取得
	 *
	 * @return dpid 值班计划表主键
	 */
	public Integer getDpid();
}
