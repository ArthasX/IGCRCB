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
public class IG485PK extends BasePK implements Serializable {

	/** 流程组关联关系主键 */
	protected String pgreid;

	/**  流程组实例ID */
	protected Integer pgrid;

	/** 参考流程实例ID */
	protected Integer prid;
	
	public IG485PK() {}
	
	public IG485PK(String pgreid, Integer pgrid, Integer prid) {
		super();
		this.pgreid = pgreid;
		this.pgrid = pgrid;
		this.prid = prid;
	}

	/**
	 * 流程组关联关系主键取得
	 *
	 * @return 流程组关联关系主键
	 */
	public String getPgreid() {
		return pgreid;
	}

	/**
	 * 流程组关联关系主键设定
	 *
	 * @param pgreid 流程组关联关系主键
	 */
	public void setPgreid(String pgreid) {
		this.pgreid = pgreid;
	}

	/**
	 *  流程组实例id取得
	 *
	 * @return  流程组实例id
	 */
	public Integer getPgrid() {
		return pgrid;
	}

	/**
	 *  流程组实例id设定
	 *
	 * @param pgrid  流程组实例id
	 */
	public void setPgrid(Integer pgrid) {
		this.pgrid = pgrid;
	}

	/**
	 * 参考流程实例ID取得
	 *
	 * @return 参考流程实例ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 参考流程实例ID设定
	 *
	 * @param prid 参考流程实例ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

}