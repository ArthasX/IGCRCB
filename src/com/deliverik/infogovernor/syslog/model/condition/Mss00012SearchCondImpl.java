/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.syslog.model.condition;

import java.util.List;

import com.deliverik.framework.model.CodeDetail;


/**
  * 概述: MSS00012检索条件实现
  * 功能描述: MSS00012检索条件实现
  * 创建记录: 2013/04/25
  * 修改记录: 
  */
public class Mss00012SearchCondImpl implements
		Mss00012SearchCond {
	
	protected Integer[] id;
	
	public Integer[] getId() {
		return id;
	}
	public void setId(Integer[] id) {
		this.id = id;
	}
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
	
	/** 告警优先级标识 */
	protected String[] priority;
	
	protected List<CodeDetail>ruleli=null;
	
	protected String Endtime_from;
	
	protected String Endtime_to;
	
	protected String Starttime_from;
	
	protected String Starttime_to;
	
	protected  String[]cvalue;
	
	protected String alarmstate;
	
	protected String state;
	
	
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<CodeDetail> getRuleli() {
		return ruleli;
	}
	public void setRuleli(List<CodeDetail> ruleli) {
		this.ruleli = ruleli;
	}
	public String getEndtime_from() {
		return Endtime_from;
	}
	public void setEndtime_from(String endtime_from) {
		Endtime_from = endtime_from;
	}
	public String getEndtime_to() {
		return Endtime_to;
	}
	public void setEndtime_to(String endtime_to) {
		Endtime_to = endtime_to;
	}
	public String getStarttime_from() {
		return Starttime_from;
	}
	public void setStarttime_from(String starttime_from) {
		Starttime_from = starttime_from;
	}
	public String getStarttime_to() {
		return Starttime_to;
	}
	public void setStarttime_to(String starttime_to) {
		Starttime_to = starttime_to;
	}
	public String[] getCvalue() {
		return cvalue;
	}
	public void setCvalue(String[] cvalue) {
		this.cvalue = cvalue;
	}
	public String getAlarmstate() {
		return alarmstate;
	}
	public void setAlarmstate(String alarmstate) {
		this.alarmstate = alarmstate;
	}
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


}