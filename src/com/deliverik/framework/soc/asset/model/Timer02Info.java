/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: timer02接口
  * 功能描述: timer02接口
  * 创建记录: 2013/07/04
  * 修改记录: 
  */
public interface Timer02Info extends BaseModel {

	/**
	 * uuid取得
	 *
	 * @return uuid
	 */
	public String getUuid();

	/**
	 * name取得
	 *
	 * @return name
	 */
	public String getName();

	/**
	 * type取得
	 *
	 * @return type
	 */
	public String getTypename();

	/**
	 * collectdate取得
	 *
	 * @return collectdate
	 */
	public String getCollectdate();

	/**
	 * executrule取得
	 *
	 * @return executrule
	 */
	public String getExecutrule();

	/**
	 * periodtype取得
	 *
	 * @return periodtype
	 */
	public String getPeriodtype();

	/**
	 * executstatus取得
	 *
	 * @return executstatus
	 */
	public String getExecutstatus();
	
	public String getExecutmessage();

}