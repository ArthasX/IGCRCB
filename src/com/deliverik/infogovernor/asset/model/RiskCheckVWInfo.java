/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 检查工作统计报表接口
  * 功能描述: 检查工作统计报表接口
  * 创建记录: 2014/07/22
  * 修改记录: 
  */
public interface RiskCheckVWInfo extends BaseModel {

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
	 * 登记人id取得
	 *
	 * @return 登记人id
	 */
	public String getEiuserid();

	/**
	 * 登记人名字取得
	 *
	 * @return 登记人名字
	 */
	public String getEiusername();

	/**
	 * 检查项名称取得
	 *
	 * @return 检查项名称
	 */
	public String getEiname();

	/**
	 * 检查频度取得
	 *
	 * @return 检查频度
	 */
	public String getCheckpd();

	/**
	 * 检查项说明取得
	 *
	 * @return 检查项说明
	 */
	public String getEidesc();

}