/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model.condition;

/**
  * 概述: 检查策略关联检查项表检索条件接口
  * 功能描述: 检查策略关联检查项表检索条件接口
  * 创建记录: 2014/09/03
  * 修改记录: 
  */
public interface CheckInfoRiskSearchCond {
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getCieid();

	/**
	 * 检查策略id取得
	 *
	 * @return 检查策略id
	 */
	public Integer getCsid();

	/**
	 * 检查项id取得
	 *
	 * @return 检查项id
	 */
	public Integer getRcid();
}