/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model;


/**
  * 概述: 监控对象KPI信息视图接口
  * 功能描述: 监控对象KPI信息视图接口
  * 创建记录: 2012/02/13
  * 修改记录: 
  */
public interface MonitorObjectDefVWInfo {

	/**
	 * 主键id取得
	 *
	 * @return 主键id
	 */
	public Integer getModid();

	/**
	 * 监控对象名称取得
	 *
	 * @return 监控对象名称
	 */
	public String getMoName();

	/**
	 * 监控类型名称取得
	 *
	 * @return 监控类型名称
	 */
	public String getMtName();

	/**
	 * 监控类型层次码取得
	 *
	 * @return 监控类型层次码
	 */
	public String getMtSyscoding();

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
	 * 比较符号取得
	 * @return 比较符号
	 */
	public String getCompare();
	
	/**
	 * 描述取得
	 * @return
	 */
	public String getModDes();

}