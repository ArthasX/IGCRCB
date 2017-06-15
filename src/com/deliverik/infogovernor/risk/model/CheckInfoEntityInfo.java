/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 检查策略关联资产表接口
  * 功能描述: 检查策略关联资产表接口
  * 创建记录: 2014/09/02
  * 修改记录: 
  */
public interface CheckInfoEntityInfo extends BaseModel {

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
	 * 资产id取得
	 *
	 * @return 资产id
	 */
	public Integer getEiid();

	/**
	 * 资产版本取得
	 *
	 * @return 资产版本
	 */
	public Integer getEiversion();

}