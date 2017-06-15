/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.infogovernor.iam.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;


/**
 * 审计管理查询Form
 *
 * @author 
 */
@SuppressWarnings("serial")
public class IGIAM0102Form extends BaseForm implements Serializable {
	
	/** 无意义自增主键iapId */
	protected Integer iapId;
	
	/** 审计年度 */
	protected String iapYear;
	
	/** 审计项目名称 */
	protected String iapName;
	
	/** 审计项目状态 */
	protected String iapStatus;
	
	/** 审计开始日期开始 */
	protected String iapOpenTimeFrom;
	
	/** 审计开始日期结束 */
	protected String iapOpenTimeTo;
	
	/** 审计类型 */
	protected String iapType;
	
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
	 * iapOpenTimeFrom取得
	 *
	 * @return iapOpenTimeFrom iapOpenTimeFrom
	 */
	public String getIapOpenTimeFrom() {
		return iapOpenTimeFrom;
	}
	/**
	 * iapOpenTimeFrom设定
	 *
	 * @param iapOpenTimeFrom iapOpenTimeFrom
	 */
	public void setIapOpenTimeFrom(String iapOpenTimeFrom) {
		this.iapOpenTimeFrom = iapOpenTimeFrom;
	}
	/**
	 * iapOpenTimeTo取得
	 *
	 * @return iapOpenTimeTo iapOpenTimeTo
	 */
	public String getIapOpenTimeTo() {
		return iapOpenTimeTo;
	}
	/**
	 * iapOpenTimeTo设定
	 *
	 * @param iapOpenTimeTo iapOpenTimeTo
	 */
	public void setIapOpenTimeTo(String iapOpenTimeTo) {
		this.iapOpenTimeTo = iapOpenTimeTo;
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
	
	
	
}
