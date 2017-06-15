/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 通知策略基本信息检索条件接口
  * 功能描述: 通知策略基本信息检索条件接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG334SearchCond {

	/**
	 * 流程类型ID模糊查询取得
	 *
	 * @return pdid_like 流程类型ID模糊查询
	 */
	public String getPdid_like();

	
	/**
	 * 根据流程类型ID等值查询
	 * @return
	 */
	public String getPdid_eq();

	/**
	 * 流程表单ID(完全匹配)取得
	 * @return pidid_eq 流程表单ID(完全匹配)
	 */
	public String getPidid_eq();
	
	/**
	 * 流程表单ID(模糊匹配)取得
	 * @return pidid_like 流程表单ID(模糊匹配)
	 */
	public String getPidid_like();

}