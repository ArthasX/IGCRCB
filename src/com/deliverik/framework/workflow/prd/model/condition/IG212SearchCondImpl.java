/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 流程通知策略检索条件实现
  * 功能描述: 流程通知策略检索条件实现
  * 创建记录: 2012/04/24
  * 修改记录: 
  */
public class IG212SearchCondImpl implements
		IG212SearchCond {

	/** 状态ID */
	protected String psdid_like;
	
	/** 流程定义ID */
	private String pdid;

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid_like() {
		return psdid_like;
	}

	/**
	 * 状态ID设定
	 * 
	 * @param psdid_like 状态ID
	 */
	public void setPsdid_like(String psdid_like) {
		this.psdid_like = psdid_like;
	}

	/**
	 * 流程定义ID设定
	 * @param pdid
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	/**
	 * 流程定义ID获取
	 * @return
	 */
	public String getPdid() {
		return pdid;
	}
	
}