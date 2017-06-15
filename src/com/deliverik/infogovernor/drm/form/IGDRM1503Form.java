/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.drm.form;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.base.PagingDTO;

/**
 * 概述: 培训计划form
 * 创建记录: 2014年12月29日14:08:55
 * 修改记录: 
 */
@SuppressWarnings("serial")
public class IGDRM1503Form extends BaseForm {

	/**
	 * 主表主键
	 */
	private String tpid;

	/**
	 * 从表主键
	 */
	private String tpdid;


    /** 计划名称 */
    protected String planName;

	/**
	 * 工单号
	 */
	private String jboNum;

	/**
	 * 发起时间
	 */
	private String startTime;

	/**
	 * 发起时间从
	 */
	private String startTimeBegin;

	/**
	 * 发起时间到
	 */
	private String startTimeEnd;

	/**
	 * 发起人ID
	 */
	private String currentUID;

	/**
	 * 发起人
	 */
	private String promoters;

	/**
	 * 发起人
	 */
	private String promoters_like;

	/**
	 * 发起人部门ID
	 */
	private String departmentID;

	/**
	 * 发起人部门
	 */
	private String sponsorDepartment;

	/**
	 * 发起人部门
	 */
	private String sponsorDept;

	/**
	 * 序号
	 */
	private String [] serialNumber;

	/**
	 * 姓名
	 */
	private String [] fullName;

	/**
	 * 培训课程
	 */
	private String [] curriculum;

	/**
	 * 培训机构
	 */
	private String [] trainingOrganization;

	/**
	 * 培训时间
	 */
	private String [] trainingTime;

	/**
	 * 培训时间从
	 */
	private String trainingTimeBegin;

	/**
	 * 培训时间到
	 */
	private String trainigTimeEnd;

	/**
	 * 计划明细
	 */
	private String detailContent;

	/**
	 * 结果集
	 */
	private List<Map<String, Object>> resultList;

	/**
	 * 结果集
	 */
	private Map<String, Object> resultMap;

	/** 附件 */
	protected List<Map<Integer, FormFile>> fileListMap = new ArrayList<Map<Integer,FormFile>>();

	/** 允许查询的最大记录数 */
	protected int maxSearchCount;

	/** 分页Bean */
	protected PagingDTO pagingDto;

	protected String [] attkeys;
	/**
	 * @return the tpid
	 */
	public String getTpid() {
		return this.tpid;
	}

	/**
	 * @param tpid the tpid to set
	 */
	public void setTpid(String tpid) {
		this.tpid = tpid;
	}

	/**
	 * @return the tpdid
	 */
	public String getTpdid() {
		return this.tpdid;
	}

	/**
	 * @param tpdid the tpdid to set
	 */
	public void setTpdid(String tpdid) {
		this.tpdid = tpdid;
	}

	/**
	 * 设置附件
	 * @param index 附件数组索引
	 * @param file 附件
	 */
	public void setAttachment(int index, FormFile file) {
		Map<Integer, FormFile> temp = new HashMap<Integer, FormFile>();
		temp.put(index, file);
		fileListMap.add(temp);
	}

	/**
	 * @return the jboNum
	 */
	public String getJboNum() {
		return this.jboNum;
	}

	/**
	 * @param jboNum the jboNum to set
	 */
	public void setJboNum(String jboNum) {
		this.jboNum = jboNum;
	}

	/**
	 * @return the startTime
	 */
	public String getStartTime() {
		return this.startTime;
	}

	/**
	 * @param startTime the startTime to set
	 */
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	/**
	 * @return the startTimeBegin
	 */
	public String getStartTimeBegin() {
		return this.startTimeBegin;
	}

	/**
	 * @param startTimeBegin the startTimeBegin to set
	 */
	public void setStartTimeBegin(String startTimeBegin) {
		this.startTimeBegin = startTimeBegin;
	}

	/**
	 * @return the startTimeEnd
	 */
	public String getStartTimeEnd() {
		return this.startTimeEnd;
	}

	/**
	 * @param startTimeEnd the startTimeEnd to set
	 */
	public void setStartTimeEnd(String startTimeEnd) {
		this.startTimeEnd = startTimeEnd;
	}

	/**
	 * @return the currentUID
	 */
	public String getCurrentUID() {
		return this.currentUID;
	}

	/**
	 * @param currentUID the currentUID to set
	 */
	public void setCurrentUID(String currentUID) {
		this.currentUID = currentUID;
	}

	/**
	 * @return the promoters
	 */
	public String getPromoters() {
		return this.promoters;
	}

	/**
	 * @param promoters the promoters to set
	 */
	public void setPromoters(String promoters) {
		this.promoters = promoters;
	}

	/**
	 * @return the departmentID
	 */
	public String getDepartmentID() {
		return this.departmentID;
	}

	/**
	 * @param departmentID the departmentID to set
	 */
	public void setDepartmentID(String departmentID) {
		this.departmentID = departmentID;
	}

	/**
	 * @return the sponsorDepartment
	 */
	public String getSponsorDepartment() {
		return this.sponsorDepartment;
	}

	/**
	 * @param sponsorDepartment the sponsorDepartment to set
	 */
	public void setSponsorDepartment(String sponsorDepartment) {
		this.sponsorDepartment = sponsorDepartment;
	}

	/**
	 * @return the serialNumber
	 */
	public String[] getSerialNumber() {
		return this.serialNumber;
	}

	/**
	 * @param serialNumber the serialNumber to set
	 */
	public void setSerialNumber(String[] serialNumber) {
		this.serialNumber = serialNumber;
	}

	/**
	 * @return the fullName
	 */
	public String[] getFullName() {
		return this.fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String[] fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the curriculum
	 */
	public String[] getCurriculum() {
		return this.curriculum;
	}

	/**
	 * @param curriculum the curriculum to set
	 */
	public void setCurriculum(String[] curriculum) {
		this.curriculum = curriculum;
	}

	/**
	 * @return the trainingOrganization
	 */
	public String[] getTrainingOrganization() {
		return this.trainingOrganization;
	}

	/**
	 * @param trainingOrganization the trainingOrganization to set
	 */
	public void setTrainingOrganization(String[] trainingOrganization) {
		this.trainingOrganization = trainingOrganization;
	}

	/**
	 * @return the trainingTime
	 */
	public String[] getTrainingTime() {
		return this.trainingTime;
	}

	/**
	 * @param trainingTime the trainingTime to set
	 */
	public void setTrainingTime(String[] trainingTime) {
		this.trainingTime = trainingTime;
	}

	/**
	 * @return the trainingTimeBegin
	 */
	public String getTrainingTimeBegin() {
		return this.trainingTimeBegin;
	}

	/**
	 * @param trainingTimeBegin the trainingTimeBegin to set
	 */
	public void setTrainingTimeBegin(String trainingTimeBegin) {
		this.trainingTimeBegin = trainingTimeBegin;
	}

	/**
	 * @return the trainigTimeEnd
	 */
	public String getTrainigTimeEnd() {
		return this.trainigTimeEnd;
	}

	/**
	 * @param trainigTimeEnd the trainigTimeEnd to set
	 */
	public void setTrainigTimeEnd(String trainigTimeEnd) {
		this.trainigTimeEnd = trainigTimeEnd;
	}

	/**
	 * @return the detailContent
	 */
	public String getDetailContent() {
		return this.detailContent;
	}

	/**
	 * @param detailContent the detailContent to set
	 */
	public void setDetailContent(String detailContent) {
		this.detailContent = detailContent;
	}

	/**
	 * @return the fileListMap
	 */
	public List<Map<Integer, FormFile>> getFileListMap() {
		return this.fileListMap;
	}

	/**
	 * @param fileListMap the fileListMap to set
	 */
	public void setFileListMap(List<Map<Integer, FormFile>> fileListMap) {
		this.fileListMap = fileListMap;
	}

	/**
	 * @return the resultList
	 */
	public List<Map<String, Object>> getResultList() {
		return this.resultList;
	}

	/**
	 * @param resultList the resultList to set
	 */
	public void setResultList(List<Map<String, Object>> resultList) {
		this.resultList = resultList;
	}

	/**
	 * @return the resultMap
	 */
	public Map<String, Object> getResultMap() {
		return this.resultMap;
	}

	/**
	 * @param resultMap the resultMap to set
	 */
	public void setResultMap(Map<String, Object> resultMap) {
		this.resultMap = resultMap;
	}

	/**
	 * @return the maxSearchCount
	 */
	public int getMaxSearchCount() {
		return this.maxSearchCount;
	}

	/**
	 * @param maxSearchCount the maxSearchCount to set
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * @return the pagingDto
	 */
	public PagingDTO getPagingDto() {
		return this.pagingDto;
	}

	/**
	 * @param pagingDto the pagingDto to set
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * @return the promoters_like
	 */
	public String getPromoters_like() {
		return this.promoters_like;
	}

	/**
	 * @param promoters_like the promoters_like to set
	 */
	public void setPromoters_like(String promoters_like) {
		this.promoters_like = promoters_like;
	}

	/**
	 * @return the sponsorDept
	 */
	public String getSponsorDept() {
		return this.sponsorDept;
	}

	/**
	 * @param sponsorDept the sponsorDept to set
	 */
	public void setSponsorDept(String sponsorDept) {
		this.sponsorDept = sponsorDept;
	}

	/**
	 * @return the attkeys
	 */
	public String[] getAttkeys() {
		return this.attkeys;
	}

	/**
	 * @param attkeys the attkeys to set
	 */
	public void setAttkeys(String[] attkeys) {
		this.attkeys = attkeys;
	}

	/**
	 * @return the planName
	 */
	public String getPlanName() {
		return this.planName;
	}

	/**
	 * @param planName the planName to set
	 */
	public void setPlanName(String planName) {
		this.planName = planName;
	}

} // end class IGSVC1703Form 
