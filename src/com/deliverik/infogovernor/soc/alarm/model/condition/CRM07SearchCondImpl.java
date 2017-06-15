/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM07检索条件实现
  * 功能描述: CRM07检索条件实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM07SearchCondImpl implements
		CRM07SearchCond {
	
	/** 模板id */
	protected Integer ruletempid;

	public Integer getRuletempid() {
		return ruletempid;
	}

	public void setRuletempid(Integer ruletempid) {
		this.ruletempid = ruletempid;
	}

}