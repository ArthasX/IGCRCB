/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * 值班日报查询条件接口
 */
public interface DutyResultVWSearchCond {
	
	/**
	 * 检查项ID取得
	 * @return 检查项ID
	 */
	public Integer getDadid();



	/**
	 * 值班日报ID取得
	 * @return 值班日报ID
	 */
	public Integer getDrid();


	/**
	 * 值班计划ID取得
	 * @return 值班计划ID
	 */
	public Integer getDpid();
	

	/**
	 * 检查分类取得
	 * @return 检查分类
	 */
	public String getDadtype();



	/**
	 * 检查名称取得
	 * @return 检查名称
	 */
	public String getDadname();



	/**
	 * 检查时间取得
	 * @return 检查时间
	 */
	public String getDattime();



	/**
	 * 填报时间限制取得
	 * @return 填报时间限制
	 */
	public String getDatlimtime();



	/**
	 * 检查结果类型取得
	 * @return 检查结果类型
	 */
	public String getDadcontent();



	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDadinfo();


	/**
	 * 使用状态取得
	 * @return 使用状态
	 */
	public String getDadstatus();



	/**
	 * 检查结果取得
	 * @return 检查结果
	 */
	public String getDrcontent();



	/**
	 * 实际填报时间取得
	 * @return 实际填报时间
	 */
	public String getDrfilltime();



	/**
	 * 结果说明取得
	 * @return 结果说明
	 */
	public String getDrresult();
	
	/**
	 * 值班类型取得
	 * @return 值班类型
	 */
	public String getDadcategory();
	
	/**
	 * 检查时间(从)取得
	 * @return 检查时间从
	 */
	public String getDattime_form();
	
	/**
	 * 检查时间(到)取得
	 * @return 检查时间(到)
	 */
	public String getDattime_to();
	
	/**
	 * 检查时间查询条件取得
	 * @return 检查时间查询条件
	 */
	public String getDattime_q();
}
