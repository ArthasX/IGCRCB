/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**	
 * ����:��Ա����ͳ��Form
 * ������¼��yukexin    2014-8-15 ����5:16:51	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2101Form extends BaseForm{
	
	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;

	/** ���� */
	protected String department;

	protected String propentime;
	
	protected String ppinittime;
	
	/**
	 * ���ȡ��
	 * @return year  ���
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ����趨
	 * @param year  ���
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �·�ȡ��
	 * @return month  �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month  �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ����ȡ��
	 * @return department  ����
	 */
	public String getDepartment() {
		return department;
	}

	/**
	 * �����趨
	 * @param department  ����
	 */
	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 * @return the propentime
	 */
	public String getPropentime() {
		return propentime;
	}

	/**
	 * @param propentime the propentime to set
	 */
	public void setPropentime(String propentime) {
		this.propentime = propentime;
	}

	/**
	 * @return the ppinittime
	 */
	public String getPpinittime() {
		return ppinittime;
	}

	/**
	 * @param ppinittime the ppinittime to set
	 */
	public void setPpinittime(String ppinittime) {
		this.ppinittime = ppinittime;
	}
	
	
	
}
