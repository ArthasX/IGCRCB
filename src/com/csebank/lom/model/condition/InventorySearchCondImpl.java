/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * ÿ���̵��ѯ�ӿ�ʵ��
 *
 */
public class InventorySearchCondImpl implements InventorySearchCond{
	
	/** �� */
	protected String year;
	
	/** �� */
	protected String month;

	/**
	 * ��ȡ��
	 * @return ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���趨
	 * @param year ��
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * ��ȡ��
	 * @return ��
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * ���趨
	 * @param month ��
	 */
	public void setMonth(String month) {
		this.month = month;
	}

}
