/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * Ԥ֧��Ա��ѯ�ӿ�ʵ��
 *
 */
public class PersonLoanSummarySearchCondImpl implements PersonLoanSummarySearchCond {
	
	/**
	 * ������������������
	 */
	protected String lpduserorg;
	
	/**
	 * ����ѯʱ�俪ʼ
	 */
	protected String lpddate_from;
	
	/**
	 * ����ѯʱ�����
	 */
	protected String lpddate_to;

	/**
	 * �������������������趨
	 * @return ������������������
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * �������������������趨
	 * @param lpduserorg ������������������
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * ����ѯʱ�俪ʼ�趨
	 * @return ����ѯʱ�俪ʼ
	 */
	public String getLpddate_from() {
		return lpddate_from;
	}

	/**
	 * ����ѯʱ�俪ʼ�趨
	 * @param lpddate_from ����ѯʱ�俪ʼ
	 */
	public void setLpddate_from(String lpddate_from) {
		this.lpddate_from = lpddate_from;
	}

	/**
	 * ����ѯʱ������趨
	 * @return ����ѯʱ�����
	 */
	public String getLpddate_to() {
		return lpddate_to;
	}

	/**
	 * ����ѯʱ������趨
	 * @param lpddate_to ����ѯʱ�����
	 */
	public void setLpddate_to(String lpddate_to) {
		this.lpddate_to = lpddate_to;
	}
	
}