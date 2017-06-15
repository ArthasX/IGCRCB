/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.condition;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_统计汇总_变更kpi信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public class ChangeKpiSearchCondImpl implements ChangeKpiSearchCond{
	
	/**获取年度*/
	protected String kpiYear;
	
	/**获取月份*/
	protected String kpiMonth;
	
	/**开始时间*/
	protected String kpiOpenTime;
	
	/**结束时间*/
	protected String kpiEndTime;

	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getKpiYear() {
		return kpiYear;
	}

	/**
	 * 设置月份
	 * @param kpiMonth 月份
	 */
	public void setKpiYear(String kpiYear) {
		this.kpiYear = kpiYear;
	}

	/**
	 * 获取月份
	 * @return 月份
	 */
	public String getKpiMonth() {
		return kpiMonth;
	}

	/**
	 * 设置年度
	 * @param kpiYear 年度
	 */
	public void setKpiMonth(String kpiMonth) {
		this.kpiMonth = kpiMonth;
	}

	/**
	 * 获取开始时间
	 * @return 开始时间
	 */
	public String getKpiOpenTime() {
		return kpiOpenTime;
	}

	/**
	 * 设置开始时间
	 * @param kpiOpenTime 开始时间
	 */
	public void setKpiOpenTime(String kpiOpenTime) {
		this.kpiOpenTime = kpiOpenTime;
	}

	/**
	 * 获取结束时间
	 * @return 结束时间
	 */
	public String getKpiEndTime() {
		return kpiEndTime;
	}

	/**
	 * 设置结束时间
	 * @param kpiEndTime 结束时间
	 */
	public void setKpiEndTime(String kpiEndTime) {
		this.kpiEndTime = kpiEndTime;
	}
	
}
