/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rdp.model.condition;

/**
  * 概述: AutoTask检索条件接口
  * 功能描述: AutoTask检索条件接口
  * 创建记录: 2014/04/16
  * 修改记录: 
  */
public interface AutoTaskSearchCond {
	
	public Integer getSystemid_eq();

	public String getTaskName_like();

	public String getTime_from();

	public String getTime_to();

}