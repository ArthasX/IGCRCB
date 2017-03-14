/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

/**
  * 概述: 告警信息历史表检索条件实现
  * 功能描述: 告警信息历史表检索条件实现
  * 创建记录: 2013/03/28
  * 修改记录: 
  */
public class Mss00007SearchCondImpl implements
		Mss00007SearchCond {
	
	/** 告警优先级标识 */
	protected String priority_eq;
	
	/** 开始的告警触发时间 */
	protected String alarmtime_from;
	
	/** 结束的告警触发时间 */
	protected String alarmtime_to;
	
	/** 告警设备IP */
	protected String ip_like;
	
	/** 设备类型 */
	protected String ename;
	
	/** 关键字 */
	protected String word_like;
	
	protected String esyscoding;
	
	/** 告警状态 */
	protected String alarmstate;
	
	/** 告警级别 */
	protected String[] priority;
	
	
	public String[] getPriority() {
		return priority;
	}

	public void setPriority(String[] priority) {
		this.priority = priority;
	}
	
	public String getEsyscoding() {
		return esyscoding;
	}
	public void setEsyscoding(String esyscoding) {
		this.esyscoding = esyscoding;
	}
	
	public String getWord_like() {
		return word_like;
	}
	public void setWord_like(String word_like) {
		this.word_like = word_like;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getAlarmtime_from() {
		return alarmtime_from;
	}
	public void setAlarmtime_from(String alarmtime_from) {
		this.alarmtime_from = alarmtime_from;
	}
	public String getAlarmtime_to() {
		return alarmtime_to;
	}
	public void setAlarmtime_to(String alarmtime_to) {
		this.alarmtime_to = alarmtime_to;
	}
	public String getIp_like() {
		return ip_like;
	}
	public void setIp_like(String ip_like) {
		this.ip_like = ip_like;
	}
	public String getPriority_eq() {
		return priority_eq;
	}
	public void setPriority_eq(String priority_eq) {
		this.priority_eq = priority_eq;
	}
	public String getAlarmstate() {
		return alarmstate;
	}
	public void setAlarmstate(String alarmstate) {
		this.alarmstate = alarmstate;
	}

}