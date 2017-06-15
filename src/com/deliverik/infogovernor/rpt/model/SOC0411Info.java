/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 存储容量实时表接口
  * 功能描述: 存储容量实时表接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将StorageCapacityRealTimeInfo表名改为SOC0411Info
  */
public interface SOC0411Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getScid();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getSName();

	/**
	 * 日期取得
	 *
	 * @return 日期
	 */
	public String getCreateDate();

	/**
	 * 裸容量取得
	 *
	 * @return 裸容量
	 */
	public Integer getRawCapacity();

	/**
	 * 有效容量取得
	 *
	 * @return 有效容量
	 */
	public Integer getEffectiveCapacity();

	/**
	 * 冗余容量取得
	 *
	 * @return 冗余容量
	 */
	public Integer getRedundancyCapacity();

	/**
	 * 已分配容量取得
	 *
	 * @return 已分配容量
	 */
	public Integer getAllottedCapacity();

	/**
	 * 空闲容量取得
	 *
	 * @return 空闲容量
	 */
	public Integer getFreeCapacity();

	/**
	 * 磁盘个数取得
	 *
	 * @return 磁盘个数
	 */
	public Integer getDiskCount();

}