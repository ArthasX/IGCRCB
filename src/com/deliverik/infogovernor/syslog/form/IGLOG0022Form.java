package com.deliverik.infogovernor.syslog.form;

import com.deliverik.framework.base.BaseForm;

@SuppressWarnings("serial")
public class IGLOG0022Form extends BaseForm{

	protected Integer ruleid;

	/** 规则名称 */
	protected String rulename;

	/** 设备名称 */
	protected String deviceid;
	
	/** 设备ip */
	protected String deviceip;
	
	/** 设备ip */
	protected String deviceip2;

	/** 最大告警间隔次数 */
	protected Integer maxalarmnum;

	/** 最大告警间隔时间 */
	protected Integer maxalarmtime;

	/** 规则状态 */
	protected Integer rulestate;
	
	/** 已选规则条件列表 */
	protected String[] ruletempids;
	
	/** 规则条件集合 */
	protected String[] alarmconditions;
	
	/** 条件内容集合 */
	protected String[] alarmmsgs;
	
	protected String typeid;
	
	protected String devicename;
	
	protected String priority;
	
	protected String tempName;
	
	
	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDevicename() {
		return devicename;
	}

	public void setDevicename(String devicename) {
		this.devicename = devicename;
	}

	public String getTypeid() {
		return typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	/**
	 * ruleid取得
	 */
	public Integer getRuleid() {
		return ruleid;
	}

	/**
	 * ruleid设定
	 */
	public void setRuleid(Integer ruleid) {
		this.ruleid = ruleid;
	}

	/**
	 * 规则名称取得
	 */
	public String getRulename() {
		return rulename;
	}

	/**
	 * 规则名称设定
	 */
	public void setRulename(String rulename) {
		this.rulename = rulename;
	}

	/**
	 * 最大告警间隔次数取得
	 */
	public Integer getMaxalarmnum() {
		return maxalarmnum;
	}

	/**
	 * 最大告警间隔次数设定
	 */
	public void setMaxalarmnum(Integer maxalarmnum) {
		this.maxalarmnum = maxalarmnum;
	}





	/**
	 * 最大告警间隔时间取得
	 */
	public Integer getMaxalarmtime() {
		return maxalarmtime;
	}

	/**
	 * 最大告警间隔时间设定
	 */
	public void setMaxalarmtime(Integer maxalarmtime) {
		this.maxalarmtime = maxalarmtime;
	}

	/**
	 * 规则状态取得
	 */
	public Integer getRulestate() {
		return rulestate;
	}

	/**
	 * 规则状态设定
	 */
	public void setRulestate(Integer rulestate) {
		this.rulestate = rulestate;
	}

	

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	/**
	 * 设备ip取得
	 */
	public String getDeviceip() {
		return deviceip;
	}

	/**
	 * 设备ip设定
	 */
	public void setDeviceip(String deviceip) {
		this.deviceip = deviceip;
	}

	/**
	 * 已选规则条件列表取得
	 */
	public String[] getRuletempids() {
		return ruletempids;
	}

	/**
	 * 已选规则条件列表设定
	 */
	public void setRuletempids(String[] ruletempids) {
		this.ruletempids = ruletempids;
	}

	/**
	 * 规则条件集合取得
	 */
	public String[] getAlarmconditions() {
		return alarmconditions;
	}

	/**
	 * 规则条件集合设定
	 */
	public void setAlarmconditions(String[] alarmconditions) {
		this.alarmconditions = alarmconditions;
	}

	/**
	 * 条件内容集合取得
	 */
	public String[] getAlarmmsgs() {
		return alarmmsgs;
	}

	/**
	 * 条件内容集合设定
	 */
	public void setAlarmmsgs(String[] alarmmsgs) {
		this.alarmmsgs = alarmmsgs;
	}

	public String getDeviceip2() {
		return deviceip2;
	}

	public void setDeviceip2(String deviceip2) {
		this.deviceip2 = deviceip2;
	}

	public String getTempName() {
		return tempName;
	}

	public void setTempName(String tempName) {
		this.tempName = tempName;
	}
	
}
