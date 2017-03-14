/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;



/**
 * 流程页面定义信息检索条件实现
 * 
 */
public class IG126SearchCondImpl implements IG126SearchCond {
	
	/** 流程定义ID */
	protected String pdid;

	/** 页面类型 */
	protected String pjdtype;
	
	/** 流程页面定义ID */
	protected String pjdid_like;
	
	/**
	 * 流程定义ID取得
	 * 
	 * @return 流程定义ID
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 流程定义ID设定
	 * 
	 * @param pdid流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 页面类型取得
	 * 
	 * @return 页面类型
	 */
	public String getPjdtype() {
		return pjdtype;
	}

	/**
	 * 页面类型设定
	 * 
	 * @param pjdtype页面类型
	 */
	public void setPjdtype(String pjdtype) {
		this.pjdtype = pjdtype;
	}

	/**
	 * 流程页面定义ID取得
	 * 
	 * @return 流程页面定义ID
	 */
	public String getPjdid_like() {
		return pjdid_like;
	}

	/**
	 * 流程页面定义ID设定
	 * 
	 * @param pjdid_like 流程页面定义ID
	 */
	public void setPjdid_like(String pjdid_like) {
		this.pjdid_like = pjdid_like;
	}
	
}
