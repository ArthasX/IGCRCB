/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 告警规则模板表接口
  * 功能描述: 告警规则模板表接口
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public interface Mss00004Info extends BaseModel {

	/**
	 * ruletempid取得
	 *
	 * @return ruletempid
	 */
	public Integer getRuletempid();

	/**
	 * devicetype取得
	 *
	 * @return devicetype
	 */
	public String getRuletempname();


	/**
	 * tempstate取得
	 *
	 * @return tempstate
	 */
	public Integer getTempstate();
	
	/**
	 * 设备类型取得
	 */
	public String getTypeid();
	
	/**
	 * 规则条件取得
	 */
	public Integer getRulecondition();
	
	/**
	 * 创建时间取得
	 */
	public String getCreatetime();
	
	/**
	 * 描述取得
	 */
	public String getTempdesc();
	
	public String getSummary();

}