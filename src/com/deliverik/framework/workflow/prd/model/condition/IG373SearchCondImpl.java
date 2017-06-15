/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程表单初始化事件定义表检索条件实现
  * 功能描述: 流程表单初始化事件定义表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 
  */
public class IG373SearchCondImpl implements
		IG373SearchCond {
	
	/**
	 * 流程状态ID
	 */
	protected String psdid;

	/** 流程定义ID */
	protected String pdid;

	/**
	 * 流程状态ID取得
	 * @return 流程状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 流程状态ID设定
	 * @param psdid 流程状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

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
	 * @param pdid 流程定义ID
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}