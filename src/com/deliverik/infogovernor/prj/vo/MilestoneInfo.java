/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.model.Attachment;

public class MilestoneInfo {
	private String msIndex;
	private String msStatus;
	private String msName;
	private String msCloseDate;
	private String msPlanDate;
	private String msplanDesc;
	private String msConfirmDate;
	private String msConfirmDesc;
	private String msColor;

	private List<Attachment> attachmentList;
	
	public String getMsColor() {
		return msColor;
	}

	public void setMsColor(String msColor) {
		this.msColor = msColor;
	}

	public String getMsIndex() {
		return msIndex;
	}

	public void setMsIndex(String msIndex) {
		this.msIndex = msIndex;
	}

	public String getMsStatus() {
		return msStatus;
	}

	public void setMsStatus(String msStatus) {
		this.msStatus = msStatus;
	}

	public String getMsName() {
		return msName;
	}

	public void setMsName(String msName) {
		this.msName = msName;
	}

	public String getMsPlanDate() {
		return msPlanDate;
	}

	public void setMsPlanDate(String msPlanDate) {
		this.msPlanDate = msPlanDate;
	}

	public String getMsplanDesc() {
		return msplanDesc;
	}

	public void setMsplanDesc(String msplanDesc) {
		this.msplanDesc = msplanDesc;
	}

	public String getMsConfirmDate() {
		return msConfirmDate;
	}

	public void setMsConfirmDate(String msConfirmDate) {
		this.msConfirmDate = msConfirmDate;
	}

	public String getMsConfirmDesc() {
		return msConfirmDesc;
	}

	public void setMsConfirmDesc(String msConfirmDesc) {
		this.msConfirmDesc = msConfirmDesc;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	public String getMsCloseDate() {
		return msCloseDate;
	}

	public void setMsCloseDate(String msCloseDate) {
		this.msCloseDate = msCloseDate;
	}

}
