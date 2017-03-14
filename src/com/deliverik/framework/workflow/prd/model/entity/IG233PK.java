/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
  * 概述: 自定义流程分派定义表实体主键
  * 功能描述: 自定义流程分派定义表实体主键
  * 创建记录: 2013/03/12
  * 修改记录: 
  */
@SuppressWarnings("serial")
public class IG233PK extends BasePK implements Serializable {

	/** 被分派节点主键 */
	protected String psdid;

	/** 分派节点主键 */
	protected String assignpsdid;

	/**
	 * 构造函数
	 */
	public IG233PK() {

	}

	/**
	 * 构造函数
	 */
	public IG233PK(String psdid, String assignpsdid) {
		super();
		this.psdid = psdid;
		this.assignpsdid = assignpsdid;
	}

	/**
	 * 被分派节点主键取得
	 *
	 * @return 被分派节点主键
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 被分派节点主键设定
	 *
	 * @param psdid 被分派节点主键
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 分派节点主键取得
	 *
	 * @return 分派节点主键
	 */
	public String getAssignpsdid() {
		return assignpsdid;
	}

	/**
	 * 分派节点主键设定
	 *
	 * @param assignpsdid 分派节点主键
	 */
	public void setAssignpsdid(String assignpsdid) {
		this.assignpsdid = assignpsdid;
	}

}