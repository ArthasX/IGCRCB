/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.deliverik.infogovernor.sdl.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.sdl.model.condition.IncidentKpiSearchCond;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_事件KPI查询Form
 * </p>
 * 
 * @author maozhipeng@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGSDL0701Form extends BaseForm implements IncidentKpiSearchCond{

	/**获取年度*/
	protected String kpiYear;
	
	/**获取月份*/
	protected String kpiMonth;
	
	/**开始时间*/
	protected String kpiOpenTime;
	
	/**结束时间*/
	protected String kpiEndTime;
	
	/**显示方式*/
	protected String radioValue;

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

	public String getKpiOpenTime() {
		return kpiOpenTime;
	}

	public void setKpiOpenTime(String kpiOpenTime) {
		this.kpiOpenTime = kpiOpenTime;
	}

	public String getKpiEndTime() {
		return kpiEndTime;
	}

	public void setKpiEndTime(String kpiEndTime) {
		this.kpiEndTime = kpiEndTime;
	}
	
	/**
	 * 获取结束时间
	 * @return 显示方式
	 */
	public String getRadioValue() {
		return radioValue;
	}

	/**
	 * 设置结束时间
	 * @param radioValue 显示方式
	 */
	public void setRadioValue(String radioValue) {
		this.radioValue = radioValue;
	}
}
