/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.svc.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * </p>
 */
public class SummaryCountPersonSearchCondImpl implements SummaryCountPersonSearchCond{


	/** ��� */
	protected String year;
	
	/** �·� */
	protected String month;




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
}
