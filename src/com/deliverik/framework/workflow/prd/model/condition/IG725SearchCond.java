/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 缺省参与者按钮定义表检索条件接口
  * 功能描述: 缺省参与者按钮定义表检索条件接口
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public interface IG725SearchCond {
	
	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid();
	
	/**
	 * 按钮ID取得
	 *
	 * @return 按钮ID
	 */
	public String getPbdid();

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPdbdid_like();
}