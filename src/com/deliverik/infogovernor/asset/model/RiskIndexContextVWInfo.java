/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 风险指标展示内容查询接口
  * 功能描述: 风险指标展示内容查询接口
  * 创建记录: 2014/07/26
  * 修改记录: 
  */
public interface RiskIndexContextVWInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRimid();

	/**
	 * 指标主键取得
	 *
	 * @return 指标主键
	 */
	public Integer getEiid();

	/**
	 * 计算方式取得
	 *
	 * @return 计算方式
	 */
	public String getRimtype();

	/**
	 * 存储sql取得
	 *
	 * @return 存储sql
	 */
	public String getRimsql();

	/**
	 * 风险名称取得
	 *
	 * @return 风险名称
	 */
	public String getEiname();

	/**
	 * 风险标号取得
	 *
	 * @return 风险标号
	 */
	public String getEilabel();

	/**
	 * 描述取得
	 *
	 * @return 描述
	 */
	public String getRimdesc();

	/**
	 * 分类取得
	 * @return esyscoding 分类
	 */
	public String getEsyscoding() ;
}