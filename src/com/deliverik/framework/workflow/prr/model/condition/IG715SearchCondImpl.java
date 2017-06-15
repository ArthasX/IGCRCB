/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
 * <p>概述:服务工单关联流程查询条件实现</p>
 * <p>功能描述：</p>
 * <p>创建记录：</p>
 */
public class IG715SearchCondImpl implements IG715SearchCond {
	
	/** 主键ID */
	protected Integer sprrid;
	
	/** 服务工单ID */
	protected Integer sprrsfid;

	/** 流程ID */
	protected Integer sprrprid;

	/**
	 * 功能：主键ID取得
	 * @return sprrid 主键ID
	 */
	public Integer getSprrid() {
		return sprrid;
	}

	/**
	 * 功能：主键ID取得
	 * @param sprrid 主键ID
	 */
	public void setSprrid(Integer sprrid) {
		this.sprrid = sprrid;
	}

	/**
	 * 功能：服务工单ID取得
	 * @return sprrsfid 服务工单ID
	 */ 
	public Integer getSprrsfid() {
		return sprrsfid;
	}

	/**
	 * 功能：服务工单ID设置
	 * @param sprrsfid 服务工单ID
	 */
	public void setSprrsfid(Integer sprrsfid) {
		this.sprrsfid = sprrsfid;
	}

	/**
	 * 功能：流程ID取得
	 * @return sprrprid 流程ID
	 */
	public Integer getSprrprid() {
		return sprrprid;
	}

	/**
	 * 功能：流程ID设置
	 * @param sprrprid 流程ID
	 */
	public void setSprrprid(Integer sprrprid) {
		this.sprrprid = sprrprid;
	}


}
