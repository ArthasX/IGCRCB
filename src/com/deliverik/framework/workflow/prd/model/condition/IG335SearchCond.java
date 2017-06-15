/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;

/**
  * 概述: 表单策略表检索条件接口
  * 功能描述: 表单策略表检索条件接口
  * 创建记录: 2013/09/03
  * 修改记录: 
  */
public interface IG335SearchCond {
	/**
	 * 状态定义ID取得
	 * @return psdid_eq 状态定义ID
	 */
	public String getPsdid_eq() ;

	/**
	 * 状态定义IDLike取得
	 * @return psdid_like 状态定义IDLike
	 */
	public String getPsdid_like();
	
	/**
	 * 表单定义ID取得
	 * @return pidid_eq 表单定义ID
	 */
	public String getPidid_eq();

	/**
	 * 表单值取得
	 * @return pivalue_eq 表单值
	 */
	public String getPivalue_eq();
	
	/** 
     * 表单定义ID 取得
     * @return pidid_like 表单定义ID 
     */
    public String getPidid_like();

	/**
	 * 流程定义ID(完全匹配)取得
	 * @return pdid_eq 流程定义ID(完全匹配)
	 */
	public String getPdid_eq();
	
	/**
	 * 流程定义ID(模糊匹配)取得
	 * @return pdid_like 流程定义ID(模糊匹配)
	 */
	public String getPdid_like();

}