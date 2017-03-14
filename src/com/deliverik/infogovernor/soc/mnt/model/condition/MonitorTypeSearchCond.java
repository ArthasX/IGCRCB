/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控类型表检索条件接口
  * 功能描述: 监控类型表检索条件接口
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
public interface MonitorTypeSearchCond {
	/**
	 * 树形层次码取得
	 * @return
	 */
	public String getMtSyscoding();
	
	/**
	 * 树形层次码类似获取
	 * @return
	 */
	public String getMtSyscoding_like();
}