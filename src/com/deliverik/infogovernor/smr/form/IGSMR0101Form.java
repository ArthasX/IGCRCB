/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * �걨����Form
 *
 */
@SuppressWarnings("serial")
public class IGSMR0101Form extends BaseForm {
	
	/** ��� */
	protected String year;
	
	/** �����ʱ�� */
	protected String limittime;

	/** ��ע */
	protected String remark;
	
	/** �Ƿ���Է��� */
	protected String test;

	/**
	 * ���ȡ��
	 * @return ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ����趨
	 * @param year ���
	 */
	public void setYear(String year) {
		this.year = year;
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