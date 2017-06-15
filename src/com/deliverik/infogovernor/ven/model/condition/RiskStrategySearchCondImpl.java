/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model.condition;

/**
  * 概述: 风险策略表检索条件实现
  * 功能描述: 风险策略表检索条件实现
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public class RiskStrategySearchCondImpl implements
		RiskStrategySearchCond {
	
	/** 风险策略名称 */
	protected String rsname;

	/**
	 * 风险策略名称获取
	 * @return
	 */
	public String getRsname() {
		return rsname;
	}

	/**
	 * 风险策略名称设定
	 * @param rsname
	 */
	public void setRsname(String rsname) {
		this.rsname = rsname;
	}
	
	
}