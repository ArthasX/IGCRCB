/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.infogovernor.crc.form;

import com.deliverik.framework.base.BaseForm;

/**	
 * ����:���򿪷�ͳ��Form
 * ������¼��yukexin    2014-8-15 ����5:17:08	
 * �޸ļ�¼��null
 */	
@SuppressWarnings("serial")
public class IGCRC2301Form extends BaseForm{
	
	/** ��� */
	protected String year;
	
	/** �������û�id*/
	protected String userID;
		
	/**��ȡ��־λ*/
	protected String flag;	

	/** �·� */
	protected String month;

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
	 * @return the userID
	 */
	public String getUserID() {
		return userID;
	}

	/**
	 * @param userID the userID to set
	 */
	public void setUserID(String userID) {
		this.userID = userID;
	}

	/**
	 * @return the flag
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * @param flag the flag to set
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}
	
	
	
	
}
