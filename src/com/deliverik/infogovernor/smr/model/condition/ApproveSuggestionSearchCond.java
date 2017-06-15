/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model.condition;

/**
  * 概述: 审批意见表检索条件接口
  * 功能描述: 审批意见表检索条件接口
  * 创建记录: 2013/07/22
  * 修改记录: 
  */
public interface ApproveSuggestionSearchCond {

	/**
	 * 流程主键取得
	 *
	 * @return prid_eq 流程主键
	 */
	public Integer getPrid_eq();

	/**
	 * 表单定义主键取得
	 *
	 * @return pidid_eq 表单定义主键
	 */
	public String getPidid_eq();
	
	/**
	 * 意见状态取得
	 *
	 * @return status_eq 意见状态
	 */
	public String getStatus_eq();
	
	/**
	 * 流程状态标识取得
	 *
	 * @return psdcode_eq 流程状态标识
	 */
	public String getPsdcode_eq();
	
	/**
	 * 表格式表单行号取得
	 * @return rownumber_eq 表格式表单行号
	 */
	public String getRownumber_eq();
}