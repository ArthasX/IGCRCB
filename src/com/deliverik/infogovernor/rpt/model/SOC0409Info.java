/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 主机pv实时表接口
  * 功能描述: 主机pv实时表接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVHostRealTimeInfo表名改为SOC0409Info
  */
public interface SOC0409Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPhId();

	/**
	 * 存储序列号取得
	 *
	 * @return 存储序列号
	 */
	public String getSName();

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
	 * 日期取得
	 *
	 * @return 日期
	 */
	public String getCreateDate();

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

}