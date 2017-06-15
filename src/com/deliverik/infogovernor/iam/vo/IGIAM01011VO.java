/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.iam.vo;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BaseVO;
import com.deliverik.framework.model.Attachment;
import com.deliverik.infogovernor.iam.form.IGIAM0101Form;
import com.deliverik.infogovernor.iam.model.InternalauditprjInfo;

/**
 * ��ư汾��Ϣ��������֣�
 * 
 * @author
 */
@SuppressWarnings("serial")
public class IGIAM01011VO extends BaseVO implements Serializable{
	
	/** ��ư汾��Ϣ������� */
	protected List<IGIAM0101Form> internalauditprjInfoList;
	/** ��ݼ������ */
	protected List<String> iamYearList;
	/** �ʼ���Ϣʵ�� */
    protected InternalauditprjInfo internalauditprjInfo;
	
    /** �������Ǽ�ҳ������Ŀ����ҳList*/
    protected List<InternalauditprjInfo> helpSearchList;
    
    /** ����List */
    protected List<Attachment> attkeyList;

	/**
	 * internalauditprjInfoȡ��
	 *
	 * @return internalauditprjInfo internalauditprjInfo
	 */
	public InternalauditprjInfo getInternalauditprjInfo() {
		return internalauditprjInfo;
	}

	/**
	 * internalauditprjInfo�趨
	 *
	 * @param internalauditprjInfo internalauditprjInfo
	 */
	public void setInternalauditprjInfo(InternalauditprjInfo internalauditprjInfo) {
		this.internalauditprjInfo = internalauditprjInfo;
	}

	/**
	 * ���캯��
	 * @param riskAudit����ư汾��Ϣ�������
	 */
	public void setInternalauditprjInfoList(List<IGIAM0101Form> internalauditprjInfoList) {
		this.internalauditprjInfoList = internalauditprjInfoList;
	}
	
	/**
	 * ��ư汾��Ϣ�������ȡ��
	 * @return ��ư汾��Ϣ�������
	 */
	public List<IGIAM0101Form> getInternalauditprjInfoList() {
		return internalauditprjInfoList;
	}
	
	/**
	 * iamYearListȡ��
	 *
	 * @return iamYearList iamYearList
	 */
	public List<String> getIamYearList() {
		return iamYearList;
	}

	/**
	 * iamYearList�趨
	 *
	 * @param iamYearList iamYearList
	 */
	public void setIamYearList(List<String> iamYearList) {
		this.iamYearList = iamYearList;
	}

	/**
	 * ��ȡhelpSearchList
	 * @return fhelpSearchList helpSearchList
	 */
	public List<InternalauditprjInfo> getHelpSearchList() {
		return helpSearchList;
	}

	/**
	 * ����helpSearchList
	 * @param helpSearchList  helpSearchList
	 */
	public void setHelpSearchList(List<InternalauditprjInfo> helpSearchList) {
		this.helpSearchList = helpSearchList;
	}

	/**
	 * attkeyListȡ��
	 *
	 * @return attkeyList attkeyList
	 */
	public List<Attachment> getAttkeyList() {
		return attkeyList;
	}

	/**
	 * attkeyList�趨
	 *
	 * @param attkeyList attkeyList
	 */
	public void setAttkeyList(List<Attachment> attkeyList) {
		this.attkeyList = attkeyList;
	}

}


