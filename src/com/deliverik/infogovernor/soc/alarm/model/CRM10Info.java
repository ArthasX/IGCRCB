/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM01接口
  * 功能描述: CRM01接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM10Info extends BaseModel {

	/**
	 * host取得
	 *
	 * @return host
	 */
	public String getHost();

	/**
	 * ip取得
	 *
	 * @return ip
	 */
	public String getIp();

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
	 * collecttime取得
	 *
	 * @return collecttime
	 */
	public String getCollecttime();

	/**
	 * command取得
	 *
	 * @return command
	 */
	public String getCommand();

	/**
	 * cdataorder取得
	 *
	 * @return cdataorder
	 */
	public Integer getCdataorder();

	/**
	 * cdata取得
	 *
	 * @return cdata
	 */
	public String getCdata();

	/**
	 * inserttime取得
	 *
	 * @return inserttime
	 */
	public String getInserttime();

	/**
	 * category取得
	 *
	 * @return category
	 */
	public String getCategory();

	/**
	 * keys取得
	 *
	 * @return keys
	 */
	public String getKeys();
	
	public String getObjectname();
	

}