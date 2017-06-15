/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: mss00014接口
  * 功能描述: mss00014接口
  * 创建记录: 2014/01/21
  * 修改记录: 
  */
public interface Mss00014Info extends BaseModel {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * alarmip取得
	 *
	 * @return alarmip
	 */
	public String getAlarmip();

	/**
	 * happentime取得
	 *
	 * @return happentime
	 */
	public String getHappentime();

	/**
	 * count取得
	 *
	 * @return count
	 */
	public Integer getCount();

}