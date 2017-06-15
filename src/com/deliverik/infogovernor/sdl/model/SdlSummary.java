/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 服务管理_服务水平管理_服务水平标准信息MODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public interface SdlSummary {

	/**
	 * 获取月
	 * @return 月
	 */
	public abstract String getMonth();
	
	/**
	 * 获取月中断时间
	 * @return 月中断时间
	 */
	public abstract Integer getBreakm();

	/**
	 * 获取月连续时间百分比
	 * @return 月连续时间百分比
	 */
	public abstract Double getContinuousm();

	/**
	 * 获取月影响时间
	 * @return 月影响时间
	 */
	public abstract Integer getImpactm();

	/**
	 * 获取月稳定时间百分比
	 * @return 月稳定时间百分比
	 */
	public abstract Double getSteadym();

	/**
	 * 获取月安全事件个数
	 * @return 月安全事件个数
	 */
	public abstract Integer getSafecasem();

	/**
	 * 获取月安全事件评分
	 * @return 月安全事件评分
	 */
	public abstract Integer getSafemarkm();

	/**
	 * 获取月风险检查评分
	 * @return 月风险检查评分
	 */
	public abstract Integer getRiskmarkm();

	/**
	 * 获取月容量事件个数
	 * @return 月容量事件个数
	 */
	public abstract Integer getCapacitycasem();

	/**
	 * 获取月容量事件评分
	 * @return 月容量事件评分
	 */
	public abstract Integer getCapacitymarkm();

}