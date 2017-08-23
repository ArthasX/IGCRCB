/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.crc.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.crc.model.EventAndProblemVWInfo;

@SuppressWarnings("serial")
@Entity
@Table(name="eventandProblem")
public class EventAndProblemVW implements Serializable,Cloneable,EventAndProblemVWInfo{
	
	
	/**
	 * 主键
	 */
	@Id
	protected String id;
	
	/**
	 * 事件单号
	 */
	protected String eventNum;
	
	/**
	 * 发生时间
	 */
	protected String happenTime;
	
	
	/**
	 * 是否已关闭
	 */
	protected String isClosed;
	
	
	/**
	 * 事件来源
	 */
	protected String eventSource;
	
	/**
	 * 事件发起人
	 */
	protected String eventusername;
	
	/**
	 * 事件状态
	 */
	protected String eventstatus;
	
	/**
	 * 事件名称
	 */
	protected String eventTitle;
	
	/**
	 * 事件分类
	 */
	protected String eventType;
		
	/**
	 * 事件内容
	 */
	protected String eventContent;
	
		
	/**
	 * 事件涉及应用系统
	 */
	protected String involveSystem;
	
	/**
	 * 事件影响范围
	 */
	protected String influenceRange;
	
	/**
	 * 影响范围备注
	 */
	protected String influenceRangeRemarks;	
	
	/**  
	 * 事件等级
	 */	
	protected String eventLevel;
	/** 
	 * 事件原因 
	 */	
	protected String eventCause;
	

	/** 
	 * 应急解决方案
	 */	
	protected String emergencySolution;
	/** 
	 * 问题单号  
	 */	
	protected String problemNum;
	
	/** 
	 * 问题名称
	 */	
	protected String problemTitle;
	/** 
	 * 问题发起时间
	 */	
	protected String problemopentime;
	/** 
	 * 问题发起人
	 */	
	protected String problemusername;
	/** 
	 * 问题状态
	 */	
	protected String problemstatus;
	
	/** 
	 * 问题描述
	 */	
	protected String problemcontent;
		
	/** 
	 * 问题后续优化方案
	 */
	protected String pptimizationScheme;
	/** 
	 * 问题计划解决时间
	 */	
	protected String plannedSolutionTime;	
	/** 
	 * 问题责任人 
	 */	
	protected String personLiable;
	
	public String getEventNum() {
		return eventNum;
	}
	public void setEventNum(String eventNum) {
		this.eventNum = eventNum;
	}
	public String getHappenTime() {
		return happenTime;
	}
	public void setHappenTime(String happenTime) {
		this.happenTime = happenTime;
	}
	public String getIsClosed() {
		return isClosed;
	}
	public void setIsClosed(String isClosed) {
		this.isClosed = isClosed;
	}
	public String getEventSource() {
		return eventSource;
	}
	public void setEventSource(String eventSource) {
		this.eventSource = eventSource;
	}
	public String getEventTitle() {
		return eventTitle;
	}
	public void setEventTitle(String eventTitle) {
		this.eventTitle = eventTitle;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	public String getInvolveSystem() {
		return involveSystem;
	}
	public void setInvolveSystem(String involveSystem) {
		this.involveSystem = involveSystem;
	}
	public String getInfluenceRange() {
		return influenceRange;
	}
	public void setInfluenceRange(String influenceRange) {
		this.influenceRange = influenceRange;
	}
	public String getInfluenceRangeRemarks() {
		return influenceRangeRemarks;
	}
	public void setInfluenceRangeRemarks(String influenceRangeRemarks) {
		this.influenceRangeRemarks = influenceRangeRemarks;
	}
	public String getEventLevel() {
		return eventLevel;
	}
	public void setEventLevel(String eventLevel) {
		this.eventLevel = eventLevel;
	}
	public String getEventCause() {
		return eventCause;
	}
	public void setEventCause(String eventCause) {
		this.eventCause = eventCause;
	}
	public String getEmergencySolution() {
		return emergencySolution;
	}
	public void setEmergencySolution(String emergencySolution) {
		this.emergencySolution = emergencySolution;
	}
	public String getProblemNum() {
		return problemNum;
	}
	public void setProblemNum(String problemNum) {
		this.problemNum = problemNum;
	}
	public String getPptimizationScheme() {
		return pptimizationScheme;
	}
	public void setPptimizationScheme(String pptimizationScheme) {
		this.pptimizationScheme = pptimizationScheme;
	}
	public String getPlannedSolutionTime() {
		return plannedSolutionTime;
	}
	public void setPlannedSolutionTime(String plannedSolutionTime) {
		this.plannedSolutionTime = plannedSolutionTime;
	}
	public String getPersonLiable() {
		return personLiable;
	}
	public void setPersonLiable(String personLiable) {
		this.personLiable = personLiable;
	}
	public String getEventusername() {
		return eventusername;
	}
	public void setEventusername(String eventusername) {
		this.eventusername = eventusername;
	}
	public String getEventstatus() {
		return eventstatus;
	}
	public void setEventstatus(String eventstatus) {
		this.eventstatus = eventstatus;
	}
	public String getEventContent() {
		return eventContent;
	}
	public void setEventContent(String eventContent) {
		this.eventContent = eventContent;
	}
	public String getProblemTitle() {
		return problemTitle;
	}
	public void setProblemTitle(String problemTitle) {
		this.problemTitle = problemTitle;
	}
	public String getProblemopentime() {
		return problemopentime;
	}
	public void setProblemopentime(String problemopentime) {
		this.problemopentime = problemopentime;
	}
	public String getProblemusername() {
		return problemusername;
	}
	public void setProblemusername(String problemusername) {
		this.problemusername = problemusername;
	}
	public String getProblemstatus() {
		return problemstatus;
	}
	public void setProblemstatus(String problemstatus) {
		this.problemstatus = problemstatus;
	}
	public String getProblemcontent() {
		return problemcontent;
	}
	public void setProblemcontent(String problemcontent) {
		this.problemcontent = problemcontent;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	
	
}
