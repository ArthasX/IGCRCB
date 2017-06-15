/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;


/**
  * 概述: 日志信息检索条件接口
  * 功能描述: 日志信息检索条件接口
  * 创建记录:
  * 修改记录: 
  */
public interface SOC0153SearchCond {
	
	public Integer getCiType();
	public String getLogName();
	public String getLogStatus();
	public String getWarnType();
	public String getsDate();
	public String geteDate();
	public String getServerIP();

}