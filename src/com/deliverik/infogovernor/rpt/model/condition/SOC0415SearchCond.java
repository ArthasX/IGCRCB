/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 表空间容量实时表检索条件接口
  * 功能描述: 表空间容量实时表检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/10 将TSCapacityRealTimeSearchCond表名修改为SOC0415SearchCond
  */
public interface SOC0415SearchCond {
	/**
	 * 数据库名字等于取得
	 *
	 * @return dbName_eq 数据库名字等于
	 */
	public String getDbName_eq();
	/**
	 * 主机名字等于取得
	 *
	 * @return hostName_eq 主机名字等于
	 */
	public String getHostName_eq();
}