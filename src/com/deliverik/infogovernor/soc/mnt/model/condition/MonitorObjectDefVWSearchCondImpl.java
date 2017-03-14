/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.condition;

/**
  * 概述: 监控对象KPI信息视图检索条件实现
  * 功能描述: 监控对象KPI信息视图检索条件实现
  * 创建记录: 2012/02/13
  * 修改记录: 
  */
public class MonitorObjectDefVWSearchCondImpl implements
		MonitorObjectDefVWSearchCond {
	
	/** 监控对象名称 */
	protected String moName;
	
	/** 状态 */
	protected String deleteFlag;
	
	/**
	 * 监控对象名称取得
	 *
	 * @return 监控对象名称
	 */
	public String getMoName() {
		return moName;
	}

	/**
	 * 监控对象名称设定
	 *
	 * @param moName 监控对象名称
	 */
	public void setMoName(String moName) {
		this.moName = moName;
	}
	
	/**
	 * 状态取得
	 *
	 * @return 状态
	 */
	public String getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * 状态设定
	 *
	 * @param deleteFlag 状态
	 */
	public void setDeleteFlag(String deleteFlag) {
		this.deleteFlag = deleteFlag;
	}

}