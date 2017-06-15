/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model.condition;

/**
  * 概述: 网络设备端口检索条件接口
  * 功能描述: 网络设备端口检索条件接口
  * 创建记录: 2013/12/30
  * 修改记录: 
  */
public interface NetDeviceSearchCond {
	/**
	 * eilabel_lk_devname取得
	 *
	 * @return eilabel_lk_devname eilabel_lk_devname
	 */
	public String getEilabel_lk_devname();
	/**
	 * eilabel_lk_ip取得
	 *
	 * @return eilabel_lk_ip eilabel_lk_ip
	 */
	public String getEilabel_lk_ip();
	/**
	 * civalue_eq取得
	 *
	 * @return civalue_eq civalue_eq
	 */
	public String getCivalue_eq();
}