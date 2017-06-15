/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.wim.model.condition;

/**
  * 概述: 工作日志检索条件实现
  * 功能描述: 工作日志检索条件实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkLogSearchCondImpl implements
		WorkLogSearchCond {

	/**
	 * 工作日志名称
	 */
	protected String wlname;

	/**
	 * 执行人（userid）
	 */
	protected String excutorId;

	/**
	 * 日期栏日期
	 */
	protected String titleDate;

	/**
	 * 执行时间
	 */
	protected String excuteTime;

	/**
	 * 实际处理日期
	 */
	protected String actualDealwithDate;

	/**
	 * 表记录创建日期
	 */
	protected String crtDate;

	/**
	 * 工作日志名称取得
	 *
	 * @return 工作日志名称
	 */
	public String getWlname() {
		return wlname;
	}

	/**
	 * 工作日志名称设定
	 *
	 * @param 工作日志名称
	 */
	public void setWlname(String wlname) {
		this.wlname = wlname;
	}

	/**
	 * 执行人（userid）取得
	 *
	 * @return 执行人（userid）
	 */
	public String getExcutorId() {
		return excutorId;
	}

	/**
	 * 执行人（userid）设定
	 *
	 * @param 执行人（userid）
	 */
	public void setExcutorId(String excutorId) {
		this.excutorId = excutorId;
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
	 * 执行时间取得
	 *
	 * @return excuteTime
	 */
	public String getExcuteTime() {
		return excuteTime;
	}

	/**
	 * 执行时间设定
	 *
	 * @param 执行时间
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