/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model;

/**
 * <p>概述:流程类型定义信息接口</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public interface IG359Info {
	
	/**
	 * 功能：资产ID取得
	 * @return prassetid 资产ID
	 */
	public abstract Integer getPrassetid();

	/**
	 * 功能：资产名称取得
	 * @return prassetname 资产名称
	 */
	public abstract String getPrassetname();

	/**
	 * 功能：事件取得
	 * @return incident 事件
	 */
	public abstract Integer getIncident();

	/**
	 * 功能：问题取得
	 * @return problem 问题
	 */
	public abstract Integer getProblem();

	/**
	 * 功能：变更取得
	 * @return change 变更
	 */
	public abstract Integer getChange();

	/**
	 * 功能：发起取得
	 * @return deployment 发起
	 */
	public abstract Integer getDeployment();

	/**
	 * 功能：工作取得
	 * @return work 工作
	 */
	public abstract Integer getWork();
}