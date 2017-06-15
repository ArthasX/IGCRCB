/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 告警系统显示区域表接口
  * 功能描述: 告警系统显示区域表接口
  * 创建记录: 2014/03/05
  * 修改记录: 
  */
public interface IndicatorLightsXmlInfo extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getIxid();

	/**
	 * 区域名称取得
	 *
	 * @return 区域名称
	 */
	public String getIxtitle();

	/**
	 * 位置X坐标取得
	 *
	 * @return 位置X坐标
	 */
	public String getIxplacex();

	/**
	 * 位置Y坐标取得
	 *
	 * @return 位置Y坐标
	 */
	public String getIxplacey();

	/**
	 * 宽度取得
	 *
	 * @return 宽度
	 */
	public Integer getIxwidth();

	/**
	 * 高度取得
	 *
	 * @return 高度
	 */
	public Integer getIxheight();

	/**
	 * rotation取得
	 *
	 * @return rotation
	 */
	public String getRotation();

}