/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.prr.model.condition;

/**
  * 概述: 抄阅人表检索条件接口
  * 功能描述: 抄阅人表检索条件接口
  * 创建记录: 2013/02/25
  * 修改记录: 
  */
public interface CopyReadUserSearchCond {

	/**
	 * 流程名称取得
	 *
	 * @return 流程名称
	 */
	public String getPrtitle() ;
	
	/**
	 * 是否查看标识取得
	 *
	 * @return 是否查看标识
	 */
	public String getIslook();
	
	
	/**
	 * 处理人id取得
	 *
	 * @return 处理人id
	 */
	public String getPruserid ();
	
	/**
	 * 流程主键取得
	 *
	 * @return 流程主键
	 */
	public Integer getPrid();
}