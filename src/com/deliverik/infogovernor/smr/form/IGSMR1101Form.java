/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.form;

import com.deliverik.framework.base.BaseForm;

/**
 * ����:�·ݷ���
 * �����������·ݷ���
 * �����ˣ��Ų�
 * ������¼�� 2015/09/14
 * �޸ļ�¼��
 */
@SuppressWarnings("serial")
public class IGSMR1101Form extends BaseForm {
	
	/** ��� */
	protected String year;

	/** �·� */
	protected String month;
	
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
	 * �·�ȡ��
	 * @return �·�
	 */
	public String getMonth() {
		return month;
	}
	/**
	 * �·��趨
	 * @param year �·�
	 */
	public void setMonth(String month) {
		this.month = month;
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
