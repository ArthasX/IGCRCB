/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: mss00011接口
  * 功能描述: mss00011接口
  * 创建记录: 2013/04/16
  * 修改记录: 
  */
public interface Mss00011Info extends BaseModel {

	/**
	 * deviceid取得
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

	/**
	 * devicename取得
	 *
	 * @return devicename
	 */
	public String getDevicename();

	/**
	 * devicetype取得
	 *
	 * @return devicetype
	 */
	public String getDevicetype();

	/**
	 * tempcounts取得
	 *
	 * @return tempcounts
	 */
	public Integer getTempcounts();

	/**
	 * devicestate取得
	 *
	 * @return devicestate
	 */
	public Integer getDevicestate();

	/**
	 * devicedesc取得
	 *
	 * @return devicedesc
	 */
	public String getDevicedesc();
	
	public String getTypeid();

}