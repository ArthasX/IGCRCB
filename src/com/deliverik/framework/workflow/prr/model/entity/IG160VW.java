/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.framework.workflow.prr.model.IG160Info;

/**
 * <p>概述:流程相关人员汇总统计视图实体</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
@Entity
public class IG160VW implements Serializable,
	Cloneable, IG160Info {
	@Id
	/** 用户ID*/
	protected String ppuserid;
	/** 用户名*/
	protected String ppusername;
	/** 机构id*/
	protected String orgid;
	/** 机构名称*/
	protected String orgname;
	/** 事件*/
	protected Integer incident;
	/** 问题*/
	protected Integer problem;
	/** 变更*/
	protected Integer change;
	/** 更新*/
	protected Integer deployment;
	/** 工作*/
	protected Integer work;
	/** 请求*/
	protected Integer ask;
	/**
	 * 功能：机构名称取得
	 * @return orgname 机构名称
	 */
	public String getOrgname() {
		return orgname;
	}

	/**
	 * 功能：机构名称设定
	 * @param orgname 机构名称
	 */
	public void setOrgname(String orgname) {
		this.orgname = orgname;
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
	 * 功能：变更设定
	 * @param change 变更
	 */
	public void setChange(Integer change) {
		this.change = change;
	}

	/**
	 * 功能：更新取得
	 * @return deployment 更行
	 */
	public Integer getDeployment() {
		return deployment;
	}

	/**
	 * 功能：更行设定
	 * @param deployment 更行
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
	 * 功能：工作设定
	 * @param work 工作
	 */
	public void setWork(Integer work) {
		this.work = work;
	}
	/**
	 * 功能：请求取得
	 * @return ask 请求
	 */
	public Integer getAsk() {
		return ask;
	}
	/**
	 * 功能：请求设置
	 * @return ask 请求
	 */
	public void setAsk(Integer ask) {
		this.ask = ask;
	}
	/**
	 * 功能：机构ID取得
	 * @return orgid 机构ID
	 */
	public String getOrgid() {
		return orgid;
	}

	/**
	 * 功能：机构ID设定
	 * @param orgid 机构ID
	 */
	public void setOrgid(String orgid) {
		this.orgid = orgid;
	}

	/**
	 * 功能：用户ID取得
	 * @return ppuserid 用户ID
	 */
	public String getPpuserid() {
		return ppuserid;
	}

	/**
	 * 功能：用户ID设定
	 * @param ppuserid 用户ID
	 */
	public void setPpuserid(String ppuserid) {
		this.ppuserid = ppuserid;
	}

	/**
	 * 功能：用户名称取得
	 * @return ppusername 用户名称
	 */
	public String getPpusername() {
		return ppusername;
	}

	/**
	 * 功能：用户名称设定
	 * @param ppusername 用户名称
	 */
	public void setPpusername(String ppusername) {
		this.ppusername = ppusername;
	}

	public boolean equals(Object obj) {
		if (!(obj instanceof IG160VW))
			return false;
		IG160Info target = (IG160Info) obj;
		if (!(getPpuserid() == target.getPpuserid()))
			return false;

		return true;
	}

}
