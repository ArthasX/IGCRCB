/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 审计对比结果信息表检索条件接口
  * 功能描述: 审计对比结果信息表检索条件接口
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public interface AuditResultSearchCond {

	/**
	 * 审计时间戳 开始取得
	 * @return 审计时间戳 开始
	 */
	public String getAutupdtime();

	/**
	 * 审计时间戳 结束取得
	 * @return 审计时间戳 结束
	 */
	public String getAutcomptime();
	
	/**
	 * 审计任务描述取得
	 * @return 审计任务描述
	 */
	public Integer getAutid();
	
	/**
	 * 资产层次码取得
	 * @return 资产层次码
	 */
	public String getEsyscoding();

}