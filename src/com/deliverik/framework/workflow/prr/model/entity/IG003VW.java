/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG003Info;

/**
 * <p>概述:流程统计信息实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG003VW implements Serializable,
	Cloneable, IG003Info {
	@Id
	/** 月份*/
	public String month;
	
	/** 当前事件*/
	public Integer currentIncident;
	
	/** 先前事件*/
	public Integer precedingIncident;
	
	/** 当前问题*/
	public Integer currentProblem;
	
	/** 先前问题*/
	public Integer precedingProblem;
	
	/** 当前变更*/
	public Integer currentChange;
	
	/** 先前变更*/
	public Integer precedingChange;
	
	/** 当前更新*/
	public Integer currentDeployment;
	
	/** 先前更新*/
	public Integer precedingDeployment;
	
	/** 当前工作*/
	public Integer currentWork;
	
	/** 先前工作*/
	public Integer precedingWork;
	
	/** 当前总共数量*/
	public Integer totalCurrent;
	
	/** 先前总共数量*/
	public Integer totalPreceding;
	
	/**
	 * 功能：当前总共数量取得
	 * @return totalCurrent
	 */
	public Integer getTotalCurrent() {
		return totalCurrent;
	}

	/**
	 * 功能：当前总共数量设置
	 * @param totalCurrent
	 */
	public void setTotalCurrent(Integer totalCurrent) {
		this.totalCurrent = totalCurrent;
	}

	/**
	 * 功能：先前总共数量取得
	 * @return totalPreceding
	 */
	public Integer getTotalPreceding() {
		return totalPreceding;
	}

	/**
	 * 功能：当前总共数量设定
	 * @param totalPreceding
	 */
	public void setTotalPreceding(Integer totalPreceding) {
		this.totalPreceding = totalPreceding;
	}

	/**
	 * 功能：月份取得
	 * @return month
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 功能：月份设定
	 * @param month
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 功能：当前事件取得
	 * @return currentIncident
	 */
	public Integer getCurrentIncident() {
		return currentIncident;
	}

	/**
	 * 功能：当前事件设置
	 * @param currentIncident
	 */
	public void setCurrentIncident(Integer currentIncident) {
		this.currentIncident = currentIncident;
	}

	/**
	 * 功能：先前事件取得
	 * @return precedingIncident
	 */
	public Integer getPrecedingIncident() {
		return precedingIncident;
	}

	/**
	 * 功能：先前事件设定
	 * @param precedingIncident
	 */
	public void setPrecedingIncident(Integer precedingIncident) {
		this.precedingIncident = precedingIncident;
	}

	/**
	 * 功能：当前问题取得
	 * @return currentProblem
	 */
	public Integer getCurrentProblem() {
		return currentProblem;
	}

	/**
	 * 功能：当前问题设定
	 * @param currentProblem
	 */
	public void setCurrentProblem(Integer currentProblem) {
		this.currentProblem = currentProblem;
	}

	/**
	 * 功能：先前问题取得
	 * @return precedingProblem
	 */
	public Integer getPrecedingProblem() {
		return precedingProblem;
	}

	/**
	 * 功能：先前问题设定
	 * @param precedingProblem
	 */
	public void setPrecedingProblem(Integer precedingProblem) {
		this.precedingProblem = precedingProblem;
	}

	/**
	 * 功能：当前变更取得
	 * @return currentChange
	 */
	public Integer getCurrentChange() {
		return currentChange;
	}

	/**
	 * 功能：先前变更设定
	 * @param currentChange
	 */
	public void setCurrentChange(Integer currentChange) {
		this.currentChange = currentChange;
	}

	/**
	 * 功能：先前变更取得
	 * @return precedingChange
	 */
	public Integer getPrecedingChange() {
		return precedingChange;
	}

	/**
	 * 功能：先前变更设定
	 * @param precedingChange
	 */
	public void setPrecedingChange(Integer precedingChange) {
		this.precedingChange = precedingChange;
	}

	/**
	 * 功能：当前更新取得
	 * @return currentDeployment
	 */
	public Integer getCurrentDeployment() {
		return currentDeployment;
	}

	/**
	 * 功能：当前更新设定
	 * @param currentDeployment
	 */
	public void setCurrentDeployment(Integer currentDeployment) {
		this.currentDeployment = currentDeployment;
	}

	/**
	 * 功能：先前更新取得
	 * @return precedingDeployment
	 */
	public Integer getPrecedingDeployment() {
		return precedingDeployment;
	}

	/**
	 * 功能：先前更新设定
	 * @param precedingDeployment
	 */
	public void setPrecedingDeployment(Integer precedingDeployment) {
		this.precedingDeployment = precedingDeployment;
	}

	/**
	 * 功能：当前工作取得
	 * @return currentWork
	 */
	public Integer getCurrentWork() {
		return currentWork;
	}

	/**
	 * 功能：当前工作设定
	 * @param currentWork
	 */
	public void setCurrentWork(Integer currentWork) {
		this.currentWork = currentWork;
	}

	/**
	 * 功能：先前工作取得
	 * @return precedingWork
	 */
	public Integer getPrecedingWork() {
		return precedingWork;
	}

	/**
	 * 功能：先前工作设定
	 * @param precedingWork
	 */
	public void setPrecedingWork(Integer precedingWork) {
		this.precedingWork = precedingWork;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG003VW))
			return false;
		IG003Info target = (IG003Info) obj;
		if (!(getMonth() == target.getMonth()))
			return false;

		return true;
	}

}
