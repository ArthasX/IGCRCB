/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控对象信息检索条件接口
  * 功能描述: 监控对象信息检索条件接口
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public interface MonitorObjectSearchCond {

	/**
	 * 监控类型id获取
	 * @return
	 */
	public String getMtSyscoding();
	
	/**
	 * 监控对象名称获取
	 * @return
	 */
	public String getMoName();
	
	/**
	 * 创建时间到获取
	 * @return
	 */
	public String getMoCreateTime_to();
	
	/**
	 * 创建时间从获取
	 * @return
	 */
	public String getMoCreateTime_from();
}