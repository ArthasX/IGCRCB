/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.smr.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 提醒信息表接口
  * 功能描述: 提醒信息表接口
  * 创建记录: 2013/08/05
  * 修改记录: 
  */
public interface RemindInfoInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getRiid();


	/**
	 * 用户id取得
	 *
	 * @return 用户id
	 */
	public String getRiuseid();

	/**
	 * 提醒信息取得
	 *
	 * @return 提醒信息
	 */
	public String getRiinfo();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getRistatus();

	/**
	 * 报表类型取得
	 *
	 * @return 报表类型
	 */
	public String getRitype();

}