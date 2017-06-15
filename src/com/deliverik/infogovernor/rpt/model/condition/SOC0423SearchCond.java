/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.rpt.model.condition;

/**
  * 概述: 容量对象表检索条件接口
  * 功能描述: 容量对象表检索条件接口
  * 创建记录: 2012/07/17
  * 修改记录: 2012/08/09 将CapacityObjectListSearchCond表名改为SOC0423SearchCond
  */
public interface SOC0423SearchCond {
	
	public String getName();

	public String getObjectType();
	
	public String getObjectName();

	public String getName_like();
	
	public Integer getStatus();
}