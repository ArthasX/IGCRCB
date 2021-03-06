/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 设备信息表接口
  * 功能描述: 设备信息表接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00001Info extends BaseModel {

	/**
	 * deviceid取得
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

	/**
	 * typeid取得
	 *
	 * @return typeid
	 */
	public String getTypeid();

	/**
	 * deviceip取得
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

	/**
	 * devicename取得
	 *
	 * @return devicename
	 */
	public String getDevicename();

	/**
	 * devicedesc取得
	 *
	 * @return devicedesc
	 */
	public String getDevicedesc();

	/**
	 * devicestate取得
	 *
	 * @return devicestate
	 */
	public Integer getDevicestate();
	
	public String getDeviceip2();

}