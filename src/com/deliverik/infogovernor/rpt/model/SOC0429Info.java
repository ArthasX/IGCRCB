/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;


/**
  * 概述: 主机容量视图接口
  * 功能描述: 主机容量视图接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将HostCapacityRealTimeVWInfo表名改为SOC0429Info
  */
public interface SOC0429Info{

	/**
	 * 主机名字取得
	 *
	 * @return 主机名字
	 */
	public String getHostName();

	/**
	 * 业务系统id取得
	 *
	 * @return 业务系统id
	 */
	public Integer getBcid();
	/**
	 * 业务系统名称取得
	 *
	 * @return bcName 业务系统名称
	 */
	public String getBcName();

	/**
	 * 存储名字取得
	 *
	 * @return 存储名字
	 */
	public String getSName();

	/**
	 * 记录时间取得
	 *
	 * @return 记录时间
	 */
	public String getCreateDate();

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

}