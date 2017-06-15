/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.workflow.prd.model.IG931Info;

/**
  * 概述: 缺省状态参与者关联流程类型定义表实体
  * 功能描述: 缺省状态参与者关联流程类型定义表实体
  * 创建记录: 2012/10/18
  * 修改记录: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="IG931")
public class IG931TB extends BaseEntity implements Serializable,
		Cloneable, IG931Info {

	/** 主键 */
	@Id
	protected String dpsprpid;

	/** 流程定义id */
	protected String pdid;

	/** 流程状态id */
	protected String psdid;

	/** 关联的流程定义id */
	protected String relevantPdid;
    
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getDpsprpid() {
		return dpsprpid;
	}

	/**
	 * 主键设定
	 *
	 * @param dpsprpid 主键
	 */
	public void setDpsprpid(String dpsprpid) {
		this.dpsprpid = dpsprpid;
	}

	/**
	 * 流程定义id取得
	 *
	 * @return 流程定义id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义id设定
	 *
	 * @param pdid 流程定义id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程状态id取得
	 *
	 * @return 流程状态id
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态id设定
	 *
	 * @param psdid 流程状态id
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 关联的流程定义id取得
	 *
	 * @return 关联的流程定义id
	 */
	public String getRelevantPdid() {
		return relevantPdid;
	}

	/**
	 * 关联的流程定义id设定
	 *
	 * @param relevantPdid 关联的流程定义id
	 */
	public void setRelevantPdid(String relevantPdid) {
		this.relevantPdid = relevantPdid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return dpsprpid;
	}
}