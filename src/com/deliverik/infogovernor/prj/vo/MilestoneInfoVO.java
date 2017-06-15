/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.prj.model.ProjectPlan;

public class MilestoneInfoVO {
	private List<MilestoneInfo> milestoneInfoList;
	
	private ProjectPlan projectPlan;
	
	private String pstatus;
	
	private String ptime;
	
	private String sygTime;
	
	private String colorA;
	
	private String colorB;
	
	private String colorC;
	
	private String colorD;
	
	private String colorE;
	
	private String colorF;
	
	private String colorG;
	
	private List<Attachment> attachmentList;

	Map<String,String> projectLogMap;
	
	public ProjectPlan getProjectPlan() {
		return projectPlan;
	}

	public void setProjectPlan(ProjectPlan projectPlan) {
		this.projectPlan = projectPlan;
	}

	public List<MilestoneInfo> getMilestoneInfoList() {
		return milestoneInfoList;
	}

	public void setMilestoneInfoList(List<MilestoneInfo> milestoneInfoList) {
		this.milestoneInfoList = milestoneInfoList;
	}

	public String getPstatus() {
		return pstatus;
	}

	public void setPstatus(String pstatus) {
		this.pstatus = pstatus;
	}

	public String getPtime() {
		return ptime;
	}

	public void setPtime(String ptime) {
		this.ptime = ptime;
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
