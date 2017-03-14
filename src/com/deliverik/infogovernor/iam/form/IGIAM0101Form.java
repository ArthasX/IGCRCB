/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionMapping;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BaseForm;

/**
 * 审计管理Form
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM0101Form extends BaseForm implements Serializable {
	
	/** 无意义自增主键 */
	protected Integer iapId;
	
	/** 审计年度 */
	protected String iapYear;
	
	/** 审计项目名称 */
	protected String iapName;
	
	/** 审计项目状态 */
	protected String iapStatus;
	
	/** 审计对象 */
	protected String iapObject;
	
	/** 审计方式 */
	protected String iapWay;
	
	/** 审计人员 */
	protected String iapUserName;
	
	/** 审计开始日期 */
	protected String iapOpenTime;
	
	/** 审计结束日期 */
	protected String iapCloseTime;
	
	/** 审计目标 */
	protected String iapObjective;
	
	/** 审计范围 */
	protected String iapScope;
	
	/** 审计依据 */
	protected String iapBasis;
	
	/** 审计内容及要点 */
	protected String iapDesc;
	
	/** 审计配合人员 */
	protected String iapCooperator;
	
	/** 审计建议 */
	protected String iapSuggestion;
	
	/** 审计项目发起人ID */
	protected String iapCreateUserId;
	
	/** 审计项目发起时间 */
	protected String iapCreateTime;
	
	/** 审计项目确认人ID */
	protected String iapConfirmUserId;
	
	/** 审计项目确认时间 */
	protected String iapConfirmTime;
	
	/** 审计附件Key */
	protected String iapAttKey;
	
	/** 审计类型 */
	protected String iapType;
	
	/** 审计检查来源 */
	protected String iapSource;
	
	/** 审计附件对象 */
	protected FormFile file;
	
	/** 将要删除的附件id串*/
	protected String deletekeys;
	
	/** 附件 */
	protected Map<Integer, FormFile> fileMap;
	
	/** 是否有检查问题 */
	protected String hasProblem;
	
	/**
	 * iapId取得
	 *
	 * @return iapId iapId
	 */
	public Integer getIapId() {
		return iapId;
	}
	/**
	 * iapId设定
	 *
	 * @param iapId iapId
	 */
	public void setIapId(Integer iapId) {
		this.iapId = iapId;
	}
	/**
	 * iapYear取得
	 *
	 * @return iapYear iapYear
	 */
	public String getIapYear() {
		return iapYear;
	}
	/**
	 * iapYear设定
	 *
	 * @param iapYear iapYear
	 */
	public void setIapYear(String iapYear) {
		this.iapYear = iapYear;
	}
	/**
	 * iapName取得
	 *
	 * @return iapName iapName
	 */
	public String getIapName() {
		return iapName;
	}
	/**
	 * iapName设定
	 *
	 * @param iapName iapName
	 */
	public void setIapName(String iapName) {
		this.iapName = iapName;
	}
	/**
	 * iapStatus取得
	 *
	 * @return iapStatus iapStatus
	 */
	public String getIapStatus() {
		return iapStatus;
	}
	/**
	 * iapStatus设定
	 *
	 * @param iapStatus iapStatus
	 */
	public void setIapStatus(String iapStatus) {
		this.iapStatus = iapStatus;
	}
	/**
	 * iapObject取得
	 *
	 * @return iapObject iapObject
	 */
	public String getIapObject() {
		return iapObject;
	}
	/**
	 * iapObject设定
	 *
	 * @param iapObject iapObject
	 */
	public void setIapObject(String iapObject) {
		this.iapObject = iapObject;
	}
	/**
	 * iapWay取得
	 *
	 * @return iapWay iapWay
	 */
	public String getIapWay() {
		return iapWay;
	}
	/**
	 * iapWay设定
	 *
	 * @param iapWay iapWay
	 */
	public void setIapWay(String iapWay) {
		this.iapWay = iapWay;
	}
	/**
	 * iapUserName取得
	 *
	 * @return iapUserName iapUserName
	 */
	public String getIapUserName() {
		return iapUserName;
	}
	/**
	 * iapUserName设定
	 *
	 * @param iapUserName iapUserName
	 */
	public void setIapUserName(String iapUserName) {
		this.iapUserName = iapUserName;
	}
	/**
	 * iapOpenTime取得
	 *
	 * @return iapOpenTime iapOpenTime
	 */
	public String getIapOpenTime() {
		return iapOpenTime;
	}
	/**
	 * iapOpenTime设定
	 *
	 * @param iapOpenTime iapOpenTime
	 */
	public void setIapOpenTime(String iapOpenTime) {
		this.iapOpenTime = iapOpenTime;
	}
	/**
	 * iapCloseTime取得
	 *
	 * @return iapCloseTime iapCloseTime
	 */
	public String getIapCloseTime() {
		return iapCloseTime;
	}
	/**
	 * iapCloseTime设定
	 *
	 * @param iapCloseTime iapCloseTime
	 */
	public void setIapCloseTime(String iapCloseTime) {
		this.iapCloseTime = iapCloseTime;
	}
	/**
	 * iapObjective取得
	 *
	 * @return iapObjective iapObjective
	 */
	public String getIapObjective() {
		return iapObjective;
	}
	/**
	 * iapObjective设定
	 *
	 * @param iapObjective iapObjective
	 */
	public void setIapObjective(String iapObjective) {
		this.iapObjective = iapObjective;
	}
	/**
	 * iapScope取得
	 *
	 * @return iapScope iapScope
	 */
	public String getIapScope() {
		return iapScope;
	}
	/**
	 * iapScope设定
	 *
	 * @param iapScope iapScope
	 */
	public void setIapScope(String iapScope) {
		this.iapScope = iapScope;
	}
	/**
	 * iapBasis取得
	 *
	 * @return iapBasis iapBasis
	 */
	public String getIapBasis() {
		return iapBasis;
	}
	/**
	 * iapBasis设定
	 *
	 * @param iapBasis iapBasis
	 */
	public void setIapBasis(String iapBasis) {
		this.iapBasis = iapBasis;
	}
	/**
	 * iapDesc取得
	 *
	 * @return iapDesc iapDesc
	 */
	public String getIapDesc() {
		return iapDesc;
	}
	/**
	 * iapDesc设定
	 *
	 * @param iapDesc iapDesc
	 */
	public void setIapDesc(String iapDesc) {
		this.iapDesc = iapDesc;
	}
	/**
	 * iapCooperator取得
	 *
	 * @return iapCooperator iapCooperator
	 */
	public String getIapCooperator() {
		return iapCooperator;
	}
	/**
	 * iapCooperator设定
	 *
	 * @param iapCooperator iapCooperator
	 */
	public void setIapCooperator(String iapCooperator) {
		this.iapCooperator = iapCooperator;
	}
	/**
	 * iapSuggestion取得
	 *
	 * @return iapSuggestion iapSuggestion
	 */
	public String getIapSuggestion() {
		return iapSuggestion;
	}
	/**
	 * iapSuggestion设定
	 *
	 * @param iapSuggestion iapSuggestion
	 */
	public void setIapSuggestion(String iapSuggestion) {
		this.iapSuggestion = iapSuggestion;
	}
	/**
	 * iapCreateuserId取得
	 *
	 * @return iapCreateUserId iapCreateUserId
	 */
	public String getIapCreateUserId() {
		return iapCreateUserId;
	}
	/**
	 * iapCreateuserId设定
	 *
	 * @param iapCreateUserId iapCreateUserId
	 */
	public void setIapCreateUserId(String iapCreateUserId) {
		this.iapCreateUserId = iapCreateUserId;
	}
	/**
	 * iapCreateTime取得
	 *
	 * @return iapCreateTime iapCreateTime
	 */
	public String getIapCreateTime() {
		return iapCreateTime;
	}
	/**
	 * iapCreateTime设定
	 *
	 * @param iapCreateTime iapCreateTime
	 */
	public void setIapCreateTime(String iapCreateTime) {
		this.iapCreateTime = iapCreateTime;
	}
	/**
	 * iapConfirmuserId取得
	 *
	 * @return iapConfirmUserId iapConfirmUserId
	 */
	public String getIapConfirmUserId() {
		return iapConfirmUserId;
	}
	/**
	 * iapConfirmuserId设定
	 *
	 * @param iapConfirmUserId iapConfirmUserId
	 */
	public void setIapConfirmUserId(String iapConfirmUserId) {
		this.iapConfirmUserId = iapConfirmUserId;
	}
	/**
	 * iapConfirmTime取得
	 *
	 * @return iapConfirmTime iapConfirmTime
	 */
	public String getIapConfirmTime() {
		return iapConfirmTime;
	}
	/**
	 * iapConfirmTime设定
	 *
	 * @param iapConfirmTime iapConfirmTime
	 */
	public void setIapConfirmTime(String iapConfirmTime) {
		this.iapConfirmTime = iapConfirmTime;
	}
	/**
	 * iapAttKey取得
	 *
	 * @return iapAttKey iapAttKey
	 */
	public String getIapAttKey() {
		return iapAttKey;
	}
	/**
	 * iapAttKey设定
	 *
	 * @param iapAttKey iapAttKey
	 */
	public void setIapAttKey(String iapAttKey) {
		this.iapAttKey = iapAttKey;
	}
	/**
	 * iapType取得
	 *
	 * @return iapType iapType
	 */
	public String getIapType() {
		return iapType;
	}
	/**
	 * iapType设定
	 *
	 * @param iapType iapType
	 */
	public void setIapType(String iapType) {
		this.iapType = iapType;
	}
	/**
	 * iapSource取得
	 *
	 * @return iapSource iapSource
	 */
	public String getIapSource() {
		return iapSource;
	}
	/**
	 * iapSource设定
	 *
	 * @param iapSource iapSource
	 */
	public void setIapSource(String iapSource) {
		this.iapSource = iapSource;
	}
	/**
	 * file取得
	 *
	 * @return file file
	 */
	public FormFile getFile() {
		return file;
	}
	/**
	 * file设定
	 *
	 * @param file file
	 */
	public void setFile(FormFile file) {
		this.file = file;
	}
	public FormFile getAttachFile() {
		return this.file;
	}

	public void setAttachFile(FormFile file) {
		this.file=file;
	}
	/**
	 * deletekeys取得
	 *
	 * @return deletekeys deletekeys
	 */
	public String getDeletekeys() {
		return deletekeys;
	}
	/**
	 * deletekeys设定
	 *
	 * @param deletekeys deletekeys
	 */
	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}
	/**
	 * 获取fileMap
	 * @return ffileMap fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * 设置fileMap
	 * @param fileMap  fileMap
	 */
	public void setFileMap(Map<Integer, FormFile> fileMap) {
		this.fileMap = fileMap;
	}
	@Override
	public void reset(ActionMapping mapping,HttpServletRequest request){
		super.reset(mapping, request);
		this.fileMap = new HashMap<Integer, FormFile>();
	}
	
	/**
	 * 获取附件
	 * @return 获取附件
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * 设置附件
	 * @param index 附件数组索引
	 * @param file 附件
	 */
	public void setAttachFile(int index, FormFile file) {
		fileMap.put(new Integer(index), file);
	}
	public String getHasProblem() {
		return hasProblem;
	}
	public void setHasProblem(String hasProblem) {
		this.hasProblem = hasProblem;
	}
	
	
}
