/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: mss00009接口
  * 功能描述: mss00009接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00009Info extends BaseModel {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId();

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
	//告警确认时间
	public String getStarttime();
	//告警修复时间
	public String getEndtime();
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

	public Integer getPrid();
	
	public Integer getState();

}