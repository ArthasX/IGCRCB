/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
/**
 * ����:��Ϣ���ڱ������FORM
 * ������¼����� 2011/10/18
 * ����������SOCԭ��Ϣʱ���趨
 * �޸�ʱ�䣺LuJiayuan 2013/01/29 ����ϲ���ԭIGSYM1703Form����IGSYM1903Form
 */
@SuppressWarnings("serial")
public class IGSYM1903Form extends BaseForm{
	/**
	 * ����
	 */
	protected Integer pwtId;
	
	/** �������� */
	protected String pwtDate;

	/** ������ʼʱ��Сʱ */
	protected String pwtStartTimeHour;
	
	/** ������ʼʱ����� */
	protected String pwtStartTimeMin;

	/** ��������ʱ��Сʱ */
	protected String pwtEndTimeHour;
	
	/** ��������ʱ����� */
	protected String pwtEndTimeMin;

	/** ��Ϣʱ�� */
	protected Integer pwtSleepTime;

	/** ��Чʱ�� */
	protected Integer factTime;

	/**
	 * ������ȡ
	 * @return
	 */
	public Integer getPwtId() {
		return pwtId;
	}

	/**
	 * �����趨
	 * @param pwtId
	 */
	public void setPwtId(Integer pwtId) {
		this.pwtId = pwtId;
	}

	/**
	 * ���ڻ�ȡ
	 * @return
	 */
	public String getPwtDate() {
		return pwtDate;
	}

	/**
	 * �����趨
	 * @param pwtDate
	 */
	public void setPwtDate(String pwtDate) {
		this.pwtDate = pwtDate;
	}

	/**
	 * ��Ϣʱ���ȡ
	 * @return
	 */
	public Integer getPwtSleepTime() {
		return pwtSleepTime;
	}

	/**
	 * ��Ϣʱ���趨
	 * @param pwtSleepTime
	 */
	public void setPwtSleepTime(Integer pwtSleepTime) {
		this.pwtSleepTime = pwtSleepTime;
	}

	/**
	 * ��ʱ��ȡ
	 * @return
	 */
	public Integer getFactTime() {
		return factTime;
	}

	/**
	 * ��ʱ�趨
	 * @param factTime
	 */
	public void setFactTime(Integer factTime) {
		this.factTime = factTime;
	}

	/**
	 * ��ʼʱ��Сʱ��ȡ
	 * @return
	 */
	public String getPwtStartTimeHour() {
		return pwtStartTimeHour;
	}

	/**
	 * ��ʼʱ��Сʱ�趨
	 * @param pwtStartTimeHour
	 */
	public void setPwtStartTimeHour(String pwtStartTimeHour) {
		this.pwtStartTimeHour = pwtStartTimeHour;
	}

	/**
	 * ��ʼʱ����ӻ�ȡ
	 * @return
	 */
	public String getPwtStartTimeMin() {
		return pwtStartTimeMin;
	}

	/**
	 * ��ʼʱ������趨
	 * @param pwtStartTimeMin
	 */
	public void setPwtStartTimeMin(String pwtStartTimeMin) {
		this.pwtStartTimeMin = pwtStartTimeMin;
	}

	/**
	 * ����ʱ��Сʱ��ȡ
	 * @return
	 */
	public String getPwtEndTimeHour() {
		return pwtEndTimeHour;
	}

	/**
	 * ����ʱ��Сʱ�趨
	 * @param pwtEndTimeHour
	 */
	public void setPwtEndTimeHour(String pwtEndTimeHour) {
		this.pwtEndTimeHour = pwtEndTimeHour;
	}

	/**
	 * ����ʱ����ӻ�ȡ
	 * @return
	 */
	public String getPwtEndTimeMin() {
		return pwtEndTimeMin;
	}

	/**
	 * ����ʱ������趨
	 * @param pwtEndTimeMin
	 */
	public void setPwtEndTimeMin(String pwtEndTimeMin) {
		this.pwtEndTimeMin = pwtEndTimeMin;
	}
}
