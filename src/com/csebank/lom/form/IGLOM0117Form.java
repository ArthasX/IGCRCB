/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.DealVWSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * ģ�飺��ǰ����-�Ӵ�����
 * ˵��������Ͳ��¶�ͳ��Form
 * ���ߣ�������
 */
public class IGLOM0117Form extends BaseForm implements DealVWSearchCond {
	
	
	private static final long serialVersionUID = 1L;

	
	/** ��ѯ���ڶο�ʼ */
	protected String rtime_from;
	
	/** ��ѯ���ڶν��� */
	protected String rtime_to;
	
	protected String year;

	/**
	 * ��ѯ���ڶο�ʼȡ��
	 * @return ��ѯ���ڶο�ʼ
	 */
	public String getRtime_from() {
		return rtime_from;
	}

	/**
	 * ��ѯ���ڶο�ʼ�趨
	 * @param rtime_from ��ѯ���ڶο�ʼ
	 */
	public void setRtime_from(String rtime_from) {
		this.rtime_from = rtime_from;
	}

	/**
	 * ��ѯ���ڶν���ȡ��
	 * @return ��ѯ���ڽ���
	 */
	public String getRtime_to() {
		return rtime_to;
	}

	/**
	 * ��ѯ���ڶν����趨
	 * @param rtime_to ��ѯ���ڶο�ʼ
	 */
	public void setRtime_to(String rtime_to) {
		this.rtime_to = rtime_to;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

}
