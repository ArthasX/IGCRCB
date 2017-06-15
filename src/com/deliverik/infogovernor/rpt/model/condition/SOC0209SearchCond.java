/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 流程来源视图检索条件接口
  * 功能描述: 流程来源视图检索条件接口
  * 创建记录: 2011/11/24
  * 修改记录: 2012/08/09 将ProcessRecordInfoVWSearchCond表名改为SOC0209SearchCond
  */
public interface SOC0209SearchCond {
	/**
	 * 流程发起时间取得
	 *
	 * @return 流程发起时间
	 */
	public String getPropentime();

	
	/**
	 * 流程类型取得
	 *
	 * @return 流程类型
	 */
	public String getPrtype();


}