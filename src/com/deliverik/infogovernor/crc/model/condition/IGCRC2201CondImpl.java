/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.crc.model.condition;

/**
 * @Description: �������ͳ�Ʋ�ѯ����ʵ��
 * @Author zhangqiang
 * @History @2014-8-7�½�
 * 
 * @Version V1.0
 */
public class IGCRC2201CondImpl implements IGCRC2201Cond {

	/** �� */
	protected String year;

	/** �� */
	protected String month;

	/**
	 * ��ȡ��
	 * 
	 * @return year ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���趨
	 * 
	 * @param year
	 *            ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ȡ��
	 * 
	 * @return month ��
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * ���趨
	 * 
	 * @param month
	 *            ��
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
