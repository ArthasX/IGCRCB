/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * 概述: 检查工作检查任务关联表检索条件接口
  * 功能描述: 检查工作检查任务关联表检索条件接口
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public interface CheckworkInfoResultSearchCond {

	

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCwirid();

	/**
	 * 检查任务id取得
	 *
	 * @return 检查任务id
	 */
	public Integer getCwrid();

	/**
	 * 检查工作id取得
	 *
	 * @return 检查工作id
	 */
	public Integer getRcrid();

}