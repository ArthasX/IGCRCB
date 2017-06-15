/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.fin.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;

/**
 * IGFIN01011VO
 * 
 * @author
 * 
 */
public class IGFIN02014VO extends BaseVO implements Serializable {

	private static final long serialVersionUID = -7006925929512823032L;
	
	protected List<Attachment> attachmentDataList;

	public IGFIN02014VO(List<Attachment> attachmentDataList) {
		this.attachmentDataList = attachmentDataList;
	}

	public List<Attachment> getAttachmentDataList() {
		return attachmentDataList;
	}

}
