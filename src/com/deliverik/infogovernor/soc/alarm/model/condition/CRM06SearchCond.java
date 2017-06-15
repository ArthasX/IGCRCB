/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM06检索条件接口
  * 功能描述: CRM06检索条件接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM06SearchCond {
	
	public String getServerName_like();


	public String getIp_like();
	
	public String getFileid_eq();

	public String getServerName();

}