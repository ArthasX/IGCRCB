/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.model.condition;


/**
  * 概述: 流程状态按钮定义表检索条件接口
  * 功能描述: 流程状态按钮定义表检索条件接口
  * 创建记录: 2012/04/13
  * 修改记录: 
  */
public interface IG156SearchCond {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public String getPseid();


	/**
	 * 流程定义ID取得
	 *
	 * @return 流程定义ID
	 */
	public String getPdid();


	/**
	 * 流程状态取得
	 *
	 * @return 流程状态
	 */
	public String getPsdid();


	/**
	 * 动作ID取得
	 *
	 * @return 动作ID
	 */
	public String getPseactionid();


	/**
	 * 排序ID取得
	 *
	 * @return 排序ID
	 */
	public Integer getPseorder();


	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getPsedec();
	
	
	public String getPsebuttonid();

	/**
	 * 主键取得
	 * 
	 * @return 主键
	 */
	public String getPseid_like();
}