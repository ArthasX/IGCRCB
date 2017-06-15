/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 检查项到风险点关系模型接口
  * 功能描述: 检查项到风险点关系模型接口
  * 创建记录: 2014/07/23
  * 修改记录: 
  */
public interface CheckToRiskRelateVWInfo extends BaseModel {

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
	 * 风险级别取得
	 *
	 * @return 风险级别
	 */
	public String getLevels();

	/**
	 * 风险严重等级取得
	 *
	 * @return 风险严重等级
	 */
	public String getGrad();

	/**
	 * 检查项名称取得
	 *
	 * @return 检查项名称
	 */
	public String getEiname();

	/**
	 * 风险点标志取得
	 *
	 * @return 风险点标志
	 */
	public String getRisksign();

	/**
	 * 风险发生可能取得
	 *
	 * @return 风险发生可能
	 */
	public String getPoss();

	/**
	 * 检查项说明取得
	 *
	 * @return 检查项说明
	 */
	public String getEidesc();

}