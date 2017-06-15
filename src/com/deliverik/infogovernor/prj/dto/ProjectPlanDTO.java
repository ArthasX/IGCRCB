/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.dto;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.prj.form.ProjectPlanForm;
import com.deliverik.infogovernor.prj.model.ProjectLog;
import com.deliverik.infogovernor.prj.model.ProjectPlan;
import com.deliverik.infogovernor.prj.vo.MilestoneInfo;

public class ProjectPlanDTO {
	/**
	 * project表主键ID
	 */
	private Integer projectId;

	private ProjectPlanForm projectPlanForm;
	
	/**
	 * ProjectPlan
	 */
	private ProjectPlan projectPlan;
	
	private String pplstatus;
	
	private String pstatus;
	
	private String ptime;
	
	private String colorA;
	
	private String colorB;
	
	private String colorC;
	
	private String colorD;
	
	private String colorE;
	
	private String colorF;
	
	private String colorG;
	
	private List<MilestoneInfo> milestoneInfoList;
	
	Map<String,String> projectLogMap;
	
	/**
	 * ProjectLog
	 */
	private ProjectLog projectLog;
	
	private List<Attachment> attachmentList;
	
	private String sygTime;
	
	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public ProjectPlan getProjectPlan() {
		return projectPlan;
	}

	public void setProjectPlan(ProjectPlan projectPlan) {
		this.projectPlan = projectPlan;
	}

	public ProjectLog getProjectLog() {
		return projectLog;
	}

	public void setProjectLog(ProjectLog projectLog) {
		this.projectLog = projectLog;
	}

	public ProjectPlanForm getProjectPlanForm() {
		return projectPlanForm;
	}

	public void setProjectPlanForm(ProjectPlanForm projectPlanForm) {
		this.projectPlanForm = projectPlanForm;
	}

	public List<MilestoneInfo> getMilestoneInfoList() {
		return milestoneInfoList;
	}

	public void setMilestoneInfoList(List<MilestoneInfo> milestoneInfoList) {
		this.milestoneInfoList = milestoneInfoList;
	}

	public String getPplstatus() {
		return pplstatus;
	}

	public void setPplstatus(String pplstatus) {
		this.pplstatus = pplstatus;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getSygTime() {
		return sygTime;
	}

	public void setSygTime(String sygTime) {
		this.sygTime = sygTime;
	}

	public String getColorA() {
		return colorA;
	}

	public void setColorA(String colorA) {
		this.colorA = colorA;
	}

	public String getColorB() {
		return colorB;
	}

	public void setColorB(String colorB) {
		this.colorB = colorB;
	}

	public String getColorC() {
		return colorC;
	}

	public void setColorC(String colorC) {
		this.colorC = colorC;
	}

	public String getColorD() {
		return colorD;
	}

	public void setColorD(String colorD) {
		this.colorD = colorD;
	}

	public String getColorE() {
		return colorE;
	}

	public void setColorE(String colorE) {
		this.colorE = colorE;
	}

	public String getColorF() {
		return colorF;
	}

	public void setColorF(String colorF) {
		this.colorF = colorF;
	}

	public String getColorG() {
		return colorG;
	}

	public void setColorG(String colorG) {
		this.colorG = colorG;
	}

	public Map<String, String> getProjectLogMap() {
		return projectLogMap;
	}

	public void setProjectLogMap(Map<String, String> projectLogMap) {
		this.projectLogMap = projectLogMap;
	}
	
}
