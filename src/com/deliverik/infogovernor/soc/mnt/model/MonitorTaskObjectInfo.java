/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 监控任务对象表接口
  * 功能描述: 监控任务对象表接口
  * 创建记录: 2012/05/10
  * 修改记录: 
  */
public interface MonitorTaskObjectInfo extends BaseModel {

	/**
	 * 流水ID取得
	 *
	 * @return 流水ID
	 */
	public Integer getMtoId();

	/**
	 * 任务ID取得
	 *
	 * @return 任务ID
	 */
	public Integer getMtId();

	/**
	 * 对象名称取得
	 *
	 * @return 对象名称
	 */
	public String getMtoName();

	/**
	 * 解析记录行数取得
	 *
	 * @return 解析记录行数
	 */
	public Integer getMtoRow();

}