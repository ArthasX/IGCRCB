/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 表空间容量实时表接口
  * 功能描述: 表空间容量实时表接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将TSCapacityRealTimeInfo表名改为SOC0415Info
  */
public interface SOC0415Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getTsId();

	/**
	 * 表空间名取得
	 *
	 * @return 表空间名
	 */
	public String getTsName();

	/**
	 * 主机名取得
	 *
	 * @return 主机名
	 */
	public String getHostName();

	/**
	 * 数据库名取得
	 *
	 * @return 数据库名
	 */
	public String getDbName();

	/**
	 * 日期取得
	 *
	 * @return 日期
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

	/**
	 * 已使用容量取得
	 *
	 * @return 已使用容量
	 */
	public Integer getUsedCapacity();

}