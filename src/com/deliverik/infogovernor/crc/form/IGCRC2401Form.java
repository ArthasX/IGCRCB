package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ���ܣ��¼�ƽ�����ʱ��Form
 *       �޸ļ�¼ 2014-12-25 ����sign��ʶ
 *       zhangq@deliverik.com
 */
public class IGCRC2401Form extends BaseForm{
	
	/**   */	
	private static final long serialVersionUID = 1L;

	/** �� */	
	protected String year;
	
	/**��*/
	protected String month;
	
	/**����*/
	protected String dept;
	
	/** ������������*/
	protected String prid_In;
	/**
	 *1.�¼�
	 *2.�澯 
	 */
	protected String sign;
	
	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �����������ϻ�ȡ
	 * @return the prid_In
	 */
	public String getPrid_In() {
		return prid_In;
	}

	/**
	 * �������������趨
	 * @param prid_In
	 */
	public void setPrid_In(String prid_In) {
		this.prid_In = prid_In;
	}
}
