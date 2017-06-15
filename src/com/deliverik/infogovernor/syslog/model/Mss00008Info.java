/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: SYSLOG信息表接口
  * 功能描述: SYSLOG信息表接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00008Info extends BaseModel {

	/**
	 * ID取得
	 *
	 * @return ID
	 */
	public Integer getID();

	/**
	 * deviceid取得
	 *
	 * @return deviceid
	 */
	public Integer getDeviceid();

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
	 * rulelevel取得
	 *
	 * @return rulelevel
	 */
	public String getRulelevel();

	/**
	 * alarmmsg取得
	 *
	 * @return alarmmsg
	 */
	public String getAlarmmsg();

	/**
	 * isalarm取得
	 *
	 * @return isalarm
	 */
	public Integer getIsalarm();
	
	/**
	 * createtime取得
	 * 
	 * @return createtime
	 */
	public String getCreatetime();
	
	/**
	 * 
	 * @return
	 */
	public String getStarttime();
	
}