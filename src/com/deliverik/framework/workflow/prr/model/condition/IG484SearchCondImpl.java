/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程组成员实例检索条件实现
  * 功能描述: 流程组成员实例检索条件实现
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
public class IG484SearchCondImpl implements
		IG484SearchCond {
	
	/** 流程组ID */
	protected Integer pgrid;
	
	/** 流程ID */
	protected Integer prid;

	
	/**
	 * @return the prid
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * @param prid the prid to set
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 流程组ID取得
	 * @return 流程组ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * 流程组ID设定
	 * @param pgrid 流程组ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

}