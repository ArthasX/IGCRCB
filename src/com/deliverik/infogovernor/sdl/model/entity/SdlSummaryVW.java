/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.sdl.model.SdlSummary;


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
@SuppressWarnings("serial")
@Entity
//public class SdlSummaryVW extends BaseEntity implements Serializable, Cloneable, SdlSummary {
public class SdlSummaryVW implements Serializable, Cloneable, SdlSummary {

	@Id
	/**月 */
	protected String month;
	
	/**月中断时间 */
	protected Integer breakm;

	@Transient
	/** 月连续时间百分比*/
	protected Double continuousm;

	/**月影响时间*/
	protected Integer impactm;

	@Transient
	/** 月稳定时间百分比*/
	protected Double steadym;
	
	/**月安全事件个数*/
	protected Integer safecasem;
	
	/**月安全事件评分*/
	protected Integer safemarkm;
	
	/** 月风险检查评分*/
	protected Integer riskmarkm;
	
	/**月容量事件个数 */
	protected Integer capacitycasem;
	
	/**月容量事件评分*/
	protected Integer capacitymarkm;
	
	/**
	 * 获取月中断时间
	 * @return 月中断时间
	 */
	public Integer getBreakm() {
		return breakm;
	}

	/**
	 * 设置月中断时间
	 * @param breakm 月中断时间
	 */
	public void setBreakm(Integer breakm) {
		this.breakm = breakm;
	}

	/**
	 * 获取月连续时间百分比
	 * @return 月连续时间百分比
	 */
	public Double getContinuousm() {
		return continuousm;
	}

	/**
	 * 设置月连续时间百分比
	 * @param continuousm 月连续时间百分比
	 */
	public void setContinuousm(Double continuousm) {
		this.continuousm = continuousm;
	}

	/**
	 * 获取月影响时间
	 * @return 月影响时间
	 */
	public Integer getImpactm() {
		return impactm;
	}

	/**
	 * 设置月影响时间
	 * @param impactm 月影响时间
	 */
	public void setImpactm(Integer impactm) {
		this.impactm = impactm;
	}

	/**
	 * 获取月稳定时间百分比
	 * @return 月稳定时间百分比
	 */
	public Double getSteadym() {
		return steadym;
	}

	/**
	 * 设置月稳定时间百分比
	 * @param steadym 月稳定时间百分比
	 */
	public void setSteadym(Double steadym) {
		this.steadym = steadym;
	}

	/**
	 * 获取月安全事件个数
	 * @return 月安全事件个数
	 */
	public Integer getSafecasem() {
		return safecasem;
	}

	/**
	 * 设置月安全事件个数
	 * @param safecasem 月安全事件个数
	 */
	public void setSafecasem(Integer safecasem) {
		this.safecasem = safecasem;
	}

	/**
	 * 获取月安全事件评分
	 * @return 月安全事件评分
	 */
	public Integer getSafemarkm() {
		return safemarkm;
	}

	/**
	 * 设置月安全事件评分
	 * @param safemarkm 月安全事件评分
	 */
	public void setSafemarkm(Integer safemarkm) {
		this.safemarkm = safemarkm;
	}

	/**
	 * 获取月风险检查评分
	 * @return 月风险检查评分
	 */
	public Integer getRiskmarkm() {
		return riskmarkm;
	}

	/**
	 * 设置月风险检查评分
	 * @param riskmarkm 月风险检查评分
	 */
	public void setRiskmarkm(Integer riskmarkm) {
		this.riskmarkm = riskmarkm;
	}

	/**
	 * 获取月容量事件个数
	 * @return 月容量事件个数
	 */
	public Integer getCapacitycasem() {
		return capacitycasem;
	}

	/**
	 * 设置月容量事件个数
	 * @param capacitycasem 月容量事件个数
	 */
	public void setCapacitycasem(Integer capacitycasem) {
		this.capacitycasem = capacitycasem;
	}

	/**
	 * 获取月容量事件评分
	 * @return 月容量事件评分
	 */
	public Integer getCapacitymarkm() {
		return capacitymarkm;
	}

	/**
	 * 设置月容量事件评分
	 * @param capacitymarkm 月容量事件评分
	 */
	public void setCapacitymarkm(Integer capacitymarkm) {
		this.capacitymarkm = capacitymarkm;
	}

	public Serializable getPK() {
		return month;
	}

	/**
	 * 获取月
	 * @return 月
	 */
	public String getMonth() {
		return month;
	}


	/**
	 * 设置月
	 * @param month 月
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
}
