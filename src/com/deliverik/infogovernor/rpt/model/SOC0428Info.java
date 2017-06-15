/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

/**
  * 概述: 业务系统视图接口
  * 功能描述: 业务系统视图接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将BusinessCapacityRealTimeVWInfo表名改为SOC0428Info
  */
public interface SOC0428Info {
	/**
	 * 业务系统ID取得
	 *
	 * @return 业务系统ID
	 */
	public Integer getBcid();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getSName();

	/**
	 * 业务系统名称取得
	 *
	 * @return bcName 业务系统名称
	 */
	public String getBcName();

	/**
	 * 已分配容量取得
	 *
	 * @return 已分配容量
	 */
	public Integer getAllottedCapacity();

}