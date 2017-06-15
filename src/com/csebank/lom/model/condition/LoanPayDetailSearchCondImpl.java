/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.condition;

/**
 * 
 * �軹����ϸ��ѯ�ӿ�ʵ��
 *
 */
public class LoanPayDetailSearchCondImpl implements LoanPayDetailSearchCond {
	
	/** ����� */
	protected String lpduser_q;
	
	/** �軹������ */
	protected String lpdtype_q;
	
	/** ��Ʊ���ڿ�ʼ */
	protected String lpdinvoicedate_from;
	
	/** ��Ʊ���ڽ��� */
	protected String lpdinvoicedate_to;
	
	/** ��Ʊ��� */
	protected String lpdinvoiceamount_q;
	
	/** ״̬ */
	protected String lpdstatus_q;
	
	/** �Ӵ�ID */
	protected Integer rid_q;
	
	/** ���ID */
	protected Integer lpdid;
	protected Integer ldid_invoice;
	/**����ѯ��ʼʱ�� */
	protected String time_from;
	/**����ѯ����ʱ�� */
	protected String time_to;
	/**�������״̬ */
	protected String spType ;
	
	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getLpduser_q() {
		return lpduser_q;
	}

	/**
	 * ������趨
	 * @param lpduser �����
	 */
	public void setLpduser_q(String lpduser_q) {
		this.lpduser_q = lpduser_q;
	}

	/**
	 * ��Ʊ���ڿ�ʼȡ��
	 * @return ��Ʊ���ڿ�ʼ
	 */
	public String getLpdinvoicedate_from() {
		return lpdinvoicedate_from;
	}

	/**
	 * ��Ʊ���ڿ�ʼ�趨
	 * @param lpdinvoicedate_from ��Ʊ���ڿ�ʼ
	 */
	public void setLpdinvoicedate_from(String lpdinvoicedate_from) {
		this.lpdinvoicedate_from = lpdinvoicedate_from;
	}

	/**
	 * ��Ʊ���ڽ���ȡ��
	 * @return ��Ʊ���ڽ���
	 */
	public String getLpdinvoicedate_to() {
		return lpdinvoicedate_to;
	}

	/**
	 * ��Ʊ���ڽ����趨
	 * @param lpdinvoicedate_to ��Ʊ���ڽ���
	 */
	public void setLpdinvoicedate_to(String lpdinvoicedate_to) {
		this.lpdinvoicedate_to = lpdinvoicedate_to;
	}

	/**
	 * �������ȡ��
	 * @return �������
	 */
	public String getLpdtype_q() {
		return lpdtype_q;
	}
	
	/**
	 * ��������趨
	 * @param lpdtype_q �������
	 */
	public void setLpdtype_q(String lpdtype_q) {
		this.lpdtype_q = lpdtype_q;
	}
	
	/**
	 * ��Ʊ���ȡ��
	 * @return ��Ʊ���
	 */
	public String getLpdinvoiceamount_q() {
		return lpdinvoiceamount_q;
	}
	
	/**
	 * ��Ʊ����趨
	 * @param lpdinvoiceamount_q ��Ʊ���
	 */
	public void setLpdinvoiceamount_q(String lpdinvoiceamount_q) {
		this.lpdinvoiceamount_q = lpdinvoiceamount_q;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getLpdstatus_q() {
		return lpdstatus_q;
	}

	/**
	 * ״̬�趨
	 * @param lpdstatus_q ״̬
	 */
	public void setLpdstatus_q(String lpdstatus_q) {
		this.lpdstatus_q = lpdstatus_q;
	}

	/**
	 * �Ӵ�IDȡ��
	 * @return �Ӵ�ID
	 */
	public Integer getRid_q() {
		return rid_q;
	}

	/**
	 * �Ӵ�ID�趨
	 * @param rid_q �Ӵ�ID
	 */
	public void setRid_q(Integer rid_q) {
		this.rid_q = rid_q;
	}

	/**
	 * ���IDȡ��
	 * @return ���ID
	 */
	public Integer getLpdid() {
		return lpdid;
	}

	/**
	 * ���ID�趨
	 * @param lpdid ���ID
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
	}

	public Integer getLdid_invoice() {
		return ldid_invoice;
	}

	public void setLdid_invoice(Integer ldid_invoice) {
		this.ldid_invoice = ldid_invoice;
	}

	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}

}
