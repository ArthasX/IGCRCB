/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 事件变更服务效率检索条件实现
  * 功能描述: 事件变更服务效率检索条件实现
  * 创建记录: 2011/11/23
  * 修改记录: 2012/0810 将ServeEfficiencySearchCondImpl表名修改为SOC0208SearchCondImpl
  */
public class SOC0208SearchCondImpl implements
		SOC0208SearchCond {
	
	/** 流程类型 */
	protected String prtype;
	
	/** 不检索的月份 */
	protected String isNotTime;
	
	/**
	 * 流程类型取得
	 * @return 流程类型
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * 流程类型设定
	 * @param prtype 流程类型
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * 不检索的月份取得
	 * @return 不检索的月份
	 */
	public String getIsNotTime() {
		return isNotTime;
	}

	/**
	 * 不检索的月份设定
	 * @param isNotTime不检索的月份
	 */
	public void setIsNotTime(String isNotTime) {
		this.isNotTime = isNotTime;
	}

	

}