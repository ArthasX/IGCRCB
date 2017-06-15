/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM02接口
  * 功能描述: CRM02接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM02Info extends BaseModel {

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
	 * status取得
	 *
	 * @return status
	 */
	public String getStatus();

}