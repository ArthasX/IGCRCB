/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 表空间容量实时表检索条件实现
  * 功能描述: 表空间容量实时表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/10 将TSCapacityRealTimeSearchCondImpl表名修改为SOC0415SearchCondImpl
  */
public class SOC0415SearchCondImpl implements
		SOC0415SearchCond {
	/**数据库名字等于*/
	protected String dbName_eq;
	/**主机名字等于*/
	protected String hostName_eq;
	/**
	 * 数据库名字等于取得
	 *
	 * @return dbName_eq 数据库名字等于
	 */
	public String getDbName_eq() {
		return dbName_eq;
	}
	/**
	 * 数据库名字等于设定
	 *
	 * @param dbName_eq 数据库名字等于
	 */
	public void setDbName_eq(String dbName_eq) {
		this.dbName_eq = dbName_eq;
	}
	/**
	 * 主机名字等于取得
	 *
	 * @return hostName_eq 主机名字等于
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}
	/**
	 * 主机名字等于设定
	 *
	 * @param hostName_eq 主机名字等于
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}
	
	
}