/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 主机pv实时表检索条件接口
  * 功能描述: 主机pv实时表检索条件接口
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVHostRealTimeSearchCond表名改为SOC0409SearchCond
  */
public interface SOC0409SearchCond {
	/**
	 * hostName_eq取得
	 *
	 * @return hostName_eq hostName_eq
	 */
	public String getHostName_eq();
	/**
	 * sName_eq取得
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq();
	/**
	 * sName_notin取得
	 *
	 * @return sName_notin sName_notin
	 */
	public String[] getSName_notin();
	/**
	 * hostName_notin取得
	 *
	 * @return hostName_notin hostName_notin
	 */
	public String[] getHostName_notin();
}