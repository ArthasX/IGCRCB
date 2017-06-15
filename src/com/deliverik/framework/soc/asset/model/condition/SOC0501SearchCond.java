/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.soc.asset.model.condition;


/**
  * 概述: 表空间伐值设定检索条件接口
  * 功能描述: 表空间伐值设定检索条件接口
  * 创建记录:
  * 修改记录: 
  */
public interface SOC0501SearchCond {
	
	public String getPwdType() ;
	public String getUserName();
	public String getServerIP();
	public Integer getPid();

}