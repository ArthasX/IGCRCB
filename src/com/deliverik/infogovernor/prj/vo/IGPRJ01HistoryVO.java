/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */
package com.deliverik.infogovernor.prj.vo;

import java.util.List;

import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.prj.model.ProjectLog;

public class IGPRJ01HistoryVO {

	private ProjectLog projectLog;

	public ProjectLog getProjectLog() {
		return projectLog;
	}

	public void setProjectLog(ProjectLog projectLog) {
		this.projectLog = projectLog;
	}

	public List<Attachment> getAttachmentList() {
		return attachmentList;
	}

	
	public void setAttachmentList(List<Attachment> attachmentList) {
		this.attachmentList = attachmentList;
	}

	private List<Attachment> attachmentList;

}
