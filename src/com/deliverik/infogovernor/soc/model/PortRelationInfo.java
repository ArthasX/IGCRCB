/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 端到端关系表接口
  * 功能描述: 端到端关系表接口
  * 创建记录: 2013/01/17
  * 修改记录: 
  */
public interface PortRelationInfo extends BaseModel {

	/**
	 * HBAPort_WWN取得
	 *
	 * @return HBAPort_WWN
	 */
	public String getHBAPort_WWN();

	/**
	 * DevicesName取得
	 *
	 * @return DevicesName
	 */
	public String getDevicesName();

	/**
	 * SymmetrixID取得
	 *
	 * @return SymmetrixID
	 */
	public String getSymmetrixID();

	/**
	 * FAName取得
	 *
	 * @return FAName
	 */
	public String getFAName();

	/**
	 * FAPortName取得
	 *
	 * @return FAPortName
	 */
	public String getFAPortName();

	/**
	 * HyperType取得
	 *
	 * @return HyperType
	 */
	public String getHyperType();

}