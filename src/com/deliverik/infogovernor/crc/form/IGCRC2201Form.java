/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**	
 * ����:�������ͳ��Form
 * ������¼��yukexin    2014-8-15 ����5:16:37	
 * �޸ļ�¼��null
 */	
public class IGCRC2201Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	/** �� */
	protected String year;

	/** �� */
	protected String month;

	/**
	 * ��ȡ��
	 * @return year  ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���趨
	 * @param year  ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ȡ��
	 * @return month  ��
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * ���趨
	 * @param month  ��
	 */
	public void setMonth(String month) {
		this.month = month;
	}
	
}
