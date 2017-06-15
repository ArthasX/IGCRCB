/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model;

import com.deliverik.framework.base.BaseModel;

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

public interface SdlDefineInfo  extends BaseModel {
	
	/**
	 * 获取主键
	 * @return 主键
	 */
	public abstract Integer getSdiid();

	/**
	 * 获取年度
	 * @return 年度
	 */
	public abstract String getSdiyear();

	/**
	 * 获取相关资产ID
	 * @return 相关资产ID
	 */
	public abstract Integer getSdieiid();

	/**
	 * 获取资产名称
	 * @return 资产名称
	 */
	public abstract String getSdieiname();

	/**
	 * 获取月中断时间
	 * @return 月中断时间
	 */
	public abstract Integer getSdibreakm();

	/**
	 * 获取年中断时间
	 * @return 年中断时间
	 */
	public abstract Integer getSdibreaky();

	/**
	 * 获取月连续时间百分比
	 * @return 月连续时间百分比
	 */
	public abstract Double getSdicontinuousm();

	/**
	 * 获取年连续时间百分比
	 * @return 年连续时间百分比
	 */
	public abstract Double getSdicontinuousy();

	/**
	 * 获取月影响时间
	 * @return 月影响时间
	 */
	public abstract Integer getSdiimpactm();

	/**
	 * 获取年影响时间
	 * @return 年影响时间
	 */
	public abstract Integer getSdiimpacty();

	/**
	 * 获取月稳定时间百分比
	 * @return 月稳定时间百分比
	 */
	public abstract Double getSdisteadym();

	/**
	 * 获取年稳定时间百分比
	 * @return 年稳定时间百分比
	 */
	public abstract Double getSdisteadyy();

	/**
	 * 获取月安全事件个数
	 * @return 月安全事件个数
	 */
	public abstract Integer getSdisafecasem();

	/**
	 * 获取年安全事件个数
	 * @return 年安全事件个数
	 */
	public abstract Integer getSdisafecasey();

	/**
	 * 获取月安全事件评分
	 * @return 月安全事件评分
	 */
	public abstract Integer getSdisafemarkm();

	/**
	 * 获取年安全事件评分
	 * @return 年安全事件评分
	 */
	public abstract Integer getSdisafemarky();

	/**
	 * 获取月风险检查评分
	 * @return 月风险检查评分
	 */
	public abstract Integer getSdiriskmarkm();

	/**
	 * 获取年风险检查评分
	 * @return 年风险检查评分
	 */
	public abstract Integer getSdiriskmarky();

	/**
	 * 获取月容量事件个数
	 * @return 月容量事件个数
	 */
	public abstract Integer getSdicapacitycasem();

	/**
	 * 获取年容量事件个数
	 * @return 年容量事件个数
	 */
	public abstract Integer getSdicapacitycasey();

	/**
	 * 获取月容量事件评分
	 * @return 月容量事件评分
	 */
	public abstract Integer getSdicapacitymarkm();

	/**
	 * 获取年容量事件评分
	 * @return 年容量事件评分
	 */
	public abstract Integer getSdicapacitymarky();
}