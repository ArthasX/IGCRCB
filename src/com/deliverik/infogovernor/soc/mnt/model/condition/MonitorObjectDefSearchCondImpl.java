/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控对象阀值信息表检索条件实现
  * 功能描述: 监控对象阀值信息表检索条件实现
  * 创建记录: 2012/02/08
  * 修改记录: 
  */
public class MonitorObjectDefSearchCondImpl implements
		MonitorObjectDefSearchCond {
	
	/**
	 * 监控对象id
	 */
	protected String moId;

	/**
	 * 监控对象id取得
	 * @return
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * 监控对象id设定
	 * @param moId
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}
}