/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.vir.model.condition;

/**
  * 概述: vim05检索条件实现
  * 功能描述: vim05检索条件实现
  * 创建记录: 2014/02/21
  * 修改记录: 
  */
public class VIM05SearchCondImpl implements
		VIM05SearchCond {
	
	protected String strategyName_eq;

	public String getStrategyName_eq() {
		return strategyName_eq;
	}

	public void setStrategyName_eq(String strategyName_eq) {
		this.strategyName_eq = strategyName_eq;
	}
	
}