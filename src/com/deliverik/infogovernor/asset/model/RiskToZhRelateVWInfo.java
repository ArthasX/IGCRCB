/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险到指标关系接口
  * 功能描述: 风险到指标关系接口
  * 创建记录: 2014/07/24
  * 修改记录: 
  */
public interface RiskToZhRelateVWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getEiid();

	/**
	 * eid取得
	 *
	 * @return eid
	 */
	public String getEid();

	/**
	 * 编号取得
	 *
	 * @return 编号
	 */
	public String getEilabel();

	/**
	 * 阀值取得
	 *
	 * @return 阀值
	 */
	public String getThreshold();

	/**
	 * 风险指标名称取得
	 *
	 * @return 风险指标名称
	 */
	public String getEiname();

	/**
	 * 是否关键指标取得
	 *
	 * @return 是否关键指标
	 */
	public String getKeyindex();

	/**
	 * 风险指标说明取得
	 *
	 * @return 风险指标说明
	 */
	public String getEidesc();

}