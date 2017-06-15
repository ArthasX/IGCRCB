/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 存储lun实时表接口
  * 功能描述: 存储lun实时表接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVStorageRealTimeInfo表名改为SOC0410Info
  */
public interface SOC0410Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPsId();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getSName();

	/**
	 * lunid取得
	 *
	 * @return lunid
	 */
	public String getLunid();

	/**
	 * pv大小取得
	 *
	 * @return pv大小
	 */
	public Integer getPvSize();

	/**
	 * 是否被分配取得
	 *
	 * @return 是否被分配
	 */
	public String getIsUsed();

	/**
	 * 日期取得
	 *
	 * @return 日期
	 */
	public String getCreateDate();

}