/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.soc.mnt.form;


import com.deliverik.framework.base.BaseForm;

/**
 * ����:������ͷ�ֵ��Ϣform
 * ����������
 * ������¼�����    2012/02/09
 */
@SuppressWarnings("serial")
public class IGMNT0102Form extends BaseForm{
	
	/**
	 * ����id����
	 */
	protected String[] mtdId;

	/**
	 * �������id
	 */
	protected Integer mtId;

	/**
	 * ������ͷ�ֵ����
	 */
	protected String[] mtdValue;
	
	/**
	 * �������״̬
	 */
	protected String[] deleteFlag;
	
	/**
	 * �ȽϷ�����
	 */
	protected String[] compare;
	
	/**
	 * �澯����
	 */
	protected String[] mtdDes;
	
	/**
	 * ������ͷ�ֵ�����ȡ
	 * @return
	 */
	public String[] getMtdValue() {
		return mtdValue;
	}

	/**
	 * ������ͷ�ֵ�����趨
	 * @param mtdValue
	 */
	public void setMtdValue(String[] mtdValue) {
		this.mtdValue = mtdValue;
	}

	/**
	 * �������id��ȡ
	 * @return
	 */
	public Integer getMtId() {
		return mtId;
	}

	/**
	 * �������id�趨
	 * @param mtId
	 */
	public void setMtId(Integer mtId) {
		this.mtId = mtId;
	}

	/**
	 * �������״̬��ȡ
	 * @return
	 */
	public String[] getDeleteFlag() {
		return deleteFlag;
	}

	/**
	 * �������״̬�趨
	 * @param deleteFlag
	 */
	public void setDeleteFlag(String[] deleteFlag) {
		this.deleteFlag = deleteFlag;
	}
	
	/**
	 * ����id�����ȡ
	 * @return
	 */
	public String[] getMtdId() {
		return mtdId;
	}

	/**
	 * ����id�����趨
	 * @param mtdId
	 */
	public void setMtdId(String[] mtdId) {
		this.mtdId = mtdId;
	}

	/**
	 * �ȽϷ�����ȡ��
	 * @return
	 */
	public String[] getCompare() {
		return compare;
	}

	/**
	 * �ȽϷ������趨
	 * @param compare
	 */
	public void setCompare(String[] compare) {
		this.compare = compare;
	}

	/**
	 * �澯����ȡ��
	 * @return
	 */
	public String[] getMtdDes() {
		return mtdDes;
	}

	/**
	 * �澯�����趨
	 * @param mtdDes
	 */
	public void setMtdDes(String[] mtdDes) {
		this.mtdDes = mtdDes;
	}
}
