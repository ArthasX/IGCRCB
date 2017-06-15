/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * 概述: 工作实例检索条件实现
  * 功能描述: 工作实例检索条件实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkInstanceSearchCondImpl implements
		WorkInstanceSearchCond {

	/**
	 * 工作实例名称
	 */
	protected String winame;

	/**
	 * 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 */
	protected Integer wistatus;

	/**
	 * 部门（id）
	 */
	protected String wiDepartmentid;

	/**
	 * 人员（userid）
	 */
	protected String wiuserid;

	/**
	 * 发起类型（1，自动发起；2，手动发起）
	 */
	protected String wiLunchType;

	/**
	 * 执行需所时间（小时）
	 */
	protected String excuteTime;

	/**
	 * 实际处理日期 
	 */
	protected String actualDealwithDate;

	/**
	 * 工作确认日期
	 */
	protected String confirmDate;

	/**
	 * 日期栏日期
	 */
	protected String titleDate;

	/**
	 * 表记录创建日期
	 */
	protected String crtDate;

	/**
	 * 工作实例名称取得
	 *
	 * @return 工作实例名称
	 */
	public String getWiname() {
		return winame;
	}

	/**
	 * 工作实例名称设定
	 *
	 * @param 工作实例名称
	 */
	public void setWiname(String winame) {
		this.winame = winame;
	}

	/**
	 * 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）取得
	 *
	 * @return 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 */
	public Integer getWistatus() {
		return wistatus;
	}

	/**
	 * 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）设定
	 *
	 * @param 工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
	 */
	public void setWistatus(Integer wistatus) {
		this.wistatus = wistatus;
	}

	/**
	 * 部门（id）取得
	 *
	 * @return 部门（id）
	 */
	public String getWiDepartmentid() {
		return wiDepartmentid;
	}

	/**
	 * 部门（id）设定
	 *
	 * @param 部门（id）
	 */
	public void setWiDepartmentid(String wiDepartmentid) {
		this.wiDepartmentid = wiDepartmentid;
	}

	/**
	 * 人员（userid）取得
	 *
	 * @return 人员（userid）
	 */
	public String getWiuserid() {
		return wiuserid;
	}

	/**
	 * 人员（userid）设定
	 *
	 * @param 人员（userid）
	 */
	public void setWiuserid(String wiuserid) {
		this.wiuserid = wiuserid;
	}

	/**
	 * 发起类型（1，自动发起；2，手动发起）取得
	 *
	 * @return 发起类型（1，自动发起；2，手动发起）
	 */
	public String getWiLunchType() {
		return wiLunchType;
	}

	/**
	 * 发起类型（1，自动发起；2，手动发起）设定
	 *
	 * @param 发起类型（1，自动发起；2，手动发起）
	 */
	public void setWiLunchType(String wiLunchType) {
		this.wiLunchType = wiLunchType;
	}

	/**
	 * 执行需所时间（小时）取得
	 *
	 * @return 执行需所时间（小时）
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * 执行需所时间（小时）设定
	 *
	 * @param 执行需所时间（小时）
	 */
	public void setExcuteTime(String excuteTime) {
		this.excuteTime = excuteTime;
	}

	/**
	 * 实际处理日期取得
	 *
	 * @return 实际处理日期
	 */
	public String getActualDealwithDate() {
		return actualDealwithDate;
	}

	/**
	 * 实际处理日期设定
	 *
	 * @param 实际处理日期
	 */
	public void setActualDealwithDate(String actualDealwithDate) {
		this.actualDealwithDate = actualDealwithDate;
	}

	/**
	 * 工作确认日期取得
	 *
	 * @return 工作确认日期
	 */
	public String getConfirmDate() {
		return confirmDate;
	}

	/**
	 * 工作确认日期设定
	 *
	 * @param 工作确认日期
	 */
	public void setConfirmDate(String confirmDate) {
		this.confirmDate = confirmDate;
	}

	/**
	 * 日期栏日期取得
	 *
	 * @return 日期栏日期
	 */
	public String getTitleDate() {
		return titleDate;
	}

	/**
	 * 日期栏日期设定
	 *
	 * @param 日期栏日期
	 */
	public void setTitleDate(String titleDate) {
		this.titleDate = titleDate;
	}

	/**
	 * 表记录创建日期取得
	 *
	 * @return 表记录创建日期
	 */
	public String getCrtDate() {
		return crtDate;
	}

	/**
	 * 表记录创建日期设定
	 *
	 * @param 表记录创建日期
	 */
	public void setCrtDate(String crtDate) {
		this.crtDate = crtDate;
	}

}