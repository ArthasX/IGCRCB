/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.asset.model.condition;

/**
  * 概述: 任务表检索条件实现
  * 功能描述: 任务表检索条件实现
  * 创建记录: 2011/05/18
  * 修改记录: 
  */
public class CITaskSearchCondImpl implements
		CITaskSearchCond {
	
	/** 任务描述 */
	protected String citdesc_like;

	/** 开始时间*/
	protected String cittime_from;
	
	/** 结束时间*/
	protected String cittime_to;
	
	/** 状态 */
	protected String citstatus_eq;
	
	/**
	 * 任务描述取得
	 * @return 任务描述
	 */
	public String getCitdesc_like() {
		return citdesc_like;
	}

	/**
	 * 任务描述设定
	 * @param citdesc任务描述
	 */

	public void setCitdesc_like(String citdesc_like) {
		this.citdesc_like = citdesc_like;
	}

	/**
	 * 开始时间取得
	 * @return 开始时间
	 */
	public String getCittime_from() {
		return cittime_from;
	}

	/**
	 * 开始时间设定
	 * @param cittime_from开始时间
	 */
	public void setCittime_from(String cittime_from) {
		this.cittime_from = cittime_from;
	}

	/**
	 * 结束时间取得
	 * @return 结束时间
	 */
	public String getCittime_to() {
		return cittime_to;
	}

	/**
	 * 结束时间设定
	 * @param cittime_to结束时间
	 */
	public void setCittime_to(String cittime_to) {
		this.cittime_to = cittime_to;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getCitstatus_eq() {
		return citstatus_eq;
	}

	/**
	 * 状态设定
	 * @param citstatus_eq 状态
	 */
	public void setCitstatus_eq(String citstatus_eq) {
		this.citstatus_eq = citstatus_eq;
	}
	
}