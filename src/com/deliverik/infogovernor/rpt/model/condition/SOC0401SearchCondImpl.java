/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 数据库容量实时表检索条件实现
  * 功能描述: 数据库容量实时表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将DBCapacityRealTimeSearchCondImpl表名改为SOC0401SearchCondImpl
  */
public class SOC0401SearchCondImpl implements
		SOC0401SearchCond {
	/**主机名称*/
	protected String hostName_eq;

	/**
	 * 主机名称取得
	 *
	 * @return hostName_eq 主机名称
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}

	/**
	 * 主机名称设定
	 *
	 * @param hostName_eq 主机名称
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}
}