/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;



/**
  * 概述: 流程组关联关系实例表检索条件实现
  * 功能描述: 流程组关联关系实例表检索条件实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG485SearchCondImpl implements
		IG485SearchCond {

	/** 参考流程实例ID */
	protected Integer prid;

	/** 状态 */
	protected String pgrrstatus;

	/**
	 * 参考流程实例ID取得
	 * @return 参考流程实例ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 参考流程实例ID设定
	 * @param prid 参考流程实例ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getPgrrstatus() {
		return pgrrstatus;
	}

	/**
	 * 状态设定
	 * @param pgrrstatus 状态
	 */
	public void setPgrrstatus(String pgrrstatus) {
		this.pgrrstatus = pgrrstatus;
	}
	
}