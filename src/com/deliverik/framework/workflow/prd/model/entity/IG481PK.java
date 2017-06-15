/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 流程组成员表实体
  * 功能描述: 流程组成员表实体
  * 创建记录: 2015/02/03
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG481PK extends BasePK implements Serializable {

	/** 流程组id */
	protected String pgdid;

	/** 单体流程id */
	protected String pdid;
	
	public IG481PK() {}

	public IG481PK(String pgdid, String pdid) {
		super();
		this.pgdid = pgdid;
		this.pdid = pdid;
	}

	/**
	 * 流程组id取得
	 *
	 * @return 流程组id
	 */
	public String getPgdid() {
		return pgdid;
	}

	/**
	 * 流程组id设定
	 *
	 * @param pgdid 流程组id
	 */
	public void setPgdid(String pgdid) {
		this.pgdid = pgdid;
	}

	/**
	 * 单体流程id取得
	 *
	 * @return 单体流程id
	 */
	public String getPdid() {
		return pdid;
	}

	/**
	 * 单体流程id设定
	 *
	 * @param pdid 单体流程id
	 */
	public void setPdid(String pdid) {
		this.pdid = pdid;
	}
	
}