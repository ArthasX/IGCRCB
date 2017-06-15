/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
  * 概述: MSGFILTER检索条件接口
  * 功能描述: MSGFILTER检索条件接口
  * 创建记录: 2013/08/21
  * 修改记录: 
  */
public interface MSGFILTERSearchCond {
	public Integer[] getIds();
	public String getDeviceip();
	public String getState();
}