/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.form;

import com.deliverik.framework.base.BaseForm;
/**
 * ����:��Ϣ����ģ���ѯ����FORM
 * ������¼�����    2011/10/18
 * ����������SOCԭ��Ϣʱ���趨
 * �޸�ʱ�䣺LuJiayuan 2013/01/29 ����ϲ���ԭIGSYM1701Form����IGSYM1901Form
 */
@SuppressWarnings("serial")
public class IGSYM1901Form extends BaseForm {
	
	/**
	 * ��ѯ��
	 */
	protected Integer year;
	
	/**
	 * ��ѯ��
	 */
	protected Integer month;

	/**
	 * ��ѯ���ȡ
	 * @return
	 */
	public Integer getYear() {
		return year;
	}

	/**
	 * ��ѯ���趨
	 * @param year
	 */
	public void setYear(Integer year) {
		this.year = year;
	}

	/**
	 * ��ѯ�»�ȡ
	 * @return
	 */
	public Integer getMonth() {
		return month;
	}

	/**
	 * ��ѯ���趨
	 * @param month
	 */
	public void setMonth(Integer month) {
		this.month = month;
	}

}
