/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */
package com.deliverik.infogovernor.sta.model.condition;

/**
 * �������ͳ�Ʋ�ѯ����ʵ��
 */
public class ProcessRecordSummarySearchCondImpl implements ProcessRecordSummarySearchCond{
	
	/** ͳ������ */
	protected String statistictype;
	
	/** �������� */
	protected String pcode;
	
	/** ������Դ */
	protected String prassetname;
	
	/** �������ķ�������form */
	protected String propentime_from;
	
	/** �������ķ�������to*/
	protected String propentime_to;
	
	/**���̼�¼����*/
	protected String prtype;
	
	/**
	 * ��������ȡ��
	 * @return ��������
	 */	
	public String getPcode() {
		return pcode;
	}

	/**
	 * ���������趨
	 * @param pcode ��������
	 */
	public void setPcode(String pcode) {
		this.pcode = pcode;
	}

	/**
	 * ������Դȡ��
	 * @return ������Դ
	 */
	public String getPrassetname() {
		return prassetname;
	}

	/**
	 * ������Դ�趨
	 * @param prassetname ������Դ
	 */
	public void setPrassetname(String prassetname) {
		this.prassetname = prassetname;
	}

	/**
	 * �������ķ�������formȡ��
	 * @return �������ķ�������form
	 */	
	public String getPropentime_from() {
		return propentime_from;
	}

	/**
	 * �������ķ�������form�趨
	 * @param propentime_from �������ķ�������form
	 */
	public void setPropentime_from(String propentime_from) {
		this.propentime_from = propentime_from;
	}

	/**
	 * �������ķ�������toȡ��
	 * @return �������ķ�������to
	 */	
	public String getPropentime_to() {
		return propentime_to;
	}

	/**
	 * �������ķ�������to�趨
	 * @param propentime_to �������ķ�������to
	 */
	public void setPropentime_to(String propentime_to) {
		this.propentime_to = propentime_to;
	}

	/**
	 * ���̼�¼����ȡ��
	 * @return ���̼�¼����
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * ���̼�¼�����趨
	 * @param prtype ���̼�¼����
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ͳ������ȡ��
	 * @return ͳ������
	 */	
	public String getStatistictype() {
		return statistictype;
	}

	/**
	 * ͳ�������趨
	 * @param statistictype ͳ������
	 */
	public void setStatistictype(String statistictype) {
		this.statistictype = statistictype;
	}
}
