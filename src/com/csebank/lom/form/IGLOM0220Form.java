/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.InventorySearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ÿ���̵�form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0220Form extends BaseForm implements InventorySearchCond{
	
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
