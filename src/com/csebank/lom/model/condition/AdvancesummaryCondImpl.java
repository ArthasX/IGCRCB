/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

public class AdvancesummaryCondImpl implements AdvancesummaryCond {
    
	/** ��ѯ�� */
	protected String year;

	/**
	 * ��ѯ��ȡ��
	 * @return ��ѯ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ��ѯ���趨
	 * @param year ��ѯ��
	 */
	public void setYear(String year) {
		this.year = year;
	}


}
