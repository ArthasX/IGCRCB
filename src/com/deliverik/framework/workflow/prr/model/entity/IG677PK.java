/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.entity;

import java.io.Serializable;

import com.deliverik.framework.base.BasePK;

/**
 * <p>概述:流程记录与参与用户信息实体主键</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("serial")
public class IG677PK extends BasePK implements Serializable {

	/**
	 * 流程记录ID
	 */
	protected Integer prid;
	
	/**
	 * 流程参与用户信息ID
	 */
	protected Integer ppid;
	
	/**
	 * 功能：流程记录ID取得
	 * @return 流程记录ID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 功能：流程记录ID设定
	 * @param prid 流程记录ID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 功能：流程参与用户信息ID取得
	 * @return 流程参与用户信息ID
	 */
	public Integer getPpid() {
		return ppid;
	}

	/**
	 * 功能：流程参与用户信息ID设定
	 * @param ppid 流程参与用户信息ID
	 */
	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	
	/**
	 * 功能：缺省构造函数
	 */
	public IG677PK(){}
	
	/**
	 * 功能：构造函数
	 * @param prid
	 * @param ppid
	 */
	public IG677PK(Integer prid, Integer ppid) {
		this.prid = prid;
		this.ppid = ppid;
	}
}
