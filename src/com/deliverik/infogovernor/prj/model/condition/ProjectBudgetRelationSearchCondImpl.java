/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.prj.model.condition;

/**
 * 概述: 项目于预算关系表查询条件实现
 * 功能描述：项目于预算关系表查询条件实现
 * 创建人：王廷志
 * 创建记录： 2012-5-17
 * 修改记录：
 */
public class ProjectBudgetRelationSearchCondImpl implements ProjectBudgetRelationSearchCond{
	/** 项目id */
	private Integer pid_eq;
	/** 预算id */
	private Integer bid_eq;
	/**
	 * 项目id取得
	 * @return pid_eq 项目id
	 */
	public Integer getPid_eq() {
		return pid_eq;
	}
	/**
	 * 项目id设定
	 * @param pid_eq 项目id
	 */
	public void setPid_eq(Integer pid_eq) {
		this.pid_eq = pid_eq;
	}
	/**
	 * 预算id取得
	 * @return bid_eq 预算id
	 */
	public Integer getBid_eq() {
		return bid_eq;
	}
	/**
	 * 预算id设定
	 * @param bid_eq 预算id
	 */
	public void setBid_eq(Integer bid_eq) {
		this.bid_eq = bid_eq;
	}
}	
