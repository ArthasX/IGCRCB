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
 * Description: 服务管理_统计汇总_事件kpi信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
public interface IncidentKpiSearchCond {
	/**
	 * 获取年度
	 * @return 年度
	 */
	public String getKpiYear();
	
	/**
	 * 获取月份
	 * @return 月份
	 */
	public String getKpiMonth();
	
	/**
	 * 获取开始时间
	 * @return 开始时间
	 */
	public String getKpiOpenTime();
	
	/**
	 * 获取结束时间
	 * @return 结束时间
	 */
	public String getKpiEndTime();
	
	/**
	 * 获取显示方式
	 * @return 显示方式
	 */
	public String getRadioValue();

}
