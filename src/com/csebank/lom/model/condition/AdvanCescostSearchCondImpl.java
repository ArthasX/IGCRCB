/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * Ԥ֧���ò�ѯ�ӿ�ʵ��
 *
 */
public class AdvanCescostSearchCondImpl implements AdvanCescostSearchCond {
	
	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	protected String acdate_from;
	
	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	protected String acdate_to;
	/**
	 * Ԥ֧����״̬
	 */
	protected String acstatus_q;

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼȡ��
	 * @return Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	public String getAcdate_from() {
		return acdate_from;
	}

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ�趨
	 * @param acdate_from Ԥ֧���üƲƼ������ڲ�ѯʱ�俪ʼ
	 */
	public void setAcdate_from(String acdate_from) {
		this.acdate_from = acdate_from;
	}

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ�����ȡ��
	 * @return Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	public String getAcdate_to() {
		return acdate_to;
	}

	/**
	 * Ԥ֧���üƲƼ������ڲ�ѯʱ������趨
	 * @param acdate_to Ԥ֧���üƲƼ������ڲ�ѯʱ�����
	 */
	public void setAcdate_to(String acdate_to) {
		this.acdate_to = acdate_to;
	}


	/**
	 * Ԥ֧����״̬ȡ��
	 * @return Ԥ֧����״̬
	 */
	public String getAcstatus_q() {
		return acstatus_q;
	}

	/**
	 * Ԥ֧����״̬�趨
	 * @param acstatus_q Ԥ֧����״̬
	 */
	public void setAcstatus_q(String acstatus_q) {
		this.acstatus_q = acstatus_q;
	}
	
}
