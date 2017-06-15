/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控类型阀值信息检索条件实现
  * 功能描述: 监控类型阀值信息检索条件实现
  * 创建记录: 2012/02/07
  * 修改记录: 
  */
public class MonitorTypeDefSearchCondImpl implements
		MonitorTypeDefSearchCond {
	
	/** 监控类型id */
	protected String mtId;

	public String getMtId() {
		return mtId;
	}

	public void setMtId(String mtId) {
		this.mtId = mtId;
	}
}