/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.ven.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险策略指标关系表接口
  * 功能描述: 风险策略指标关系表接口
  * 创建记录: 2014/12/01
  * 修改记录: 
  */
public interface StrategyIndexRelationInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getSirid();

	/**
	 * 风险策略id取得
	 *
	 * @return 风险策略id
	 */
	public Integer getRsid();

	/**
	 * 风险指标id取得
	 *
	 * @return 风险指标id
	 */
	public Integer getRiid();

}