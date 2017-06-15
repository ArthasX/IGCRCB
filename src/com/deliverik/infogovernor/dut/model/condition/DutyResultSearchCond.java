/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 值班检查内容查询条件接口
 */
public interface DutyResultSearchCond {
	
	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid();
	
	/**
	 * 值班检查项ID取得
	 * @return 值班检查项ID
	 */
	public Integer getDadid();
	
	/**
	 * 情况汇总值班日期取得
	 * @return 情况汇总值班日期
	 */
	public String getDptime();
	
	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname();
	
	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public String getDopentime();
	
	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public String getDclosetime();
	
	/**
	 * 检查结果（空匹配）取得
	 * @return 检查结果（空匹配）
	 */
	public String getIsNullDrcontent();

	public String getDptime_ge();
	public String getDptime_le();
	public String getDadcategory();
	public String getDattime();
}
