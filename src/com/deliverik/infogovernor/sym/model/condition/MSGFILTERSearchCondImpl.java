/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.sym.model.condition;

/**
  * 概述: MSGFILTER检索条件实现
  * 功能描述: MSGFILTER检索条件实现
  * 创建记录: 2013/08/21
  * 修改记录: 
  */
public class MSGFILTERSearchCondImpl implements
		MSGFILTERSearchCond {
	
	public Integer[] getIds() {
		return ids;
	}

	public void setIds(Integer[] ids) {
		this.ids = ids;
	}

	public String getDeviceip() {
		return deviceip;
	}

	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	protected Integer[] ids;

	/** deviceip */
	protected String deviceip;

	/** state */
	protected String state;

}