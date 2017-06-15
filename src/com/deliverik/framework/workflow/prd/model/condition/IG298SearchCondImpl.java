/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 流程状态可分派角色定义信息检索条件实现
  * 功能描述: 流程状态可分派角色定义信息检索条件实现
  * 创建记录: 2012/04/11
  * 修改记录: 
  */
public class IG298SearchCondImpl implements
		IG298SearchCond {
	
	/** 流程状态ID */
	protected String psdid;
	
	/** 角色ID */
	protected Integer roleid;
	
	/** 主键 */
	protected String psrdid_like;
	
	/**
	 * 流程状态ID取得
	 * 
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * 
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}
	
	/**
	 * 角色ID取得
	 * 
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 * 
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPsrdid_like() {
		return psrdid_like;
	}

	/**
	 * 主键设定
	 * 
	 * @param psrdid_like 主键
	 */
	public void setPsrdid_like(String psrdid_like) {
		this.psrdid_like = psrdid_like;
	}
	
}