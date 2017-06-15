/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;

import com.deliverik.framework.base.BaseModel;

/**
  * 概述: 监控对象阀值信息表接口
  * 功能描述: 监控对象阀值信息表接口
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
public interface MonitorObjectDefInfo extends BaseModel {

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getModId();

	/**
	 * 监控对象id取得
	 *
	 * @return 监控对象id
	 */
	public Integer getMoId();

	/**
	 * 创建时间取得
	 *
	 * @return 创建时间
	 */
	public String getModCreateTime();

	/**
	 * 监控对象阀值名称取得
	 *
	 * @return 监控对象阀值名称
	 */
	public String getModName();

	/**
	 * 监控对象阀值取得
	 *
	 * @return 监控对象阀值
	 */
	public String getModValue();

	/**
	 * 排序号取得
	 *
	 * @return 排序号
	 */
	public Integer getOrderNumber();

	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag();
	
	/**
	 * 描述取得
	 * @return
	 */
	public String getModDes();
	
	/**
	 * 比较符取得
	 * @return
	 */
	public String getCompare();

}