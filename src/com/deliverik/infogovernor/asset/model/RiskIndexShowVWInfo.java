/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险指标展示查询接口
  * 功能描述: 风险指标展示查询接口
  * 创建记录: 2014/07/25
  * 修改记录: 
  */
public interface RiskIndexShowVWInfo extends BaseModel {

	/**
	 * 分类层次码取得
	 *
	 * @return 分类层次码
	 */
	public String getEsyscoding();

	/**
	 * 条数取得
	 *
	 * @return 条数
	 */
	public String getRisknum();

	/**
	 * 风险整体取得
	 *
	 * @return 风险整体
	 */
	public String getRisk();

	/**
	 * 风险领域取得
	 *
	 * @return 风险领域
	 */
	public String getRiskly();

	/**
	 * 风险子域取得
	 *
	 * @return 风险子域
	 */
	public String getRiskarea();

	/**
	 * 风险项取得
	 *
	 * @return 风险项
	 */
	public String getRiskitem();

}