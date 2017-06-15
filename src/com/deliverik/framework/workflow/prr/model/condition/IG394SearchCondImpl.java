/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prr.model.condition;

import java.io.Serializable;

/**
  * 概述: 提醒记录表检索条件实现
  * 功能描述: 提醒记录表检索条件实现
  * 创建记录: 2012/04/25
  * 修改记录: 
  */
public class IG394SearchCondImpl implements
		IG394SearchCond {
	protected Integer pnssid;

	/** 流程id */
	protected Integer prid;

	/** 状态ID */
	protected String psdid;

	/** 接单状态 */
	protected String psdconfirm;

	/** 角色ID */
	protected Integer roleid;

	/** 发给的用户ID */
	protected String userid;

	/** 发送短信时间 */
	protected String notifysmstime;

	/** 发送邮件时间 */
	protected String notifyemailtime;
	
	protected String reportsmstime;
	
	protected String reportemailtime;
	
	protected String flag;
	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Integer getPnssid() {
		return pnssid;
	}

	/**
	 * 主键设定
	 *
	 * @param pnssid 主键
	 */
	public void setPnssid(Integer pnssid) {
		this.pnssid = pnssid;
	}

	/**
	 * 流程id取得
	 *
	 * @return 流程id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * 流程id设定
	 *
	 * @param prid 流程id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * 状态ID取得
	 *
	 * @return 状态ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * 状态ID设定
	 *
	 * @param psdid 状态ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * 接单状态取得
	 *
	 * @return 接单状态
	 */
	public String getPsdconfirm() {
		return psdconfirm;
	}

	/**
	 * 接单状态设定
	 *
	 * @param psdconfirm 接单状态
	 */
	public void setPsdconfirm(String psdconfirm) {
		this.psdconfirm = psdconfirm;
	}

	/**
	 * 角色ID取得
	 *
	 * @return 角色ID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * 角色ID设定
	 *
	 * @param roleid 角色ID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * 发给的用户ID取得
	 *
	 * @return 发给的用户ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * 发给的用户ID设定
	 *
	 * @param userid 发给的用户ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * 主键取得
	 *
	 * @return 主键
	 */
	public Serializable getPK() {
		return pnssid;
	}

	public String getNotifysmstime() {
		return notifysmstime;
	}

	public void setNotifysmstime(String notifysmstime) {
		this.notifysmstime = notifysmstime;
	}

	public String getNotifyemailtime() {
		return notifyemailtime;
	}

	public void setNotifyemailtime(String notifyemailtime) {
		this.notifyemailtime = notifyemailtime;
	}

	public String getReportsmstime() {
		return reportsmstime;
	}

	public void setReportsmstime(String reportsmstime) {
		this.reportsmstime = reportsmstime;
	}

	public String getReportemailtime() {
		return reportemailtime;
	}

	public void setReportemailtime(String reportemailtime) {
		this.reportemailtime = reportemailtime;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	
	
	

}