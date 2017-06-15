/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: MSGFILTER接口
  * 功能描述: MSGFILTER接口
  * 创建记录: 2013/08/21
  * 修改记录: 
  */
public interface MSGFILTERInfo extends BaseModel {

	/**
	 * id取得
	 *
	 * @return id
	 */
	public Integer getId();

	/**
	 * deviceip取得
	 *
	 * @return deviceip
	 */
	public String getDeviceip();

	/**
	 * state取得
	 *
	 * @return state
	 */
	public String getState();

}