/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程组关联关系定义表检索条件实现
  * 功能描述: 流程组关联关系定义表检索条件实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG482SearchCondImpl implements
		IG482SearchCond {
	
	/** 流程组定义ID */
	protected String pgdid;
	
	/** 参考流程定义ID */
	protected String rpdid;
	
	/** 参考流程状态ID */
	protected String rpsdid;

	/**
	 * 流程组定义ID取得
	 * @return 流程组定义ID
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 流程组定义ID设定
	 * @param pgdid 流程组定义ID
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 参考流程定义ID取得
	 * @return 参考流程定义ID
	 */
	public String getRpdid() {
		return rpdid;
	}

	/**
	 * 参考流程定义ID设定
	 * @param rpdid 参考流程定义ID
	 */
	public void setRpdid(String rpdid) {
		this.rpdid = rpdid;
	}

	/**
	 * 参考流程状态ID取得
	 * @return 参考流程状态ID
	 */
	public String getRpsdid() {
		return rpsdid;
	}

	/**
	 * 参考流程状态ID设定
	 * @param rpsdid 参考流程状态ID
	 */
	public void setRpsdid(String rpsdid) {
		this.rpsdid = rpsdid;
	}
	
}