/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 流程策略通知人检索条件接口
  * 功能描述: 流程策略通知人检索条件接口
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public interface IG237SearchCond {
	
	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid();

	/**
	 * 是否确认取得
	 *
	 * @return 是否确认
	 */
	public String getPsdconfirm();

	/**
	 * 状态ID取得
	 * 
	 * @return 状态ID
	 */
	public String getPsdid_like();
	
	/**
	 * 表单值取得
	 * @return pivalue 表单值
	 */
	public String getPivalue();

}