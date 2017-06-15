/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: CRM09接口
  * 功能描述: CRM09接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM09Info extends BaseModel {

	/**
	 * RELATIONID取得
	 *
	 * @return RELATIONID
	 */
	public Integer getRelationid();

	/**
	 * SERVERID取得
	 *
	 * @return SERVERID
	 */
	public Integer getServerid();

	/**
	 * RULETEMPID取得
	 *
	 * @return RULETEMPID
	 */
	public Integer getRuletempid();

	/**
	 * MAXALARMNUM取得
	 *
	 * @return MAXALARMNUM
	 */
	public Integer getMaxalarmnum();

	/**
	 * MAXALARMTIME取得
	 *
	 * @return MAXALARMTIME
	 */
	public Integer getMaxalarmtime();
	
	public String getCreatetime();

}