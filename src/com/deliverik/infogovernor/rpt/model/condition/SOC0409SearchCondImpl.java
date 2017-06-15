/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 主机pv实时表检索条件实现
  * 功能描述: 主机pv实时表检索条件实现
  * 创建记录: 2012/07/03
  * 修改记录: 2012/08/09 将PVHostRealTimeSearchCondImpl表名改为SOC0409SearchCondImpl
  */
public class SOC0409SearchCondImpl implements
		SOC0409SearchCond {
	protected String hostName_eq;
	protected String sName_eq;
	protected String[] hostName_notin;
	protected String[] sName_notin;

	/**
	 * hostName_eq取得
	 *
	 * @return hostName_eq hostName_eq
	 */
	public String getHostName_eq() {
		return hostName_eq;
	}

	/**
	 * hostName_eq设定
	 *
	 * @param hostName_eq hostName_eq
	 */
	public void setHostName_eq(String hostName_eq) {
		this.hostName_eq = hostName_eq;
	}

	/**
	 * sName_eq取得
	 *
	 * @return sName_eq sName_eq
	 */
	public String getSName_eq() {
		return sName_eq;
	}

	/**
	 * sName_eq设定
	 *
	 * @param name_eq sName_eq
	 */
	public void setSName_eq(String name_eq) {
		sName_eq = name_eq;
	}

	/**
	 * hostName_notin取得
	 *
	 * @return hostName_notin hostName_notin
	 */
	public String[] getHostName_notin() {
		return hostName_notin;
	}

	/**
	 * sName_notin取得
	 *
	 * @return sName_notin sName_notin
	 */
	public String[] getSName_notin() {
		return sName_notin;
	}

	/**
	 * hostName_notin设定
	 *
	 * @param hostName_notin hostName_notin
	 */
	public void setHostName_notin(String[] hostName_notin) {
		this.hostName_notin = hostName_notin;
	}

	/**
	 * sName_notin设定
	 *
	 * @param name_notin sName_notin
	 */
	public void setSName_notin(String[] name_notin) {
		sName_notin = name_notin;
	}
}