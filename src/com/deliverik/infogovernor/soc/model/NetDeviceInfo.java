/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 网络设备端口接口
  * 功能描述: 网络设备端口接口
  * 创建记录: 2013/12/30
  * 修改记录: 
  */
public interface NetDeviceInfo extends BaseModel{
	/**
	 * eiid取得
	 *
	 * @return eiid eiid
	 */
	public String getEiid();

	/**
	 * eilabel取得
	 *
	 * @return eilabel eilabel
	 */
	public String getEilabel();

	/**
	 * civalue取得
	 *
	 * @return civalue civalue
	 */
	public String getCivalue();

	/**
	 * eiupdtime取得
	 *
	 * @return eiupdtime eiupdtime
	 */
	public String getEiupdtime();
}