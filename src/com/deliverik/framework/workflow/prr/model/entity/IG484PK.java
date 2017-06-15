/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 流程组成员实例主键
  * 功能描述: 流程组成员实例主键
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG484PK extends BasePK implements Serializable {
	
	/** 流程组实例ID */
	protected Integer pgrid;
	
	/** 流程实例ID */
	protected Integer prid;
	
	public IG484PK() {}
	
	public IG484PK(Integer pgrid, Integer prid) {
		super();
		this.pgrid = pgrid;
		this.prid = prid;
	}

	/**
	 * 流程组实例ID取得
	 * @return 流程组实例ID
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 * 流程组实例ID设定
	 * @param pgrid 流程组实例ID
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * 流程实例ID取得
	 * @return 流程实例ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程实例ID设定
	 * @param prid 流程实例ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

}