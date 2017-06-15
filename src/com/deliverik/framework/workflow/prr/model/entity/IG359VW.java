/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG359Info;

/**
 * <p>概述:流程类型定义信息实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG359VW implements Serializable,
	Cloneable, IG359Info {
	/** 资产ID*/
	@Id
	protected Integer prassetid;
	/** 资产名称*/
	protected String prassetname;
	/** 事件*/
	protected Integer incident;
	/** 问题*/
	protected Integer problem;
	/** 变更*/
	protected Integer change;
	/** 发起*/
	protected Integer deployment;
	/** 工作*/
	protected Integer work;

	/**
	 * 功能：资产ID取得
	 * @return prassetid 资产ID
	 */
	public Integer getPrassetid() {
		return prassetid;
	}

	/**
	 * 功能：资产ID设置
	 * @param prassetid 资产ID
	 */
	public void setPrassetid(Integer prassetid) {
		this.prassetid = prassetid;
	}

	/**
	 * 功能：资产名称取得
	 * @return prassetname 资产名称
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * 功能：资产名称设置
	 * @param prassetname 资产名称
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * 功能：事件取得
	 * @return incident 事件
	 */
	public Integer getIncident() {
		return incident;
	}

	/** 
	 * 功能：事件设置
	 * @param incident 事件
	 */
	public void setIncident(Integer incident) {
		this.incident = incident;
	}
	
	/**
	 * 功能：问题取得
	 * @return problem 问题
	 */
	public Integer getProblem() {
		return problem;
	}

	/**
	 * 功能：问题设定
	 * @param problem 问题
	 */
	public void setProblem(Integer problem) {
		this.problem = problem;
	}

	/**
	 * 功能：变更取得
	 * @return change 变更
	 */
	public Integer getChange() {
		return change;
	}

	/**
	 * 功能：变更设置
	 * @param change 变更
	 */
	public void setChange(Integer change) {
		this.change = change;
	}

	/**
	 * 功能：发起取得
	 * @return deployment 发起
	 */
	public Integer getDeployment() {
		return deployment;
	}

	/**
	 * 功能：发起设置
	 * @param deployment 发起
	 */
	public void setDeployment(Integer deployment) {
		this.deployment = deployment;
	}

	/**
	 * 功能：工作取得
	 * @return work 工作
	 */
	public Integer getWork() {
		return work;
	}

	/**
	 * 功能：工作设置
	 * @param work 工作
	 */
	public void setWork(Integer work) {
		this.work = work;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG359VW))
			return false;
		IG359Info target = (IG359Info) obj;
		if (!(getPrassetid() == target.getPrassetid()))
			return false;

		return true;
	}

}
