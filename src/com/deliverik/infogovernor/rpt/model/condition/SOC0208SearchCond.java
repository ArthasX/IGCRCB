/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 事件变更服务效率检索条件接口
  * 功能描述: 事件变更服务效率检索条件接口
  * 创建记录: 2011/11/23
  * 修改记录: 2012/08/10 将ServeEfficiencySearchCond表名修改为SOC0208SearchCond
  */
public interface SOC0208SearchCond {
	/**
	 * 不检索的月份取得
	 * @return 不检索的月份
	 */
	public String getIsNotTime();
	
	/**
	 * 流程类型取得
	 * @return 流程类型
	 */
	public String getPrtype();


}