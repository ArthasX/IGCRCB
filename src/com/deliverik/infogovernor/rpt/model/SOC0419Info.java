/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 卷组容量实时表接口
  * 功能描述: 卷组容量实时表接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将VGCapacityRealTimeInfo表名改为SOC0419Info
  */
public interface SOC0419Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getVgId();

	/**
	 * 卷组名取得
	 *
	 * @return 卷组名
	 */
	public String getVgName();

	/**
	 * 主机名取得
	 *
	 * @return 主机名
	 */
	public String getHostName();

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