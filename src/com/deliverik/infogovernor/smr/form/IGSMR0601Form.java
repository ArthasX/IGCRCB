/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:��������
 * ������������������
 * �����ˣ�����͢
 * ������¼�� 2013-08-07
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR0601Form extends BaseForm {
	
	/** ��� */
	protected String year;

	/** ���� */
	protected String quarter;
	
	/** �����ʱ�� */
	protected String limittime;

	/** ��ע */
	protected String remark;
	
	/** �Ƿ���Է��� */
	protected String test;
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getQuarter() {
		return quarter;
	}
	/**
	 * �����趨
	 * @param year ����
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param limittime �����ʱ��
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 *
	 * @param remark ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * �Ƿ���Է���ȡ��
	 * 
	 * @return �Ƿ���Է���
	 */
	public String getTest() {
		return test;
	}

	/**
	 * �Ƿ���Է����趨
	 * 
	 * @param test �Ƿ���Է���
	 */
	public void setTest(String test) {
		this.test = test;
	}
}
