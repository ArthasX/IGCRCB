/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * 概述: 风险策略指标关系表检索条件实现
  * 功能描述: 风险策略指标关系表检索条件实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class StrategyIndexRelationSearchCondImpl implements
		StrategyIndexRelationSearchCond {

	/** 风险策略主键*/
	protected Integer rsid;

	/**
	 * 风险策略主键获取
	 * @return rsid
	 */
	public Integer getRsid() {
		return rsid;
	}

	/**
	 * 风险策略主键设定
	 * @param rsid
	 */
	public void setRsid(Integer rsid) {
		this.rsid = rsid;
	}
}