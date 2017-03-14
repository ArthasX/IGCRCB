/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM09检索条件接口
  * 功能描述: CRM09检索条件接口
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public interface CRM09SearchCond {
	
	public String getServerid_eq();
	
	public Integer getRuletempid_eq();
	
	public Integer[] getRuletempids_notIn();
	

}