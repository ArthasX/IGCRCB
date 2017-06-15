/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
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
 * ��ƹ���Form
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM0101Form extends BaseForm implements Serializable {
	
	/** �������������� */
	protected Integer iapId;
	
	/** ������ */
	protected String iapYear;
	
	/** �����Ŀ���� */
	protected String iapName;
	
	/** �����Ŀ״̬ */
	protected String iapStatus;
	
	/** ��ƶ��� */
	protected String iapObject;
	
	/** ��Ʒ�ʽ */
	protected String iapWay;
	
	/** �����Ա */
	protected String iapUserName;
	
	/** ��ƿ�ʼ���� */
	protected String iapOpenTime;
	
	/** ��ƽ������� */
	protected String iapCloseTime;
	
	/** ���Ŀ�� */
	protected String iapObjective;
	
	/** ��Ʒ�Χ */
	protected String iapScope;
	
	/** ������� */
	protected String iapBasis;
	
	/** ������ݼ�Ҫ�� */
	protected String iapDesc;
	
	/** ��������Ա */
	protected String iapCooperator;
	
	/** ��ƽ��� */
	protected String iapSuggestion;
	
	/** �����Ŀ������ID */
	protected String iapCreateUserId;
	
	/** �����Ŀ����ʱ�� */
	protected String iapCreateTime;
	
	/** �����Ŀȷ����ID */
	protected String iapConfirmUserId;
	
	/** �����Ŀȷ��ʱ�� */
	protected String iapConfirmTime;
	
	/** ��Ƹ���Key */
	protected String iapAttKey;
	
	/** ������� */
	protected String iapType;
	
	/** ��Ƽ����Դ */
	protected String iapSource;
	
	/** ��Ƹ������� */
	protected FormFile file;
	
	/** ��Ҫɾ���ĸ���id��*/
	protected String deletekeys;
	
	/** ���� */
	protected Map<Integer, FormFile> fileMap;
	
	/** �Ƿ��м������ */
	protected String hasProblem;
	
	/**
	 * iapIdȡ��
	 *
	 * @return iapId iapId
	 */
	public Integer getIapId() {
		return iapId;
	}
	/**
	 * iapId�趨
	 *
	 * @param iapId iapId
	 */
	public void setIapId(Integer iapId) {
		this.iapId = iapId;
	}
	/**
	 * iapYearȡ��
	 *
	 * @return iapYear iapYear
	 */
	public String getIapYear() {
		return iapYear;
	}
	/**
	 * iapYear�趨
	 *
	 * @param iapYear iapYear
	 */
	public void setIapYear(String iapYear) {
		this.iapYear = iapYear;
	}
	/**
	 * iapNameȡ��
	 *
	 * @return iapName iapName
	 */
	public String getIapName() {
		return iapName;
	}
	/**
	 * iapName�趨
	 *
	 * @param iapName iapName
	 */
	public void setIapName(String iapName) {
		this.iapName = iapName;
	}
	/**
	 * iapStatusȡ��
	 *
	 * @return iapStatus iapStatus
	 */
	public String getIapStatus() {
		return iapStatus;
	}
	/**
	 * iapStatus�趨
	 *
	 * @param iapStatus iapStatus
	 */
	public void setIapStatus(String iapStatus) {
		this.iapStatus = iapStatus;
	}
	/**
	 * iapObjectȡ��
	 *
	 * @return iapObject iapObject
	 */
	public String getIapObject() {
		return iapObject;
	}
	/**
	 * iapObject�趨
	 *
	 * @param iapObject iapObject
	 */
	public void setIapObject(String iapObject) {
		this.iapObject = iapObject;
	}
	/**
	 * iapWayȡ��
	 *
	 * @return iapWay iapWay
	 */
	public String getIapWay() {
		return iapWay;
	}
	/**
	 * iapWay�趨
	 *
	 * @param iapWay iapWay
	 */
	public void setIapWay(String iapWay) {
		this.iapWay = iapWay;
	}
	/**
	 * iapUserNameȡ��
	 *
	 * @return iapUserName iapUserName
	 */
	public String getIapUserName() {
		return iapUserName;
	}
	/**
	 * iapUserName�趨
	 *
	 * @param iapUserName iapUserName
	 */
	public void setIapUserName(String iapUserName) {
		this.iapUserName = iapUserName;
	}
	/**
	 * iapOpenTimeȡ��
	 *
	 * @return iapOpenTime iapOpenTime
	 */
	public String getIapOpenTime() {
		return iapOpenTime;
	}
	/**
	 * iapOpenTime�趨
	 *
	 * @param iapOpenTime iapOpenTime
	 */
	public void setIapOpenTime(String iapOpenTime) {
		this.iapOpenTime = iapOpenTime;
	}
	/**
	 * iapCloseTimeȡ��
	 *
	 * @return iapCloseTime iapCloseTime
	 */
	public String getIapCloseTime() {
		return iapCloseTime;
	}
	/**
	 * iapCloseTime�趨
	 *
	 * @param iapCloseTime iapCloseTime
	 */
	public void setIapCloseTime(String iapCloseTime) {
		this.iapCloseTime = iapCloseTime;
	}
	/**
	 * iapObjectiveȡ��
	 *
	 * @return iapObjective iapObjective
	 */
	public String getIapObjective() {
		return iapObjective;
	}
	/**
	 * iapObjective�趨
	 *
	 * @param iapObjective iapObjective
	 */
	public void setIapObjective(String iapObjective) {
		this.iapObjective = iapObjective;
	}
	/**
	 * iapScopeȡ��
	 *
	 * @return iapScope iapScope
	 */
	public String getIapScope() {
		return iapScope;
	}
	/**
	 * iapScope�趨
	 *
	 * @param iapScope iapScope
	 */
	public void setIapScope(String iapScope) {
		this.iapScope = iapScope;
	}
	/**
	 * iapBasisȡ��
	 *
	 * @return iapBasis iapBasis
	 */
	public String getIapBasis() {
		return iapBasis;
	}
	/**
	 * iapBasis�趨
	 *
	 * @param iapBasis iapBasis
	 */
	public void setIapBasis(String iapBasis) {
		this.iapBasis = iapBasis;
	}
	/**
	 * iapDescȡ��
	 *
	 * @return iapDesc iapDesc
	 */
	public String getIapDesc() {
		return iapDesc;
	}
	/**
	 * iapDesc�趨
	 *
	 * @param iapDesc iapDesc
	 */
	public void setIapDesc(String iapDesc) {
		this.iapDesc = iapDesc;
	}
	/**
	 * iapCooperatorȡ��
	 *
	 * @return iapCooperator iapCooperator
	 */
	public String getIapCooperator() {
		return iapCooperator;
	}
	/**
	 * iapCooperator�趨
	 *
	 * @param iapCooperator iapCooperator
	 */
	public void setIapCooperator(String iapCooperator) {
		this.iapCooperator = iapCooperator;
	}
	/**
	 * iapSuggestionȡ��
	 *
	 * @return iapSuggestion iapSuggestion
	 */
	public String getIapSuggestion() {
		return iapSuggestion;
	}
	/**
	 * iapSuggestion�趨
	 *
	 * @param iapSuggestion iapSuggestion
	 */
	public void setIapSuggestion(String iapSuggestion) {
		this.iapSuggestion = iapSuggestion;
	}
	/**
	 * iapCreateuserIdȡ��
	 *
	 * @return iapCreateUserId iapCreateUserId
	 */
	public String getIapCreateUserId() {
		return iapCreateUserId;
	}
	/**
	 * iapCreateuserId�趨
	 *
	 * @param iapCreateUserId iapCreateUserId
	 */
	public void setIapCreateUserId(String iapCreateUserId) {
		this.iapCreateUserId = iapCreateUserId;
	}
	/**
	 * iapCreateTimeȡ��
	 *
	 * @return iapCreateTime iapCreateTime
	 */
	public String getIapCreateTime() {
		return iapCreateTime;
	}
	/**
	 * iapCreateTime�趨
	 *
	 * @param iapCreateTime iapCreateTime
	 */
	public void setIapCreateTime(String iapCreateTime) {
		this.iapCreateTime = iapCreateTime;
	}
	/**
	 * iapConfirmuserIdȡ��
	 *
	 * @return iapConfirmUserId iapConfirmUserId
	 */
	public String getIapConfirmUserId() {
		return iapConfirmUserId;
	}
	/**
	 * iapConfirmuserId�趨
	 *
	 * @param iapConfirmUserId iapConfirmUserId
	 */
	public void setIapConfirmUserId(String iapConfirmUserId) {
		this.iapConfirmUserId = iapConfirmUserId;
	}
	/**
	 * iapConfirmTimeȡ��
	 *
	 * @return iapConfirmTime iapConfirmTime
	 */
	public String getIapConfirmTime() {
		return iapConfirmTime;
	}
	/**
	 * iapConfirmTime�趨
	 *
	 * @param iapConfirmTime iapConfirmTime
	 */
	public void setIapConfirmTime(String iapConfirmTime) {
		this.iapConfirmTime = iapConfirmTime;
	}
	/**
	 * iapAttKeyȡ��
	 *
	 * @return iapAttKey iapAttKey
	 */
	public String getIapAttKey() {
		return iapAttKey;
	}
	/**
	 * iapAttKey�趨
	 *
	 * @param iapAttKey iapAttKey
	 */
	public void setIapAttKey(String iapAttKey) {
		this.iapAttKey = iapAttKey;
	}
	/**
	 * iapTypeȡ��
	 *
	 * @return iapType iapType
	 */
	public String getIapType() {
		return iapType;
	}
	/**
	 * iapType�趨
	 *
	 * @param iapType iapType
	 */
	public void setIapType(String iapType) {
		this.iapType = iapType;
	}
	/**
	 * iapSourceȡ��
	 *
	 * @return iapSource iapSource
	 */
	public String getIapSource() {
		return iapSource;
	}
	/**
	 * iapSource�趨
	 *
	 * @param iapSource iapSource
	 */
	public void setIapSource(String iapSource) {
		this.iapSource = iapSource;
	}
	/**
	 * fileȡ��
	 *
	 * @return file file
	 */
	public FormFile getFile() {
		return file;
	}
	/**
	 * file�趨
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
	 * deletekeysȡ��
	 *
	 * @return deletekeys deletekeys
	 */
	public String getDeletekeys() {
		return deletekeys;
	}
	/**
	 * deletekeys�趨
	 *
	 * @param deletekeys deletekeys
	 */
	public void setDeletekeys(String deletekeys) {
		this.deletekeys = deletekeys;
	}
	/**
	 * ��ȡfileMap
	 * @return ffileMap fileMap
	 */
	public Map<Integer, FormFile> getFileMap() {
		return fileMap;
	}

	/**
	 * ����fileMap
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
	 * ��ȡ����
	 * @return ��ȡ����
	 */
	public FormFile getAttachFile(int index) {
		return (FormFile) fileMap.get(new Integer(index));
	}

	/**
	 * ���ø���
	 * @param index ������������
	 * @param file ����
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
