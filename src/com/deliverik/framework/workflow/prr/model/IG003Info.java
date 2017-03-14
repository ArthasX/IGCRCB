/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>概述:流程统计信息接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG003Info {
	
	/**
	 * 功能：月份取得
	 * @return month 月份
	 */
	public abstract String getMonth();
	
	/**
	 * 功能：当前事件取得
	 * @return currentIncident 当前事件
	 */
	public abstract Integer getCurrentIncident();
	
	/**
	 * 功能：先前事件取得
	 * @return precedingIncident 先前事件
	 */
	public abstract Integer getPrecedingIncident();
	
	/**
	 * 功能：当前问题取得
	 * @return currentProblem 当前问题
	 */
	public abstract Integer getCurrentProblem();
	
	/**
	 * 功能：先前问题取得
	 * @return precedingProblem 先前问题
	 */
	public abstract Integer getPrecedingProblem();
	
	/**
	 * 功能：当前变更取得
	 * @return currentChange 当前变更
	 */
	public abstract Integer getCurrentChange();
	
	/**
	 * 功能：先前变更取得
	 * @return precedingChange 先前变更
	 */
	public abstract Integer getPrecedingChange();
	
	/**
	 * 功能：当前更新取得
	 * @return currentDeployment 当前更新
	 */
	public abstract Integer getCurrentDeployment();
	
	/**
	 * 功能：先前更新取得
	 * @return precedingDeployment 先前更新
	 */
	public abstract Integer getPrecedingDeployment();
	
	/**
	 * 功能：当前工作取得
	 * @return currentWork 当前工作
	 */
	public abstract Integer getCurrentWork();
	
	/**
	 * 功能：先前工作取得
	 * @return precedingWork 先前工作
	 */
	public abstract Integer getPrecedingWork();
	
	/**
	 * 功能：当前总共数量设定
	 * @param totalPreceding 当前总共数量
	 */
	public abstract Integer getTotalCurrent();
	
	/**
	 * 功能：先前总共数量取得
	 * @return totalPreceding 先前总共数量
	 */
	public abstract Integer getTotalPreceding();
	
}
