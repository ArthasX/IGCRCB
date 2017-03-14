/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * 概述: 审批意见表检索条件实现
  * 功能描述: 审批意见表检索条件实现
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
public class ApproveSuggestionSearchCondImpl implements
		ApproveSuggestionSearchCond {

	/** 流程主键 */
	protected Integer prid_eq;
	
	/** 表单定义主键 */
	protected String pidid_eq;
	
	/** 意见状态 */
	protected String status_eq;
	
	/** 流程状态标识 */
	protected String psdcode_eq;
	
	/** 表格式表单行号 */
	protected String rownumber_eq;

	/**
	 * 流程主键取得
	 *
	 * @return prid_eq 流程主键
	 */
	public Integer getPrid_eq() {
		return prid_eq;
	}

	/**
	 * 流程主键设定
	 *
	 * @param prid_eq 流程主键
	 */
	public void setPrid_eq(Integer prid_eq) {
		this.prid_eq = prid_eq;
	}

	/**
	 * 表单定义主键取得
	 *
	 * @return pidid_eq 表单定义主键
	 */
	public String getPidid_eq() {
		return pidid_eq;
	}
	
	/**
	 * 表单主键设定
	 *
	 * @param pidid_eq 表单主键
	 */
	public void setPidid_eq(String pidid_eq) {
		this.pidid_eq = pidid_eq;
	}

	/**
	 * 意见状态取得
	 *
	 * @return status_eq 意见状态
	 */
	public String getStatus_eq() {
		return status_eq;
	}

	/**
	 * 意见状态设定
	 *
	 * @param status_eq 意见状态
	 */
	public void setStatus_eq(String status_eq) {
		this.status_eq = status_eq;
	}

	/**
	 * 流程状态标识取得
	 *
	 * @return psdcode_eq 流程状态标识
	 */
	public String getPsdcode_eq() {
		return psdcode_eq;
	}

	/**
	 * 流程状态标识设定
	 *
	 * @param psdcode_eq 流程状态标识
	 */
	public void setPsdcode_eq(String psdcode_eq) {
		this.psdcode_eq = psdcode_eq;
	}

	/**
	 * 表格式表单行号取得
	 * @return rownumber_eq 表格式表单行号
	 */
	public String getRownumber_eq() {
		return rownumber_eq;
	}

	/**
	 * 表格式表单行号设定
	 * @param rownumber_eq 表格式表单行号
	 */
	public void setRownumber_eq(String rownumber_eq) {
		this.rownumber_eq = rownumber_eq;
	}
}