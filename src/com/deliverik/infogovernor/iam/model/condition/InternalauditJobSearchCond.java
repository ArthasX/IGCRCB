/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * 概述: 内置工作表检索条件接口
  * 功能描述: 内置工作表检索条件接口
  * 创建记录: 2012/07/25
  * 修改记录: 
  */
public interface InternalauditJobSearchCond {

	/**
	 * 年度计划
	 */
	public String getIajYear_q();
	/**
	 * 工作名称
	 */
	public String getIajName_like();
	/**
	 * 内审项目ID
	 */
	public Integer getIajIapId_q();
}