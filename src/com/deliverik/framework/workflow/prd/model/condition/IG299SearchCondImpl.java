/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 状态可分派机构定义表检索条件实现
  * 功能描述: 状态可分派机构定义表检索条件实现
  * 创建记录: 2013/02/26
  * 修改记录: 
  */
public class IG299SearchCondImpl implements
		IG299SearchCond {

	/** 流程状态节点 */
	protected String psdid_eq;
	
	/** 流程状态节点指定可分派机构表主键模糊查询 */
	protected String psodid_like;
	
	/** 流程状态节点指定可分派机构码精确查询 */
	protected String orgsyscoding_eq;
	
	/** 流程状态节点like */
	protected String psdid_like;

	/**
	 * 流程状态节点取得
	 *
	 * @return psdid_eq 流程状态节点
	 */
	public String getPsdid_eq() {
		return psdid_eq;
	}

	/**
	 * 流程状态节点设定
	 *
	 * @param psdid_eq 流程状态节点
	 */
	public void setPsdid_eq(String psdid_eq) {
		this.psdid_eq = psdid_eq;
	}

	/**
	 * 流程状态节点指定可分派机构主键模糊查询取得
	 *
	 * @return psodid_like 流程状态节点指定可分派机构模糊查询
	 */
	public String getPsodid_like() {
		return psodid_like;
	}

	/**
	 * 流程状态节点指定可分派机构主键模糊查询设定
	 *
	 * @param psodid_like 流程状态节点指定可分派机构模糊查询
	 */
	public void setPsodid_like(String psodid_like) {
		this.psodid_like = psodid_like;
	}

	/**
	 * 流程状态节点指定可分派机构码精确查询取得
	 *
	 * @return orgsyscoding_eq 流程状态节点指定可分派机构码精确查询
	 */
	public String getOrgsyscoding_eq() {
		return orgsyscoding_eq;
	}

	/**
	 * 流程状态节点指定可分派机构码精确查询设定
	 *
	 * @param orgsyscoding_eq 流程状态节点指定可分派机构码精确查询
	 */
	public void setOrgsyscoding_eq(String orgsyscoding_eq) {
		this.orgsyscoding_eq = orgsyscoding_eq;
	}

	/**
	 * 流程状态节点like取得
	 * @return 流程状态节点like
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * 流程状态节点like设定
	 * @param psdid_like 流程状态节点like
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	
}