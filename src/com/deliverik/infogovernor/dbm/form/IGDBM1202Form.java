/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description:�Ƽ������ۺϷ�����Form 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
public class IGDBM1202Form extends BaseForm{

	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;
	
	/** ʱ���ʶ */
	protected String date;
	/**
	 * ���ȡ��
	 * @return year ���
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
	 * �·�ȡ��
	 * @return month �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * ʱ���ʶȡ��
	 * @return date ʱ���ʶ
	 */
	public String getDate() {
		return date;
	}

	/**
	 * ʱ���ʶ�趨
	 * @param date ʱ���ʶ
	 */
	public void setDate(String date) {
		this.date = date;
	}
}
