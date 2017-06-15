/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 检查策略关联检查项表接口
  * 功能描述: 检查策略关联检查项表接口
  * 创建记录: 2014/09/03
  * 修改记录: 
  */
public interface CheckInfoRiskInfo extends BaseModel {

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