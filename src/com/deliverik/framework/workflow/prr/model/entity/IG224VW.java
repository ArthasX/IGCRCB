/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Id;

/**
 * 流程状态日志实体接口
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class IG224VW implements Serializable, Cloneable {

	/** 流程状态日志ID */
	@Id
	protected Integer rslid;
	
	/** 流程ID */
	protected Integer prid;
	
	/** 流程状态定义ID */
	protected String psdid;
	
	/** 动态分支编号 */
	protected Integer psdnum;
	
	/** 引发挂起的状态ID */
	protected String pendpsdid;
	
	/** 引发挂起的状态ID对应的NUM */
	protected Integer pendpsdnum;
	
	/**
	 * 流程状态日志ID取得
	 * @return 流程状态日志ID
	 */
	public Integer getRslid() {
		return rslid;
	}

	/**
	 * 流程状态日志ID设定
	 * @param rslid 流程状态日志ID
	 */
	public void setRslid(Integer rslid) {
		this.rslid = rslid;
	}

	/**
	 * 流程ID取得
	 * @return 流程ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程ID设定
	 * @param prid 流程ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}
	
	/**
	 * 流程状态定义ID取得
	 * @return 流程状态定义ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态定义ID设定
	 * @param psdid 流程状态定义ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 动态分支编号取得
	 * @return 动态分支编号
	 */
	public Integer getPsdnum() {
		return psdnum;
	}

	/**
	 * 动态分支编号设定
	 * @param psdnum 动态分支编号
	 */
	public void setPsdnum(Integer psdnum) {
		this.psdnum = psdnum;
	}

	/**
	 * 引发挂起的状态ID取得
	 * @return 引发挂起的状态ID
	 */
	public String getPendpsdid() {
		return pendpsdid;
	}

	/**
	 * 引发挂起的状态ID设定
	 * @param pendpsdid 引发挂起的状态ID
	 */
	public void setPendpsdid(String pendpsdid) {
		this.pendpsdid = pendpsdid;
	}
	
	/**
	 * 引发挂起的状态ID对应的NUM取得
	 * @return 引发挂起的状态ID对应的NUM
	 */
	public Integer getPendpsdnum() {
		return pendpsdnum;
	}
	
	/**
	 * 引发挂起的状态ID对应的NUM设定
	 * @param pendpsdnum 引发挂起的状态ID对应的NUM
	 */
	public void setPendpsdnum(Integer pendpsdnum) {
		this.pendpsdnum = pendpsdnum;
	}
	
}
