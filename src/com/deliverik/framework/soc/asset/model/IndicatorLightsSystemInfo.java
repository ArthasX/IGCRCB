/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 告警系统显示信息表接口
  * 功能描述: 告警系统显示信息表接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface IndicatorLightsSystemInfo extends BaseModel {

	/**
	 * 无意思主键取得
	 *
	 * @return 无意思主键
	 */
	public Integer getIlsid();

	/**
	 * 系统名称取得
	 *
	 * @return 系统名称
	 */
	public String getIlsname();

	/**
	 * 位置X取得
	 *
	 * @return 位置X
	 */
	public Integer getIlsplacex();

	/**
	 * 位置Y取得
	 *
	 * @return 位置Y
	 */
	public Integer getIlsplacey();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getIlsstatus();

}