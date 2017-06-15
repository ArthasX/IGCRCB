/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

/**
  * 概述: 流程私有变量表检索条件接口
  * 功能描述: 流程私有变量表检索条件接口
  * 创建记录: 2012/03/27
  * 修改记录: 
  */
public interface IG899SearchCond {
	
	/**
	 * 流程变量定义ID取得
	 *
	 * @return 流程变量定义ID
	 */
	public String getPidid();

	/**
	 * 流程变量值ID取得
	 *
	 * @return 流程变量值ID
	 */
	public Integer getPiid();

	/**
	 * 流程参与者的角色ID取得
	 *
	 * @return 流程参与者的角色ID
	 */
	public Integer getRoleid();
	
	/**
	 * 流程参与者ID取得
	 * 
	 * @return 流程参与者ID
	 */
	public String getUserid();
	
	/**
	 * 机构码取得
	 * @return 机构码
	 */
	public String getOrgid();
}