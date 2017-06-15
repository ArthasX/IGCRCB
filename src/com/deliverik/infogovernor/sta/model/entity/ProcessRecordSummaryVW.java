/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.sta.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.sta.model.ProcessRecordSummary;

/**
 * 
 * �������ͳ��ʵ��
 * 
 */
@SuppressWarnings("serial")
@Entity
public class ProcessRecordSummaryVW implements Serializable,Cloneable, ProcessRecordSummary{

	/** ID */
	@Id
	protected Integer prsid;
	
	/** ������������ */
	protected String pname;
	
	/** �������� */
	protected String pcode;
	
	/** ������Դ */
	protected String prassetname;
	
	/** �ȴ��ƶ��ƻ����� */
	protected Integer initials;
	
	/** �ȴ��ƶ��ƻ����� */
	protected Integer dispatch;
	
	/** �ȴ������ƻ����� */
	protected Integer appoval;
	
	/** �ȴ�����ִ������ */
	protected Integer implement;
	
	/** �ȴ���֤���� */
	protected Integer verify;
	
	/** �ر����� */
	protected Integer close;
	
	public boolean equals(Object obj) {
		if (!(obj instanceof ProcessRecordSummaryVW))
			return false;
		ProcessRecordSummary target = (ProcessRecordSummary) obj;
		if (!(getPrsid().equals(target.getPrsid())))
			return false;
		return true;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */	
	public Integer getPrsid() {
		return prsid;
	}

	/**
	 * �����趨
	 * @param prsid ����
	 */
	public void setPrsid(Integer prsid) {
		this.prsid = prsid;
	}

	/**
	 * ������������ȡ��
	 * @return ������������
	 */	
	public String getPname() {
		return pname;
	}
	
	/**
	 * �������������趨
	 * @param pname ������������
	 */
	public void setPname(String pname) {
		this.pname = pname;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */	
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���������趨
	 * @param pcode ��������
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ������Դȡ��
	 * @return ������Դ
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * ������Դ�趨
	 * @param prassetname ������Դ
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}


	/**
     * �ȴ��ƶ��ƻ�����ȡ��
     *
     * @return initials �ȴ��ƶ��ƻ�����
     */
    public Integer getInitials() {
        return initials;
    }

    /**
     * �ȴ��ƶ��ƻ������趨
     *
     * @param initials �ȴ��ƶ��ƻ�����
     */
    public void setInitials(Integer initials) {
        this.initials = initials;
    }

    /**
	 * �ȴ������ƻ�����ȡ��
	 * @return �ȴ������ƻ�����
	 */	
	public Integer getAppoval() {
		return appoval;
	}

	/**
	 * �ȴ������ƻ������趨
	 * @param appoval �ȴ������ƻ�����
	 */
	public void setAppoval(Integer appoval) {
		this.appoval = appoval;
	}

	/**
	 * �ȴ�����ִ������ȡ��
	 * @return �ȴ�����ִ������
	 */	
	public Integer getImplement() {
		return implement;
	}

	/**
	 * �ʵȴ�����ִ�������趨
	 * @param implement �ȴ�����ִ������
	 */
	public void setImplement(Integer implement) {
		this.implement = implement;
	}

	/**
	 * �ȴ���֤����ȡ��
	 * @return �ȴ���֤����
	 */	
	public Integer getVerify() {
		return verify;
	}

	/**
	 * �ȴ���֤�����趨
	 * @param verify �ȴ���֤����
	 */
	public void setVerify(Integer verify) {
		this.verify = verify;
	}

	/**
	 * �ر�����ȡ��
	 * @return �ر�����
	 */	
	public Integer getClose() {
		return close;
	}

	/**
	 * �ر������趨
	 * @param close �ر�����
	 */
	public void setClose(Integer close) {
		this.close = close;
	}
	
	/**
	 * �ȴ��ƶ��ƻ�����ȡ��
	 * @return �ȴ��ƶ��ƻ�����
	 */
	public Integer getDispatch() {
		return dispatch;
	}
	
	/**
	 * �ȴ��ƶ��ƻ������趨
	 * @param dispatch �ȴ��ƶ��ƻ�����
	 */
	public void setDispatch(Integer dispatch) {
		this.dispatch = dispatch;
	}

}
