/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;


/**
 * ��ƹ����ѯForm
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM0102Form extends BaseForm implements Serializable {
	
	/** ��������������iapId */
	protected Integer iapId;
	
	/** ������ */
	protected String iapYear;
	
	/** �����Ŀ���� */
	protected String iapName;
	
	/** �����Ŀ״̬ */
	protected String iapStatus;
	
	/** ��ƿ�ʼ���ڿ�ʼ */
	protected String iapOpenTimeFrom;
	
	/** ��ƿ�ʼ���ڽ��� */
	protected String iapOpenTimeTo;
	
	/** ������� */
	protected String iapType;
	
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
	 * iapOpenTimeFromȡ��
	 *
	 * @return iapOpenTimeFrom iapOpenTimeFrom
	 */
	public String getIapOpenTimeFrom() {
		return iapOpenTimeFrom;
	}
	/**
	 * iapOpenTimeFrom�趨
	 *
	 * @param iapOpenTimeFrom iapOpenTimeFrom
	 */
	public void setIapOpenTimeFrom(String iapOpenTimeFrom) {
		this.iapOpenTimeFrom = iapOpenTimeFrom;
	}
	/**
	 * iapOpenTimeToȡ��
	 *
	 * @return iapOpenTimeTo iapOpenTimeTo
	 */
	public String getIapOpenTimeTo() {
		return iapOpenTimeTo;
	}
	/**
	 * iapOpenTimeTo�趨
	 *
	 * @param iapOpenTimeTo iapOpenTimeTo
	 */
	public void setIapOpenTimeTo(String iapOpenTimeTo) {
		this.iapOpenTimeTo = iapOpenTimeTo;
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
	
	
	
}
