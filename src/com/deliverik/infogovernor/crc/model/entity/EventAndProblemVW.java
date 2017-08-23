/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
	 * ����
	 */
	@Id
	protected String id;
	
	/**
	 * �¼�����
	 */
	protected String eventNum;
	
	/**
	 * ����ʱ��
	 */
	protected String happenTime;
	
	
	/**
	 * �Ƿ��ѹر�
	 */
	protected String isClosed;
	
	
	/**
	 * �¼���Դ
	 */
	protected String eventSource;
	
	/**
	 * �¼�������
	 */
	protected String eventusername;
	
	/**
	 * �¼�״̬
	 */
	protected String eventstatus;
	
	/**
	 * �¼�����
	 */
	protected String eventTitle;
	
	/**
	 * �¼�����
	 */
	protected String eventType;
		
	/**
	 * �¼�����
	 */
	protected String eventContent;
	
		
	/**
	 * �¼��漰Ӧ��ϵͳ
	 */
	protected String involveSystem;
	
	/**
	 * �¼�Ӱ�췶Χ
	 */
	protected String influenceRange;
	
	/**
	 * Ӱ�췶Χ��ע
	 */
	protected String influenceRangeRemarks;	
	
	/**  
	 * �¼��ȼ�
	 */	
	protected String eventLevel;
	/** 
	 * �¼�ԭ�� 
	 */	
	protected String eventCause;
	

	/** 
	 * Ӧ���������
	 */	
	protected String emergencySolution;
	/** 
	 * ���ⵥ��  
	 */	
	protected String problemNum;
	
	/** 
	 * ��������
	 */	
	protected String problemTitle;
	/** 
	 * ���ⷢ��ʱ��
	 */	
	protected String problemopentime;
	/** 
	 * ���ⷢ����
	 */	
	protected String problemusername;
	/** 
	 * ����״̬
	 */	
	protected String problemstatus;
	
	/** 
	 * ��������
	 */	
	protected String problemcontent;
		
	/** 
	 * ��������Ż�����
	 */
	protected String pptimizationScheme;
	/** 
	 * ����ƻ����ʱ��
	 */	
	protected String plannedSolutionTime;	
	/** 
	 * ���������� 
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
