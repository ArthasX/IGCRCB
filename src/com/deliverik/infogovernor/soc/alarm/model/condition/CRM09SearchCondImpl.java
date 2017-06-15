/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.alarm.model.condition;

/**
  * 概述: CRM09检索条件实现
  * 功能描述: CRM09检索条件实现
  * 创建记录: 2013/07/30
  * 修改记录: 
  */
public class CRM09SearchCondImpl implements
		CRM09SearchCond {
	
	protected String serverid_eq;
	
	protected Integer ruletempid_eq;
	
	protected Integer[] ruletempids_notIn;
	

	public Integer[] getRuletempids_notIn() {
		return ruletempids_notIn;
	}

	public void setRuletempids_notIn(Integer[] ruletempids_notIn) {
		this.ruletempids_notIn = ruletempids_notIn;
	}

	public String getServerid_eq() {
		return serverid_eq;
	}

	public void setServerid_eq(String serverid_eq) {
		this.serverid_eq = serverid_eq;
	}

	public Integer getRuletempid_eq() {
		return ruletempid_eq;
	}

	public void setRuletempid_eq(Integer ruletempid_eq) {
		this.ruletempid_eq = ruletempid_eq;
	}

}