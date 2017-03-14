/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: DMX实时监控性能表接口D MXRealTimeInfo
  * 功能描述: DMX实时监控性能表接口 DMXRealTimeInfo
  * 创建记录: 2012/05/16
  * 修改记录: 
  */
public interface SOC0301Info extends BaseModel {

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getId();

	/**
	 * 监控任务id取得
	 *
	 * @return 监控任务id
	 */
	public Integer getMtId();

	/**
	 * 监控对象名取得
	 *
	 * @return 监控对象名
	 */
	public String getMtoName();

	/**
	 * 性能指标取得
	 *
	 * @return 性能指标
	 */
	public String getMtKpi();

	/**
	 * 性能指标值取得
	 *
	 * @return 性能指标值
	 */
	public Double getKpiValue();

	/**
	 * 解析时间点取得
	 *
	 * @return 解析时间点
	 */
	public String getTimeStamp();

}