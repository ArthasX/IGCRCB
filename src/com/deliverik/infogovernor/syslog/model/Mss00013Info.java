/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: mss00013接口
  * 功能描述: mss00013接口
  * 创建记录: 2013/08/15
  * 修改记录: 
  */
public interface Mss00013Info extends BaseModel {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * deviceip取得
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

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

}