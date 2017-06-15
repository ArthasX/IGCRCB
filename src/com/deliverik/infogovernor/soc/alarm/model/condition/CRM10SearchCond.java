/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM01检索条件接口
  * 功能描述: CRM01检索条件接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM10SearchCond {
  
	public String getIp();//ip
	
	public String getGet_StartTime() ;//开始时间
		
	public String getGet_EndTime() ;//结束时间
		
	public String getSymType() ;//设备类型
	
    public String getTablename();//
	
    public String getNowCollecttime();

}