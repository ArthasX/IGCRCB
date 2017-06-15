/*
 * 北京递蓝科软件股份有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wki.model.condition;

/**
  * 概述: 工作信息检索条件接口
  * 功能描述: 工作信息检索条件接口
  * 创建记录: 2017/03/02
  * 修改记录: 
  */
public interface WorkinfoSearchCond {
	
	
	public Integer getWorkInfoId();
	 
	public String getWorkName();
	 
	public Integer getInitId();

	public String getInitName();
	
	public Integer getExecId();
	
	public String getExecName();
	
}