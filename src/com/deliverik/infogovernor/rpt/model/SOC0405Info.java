/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 逻辑卷容量实时表接口
  * 功能描述: 逻辑卷容量实时表接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将LVCapacityRealTimeInfo表名改为SOC0405Info
  */
public interface SOC0405Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getLvId();

	/**
	 * 主机名取得
	 *
	 * @return 主机名
	 */
	public String getHostName();

	/**
	 * 卷组名取得
	 *
	 * @return 卷组名
	 */
	public String getVgName();

	/**
	 * 逻辑卷类型取得
	 *
	 * @return 逻辑卷类型
	 */
	public String getLvType();

	/**
	 * 逻辑卷名取得
	 *
	 * @return 逻辑卷名
	 */
	public String getLvName();

	/**
	 * 逻辑卷大小取得
	 *
	 * @return 逻辑卷大小
	 */
	public Integer getLvSize();

	/**
	 * 逻辑卷状态取得
	 *
	 * @return 逻辑卷状态
	 */
	public String getLvState();

	/**
	 * 文件系统名取得
	 *
	 * @return 文件系统名
	 */
	public String getFsName();

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