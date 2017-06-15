/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * 概述: 日志信息检索条件接口
  * 功能描述: 日志信息检索条件接口
  * 创建记录: 2014/05/06
  * 修改记录: 
  */
public interface RealtimedetailSearchCond {
	
	/**
	 * 任务ID
	 * @return
	 */
	public Integer getTaskid();
	/**
	 * 主机IP
	 * @return
	 */
	public String getHostip();
	/**
	 * 主键大于
	 * @return
	 */
	public Integer getRtdid_gt();

}