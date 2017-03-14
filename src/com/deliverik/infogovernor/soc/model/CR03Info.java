/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 配置原数据与主机关系表接口
  * 功能描述: 配置原数据与主机关系表接口
  * 创建记录: 2013/04/08
  * 修改记录: 
  */
public interface CR03Info extends BaseModel {


	/**
	 * 分区表名取得
	 *
	 * @return 分区表名
	 */
	public String getTablename();

	/**
	 * 主机标识取得
	 *
	 * @return 主机标识
	 */
	public String getHost();
	
	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus();

	/**
	 * 类型取得
	 * @return 类型
	 */
	public Integer getType();
	
	
	/**
	 * IP取得
	 * @return
	 */
	public String getIp();
	
	
	public String getCollecttime();
	
	/**
	 * servername取得
	 * @return
	 */
	public String getServername();

}