/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �Ӵ�ͳ�Ʋ�ѯ�ӿ�ʵ��
 *
 */
public class RecptionVWSearchCondImpl implements RecptionVWSearchCond {
	
	/** ��ѯʱ��� ��ʼ���� */
	protected String rtime_from;
	
	/** ��ѯʱ��� ��ֹ���� */
	protected String rtime_to;
	
	/** ��� */
	protected String year;


	/**
	 * ��ѯʱ��� ��ʼ����ȡ��
	 * @return ��ѯʱ��� ��ʼ����
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * ��ѯʱ��� ��ʼ�����趨
	 * @param rtime_from ��ѯʱ��� ��ʼ����
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * ��ѯʱ��� ��ֹ����ȡ��
	 * @return ��ѯʱ��� ��ֹ����
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * ��ѯʱ��� ��ֹ�����趨
	 * @param rtime_to ��ѯʱ��� ��ֹ����
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	/**
	 * ���ȡ��
	 * @return ���
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
}
