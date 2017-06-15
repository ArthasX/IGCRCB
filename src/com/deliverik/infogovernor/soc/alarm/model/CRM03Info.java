/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM03接口
  * 功能描述: CRM03接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM03Info extends BaseModel {

	/**
	 * collecttime取得
	 *
	 * @return collecttime
	 */
	public String getCollecttime();

	/**
	 * tablename取得
	 *
	 * @return tablename
	 */
	public String getTablename();

	/**
	 * host取得
	 *
	 * @return host
	 */
	public String getHost();

	/**
	 * status取得
	 *
	 * @return status
	 */
	public String getStatus();

	/**
	 * type取得
	 *
	 * @return type
	 */
	public String getType();

	/**
	 * servername取得
	 *
	 * @return servername
	 */
	public String getServername();

	/**
	 * servertype取得
	 *
	 * @return servertype
	 */
	public Integer getServertype();

	/**
	 * ip取得
	 *
	 * @return ip
	 */
	public String getIp();

}