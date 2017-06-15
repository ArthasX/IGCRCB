/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.dbm.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 全网IP过滤接口
  * 功能描述: 全网IP过滤接口
  * 创建记录: 2012/11/07
  * 修改记录: 
  */
public interface Ip_FilterInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * IP地址取得
	 *
	 * @return IP地址
	 */
	public String getIp();

	/**
	 * 添加时间取得
	 *
	 * @return 添加时间
	 */
	public String getAddtime();

}