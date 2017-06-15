/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * 概述: 报表填报明细表检索条件接口
  * 功能描述: 报表填报明细表检索条件接口
  * 创建记录: 2013/07/18
  * 修改记录: 
  */
public interface RegulatoryReportDetailSearchCond {

	/**
	 * 实例ID取得
	 * 
	 * @return 实例ID
	 */
	public Integer getInstanceID();
	
	/**
	 * 流程ID取得
	 * 
	 * @return 流程ID
	 */
	public Integer getPrid() ;

}