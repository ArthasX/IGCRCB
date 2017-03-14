/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ��ּƲƲ����form
 *
 */
public class IGLOM0307Form extends BaseForm implements LoanPayDetailSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** ����� */
	protected String lpduser_q;
	
	/** ���ɾ������ */
	protected String[] deleteLpdid;
	
	/** �軹������ */
	protected String lpdtype_q = IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE;
	
	/** ��Ʊ���ڿ�ʼ */
	protected String lpdinvoicedate_from;
	
	/** ��Ʊ���ڽ��� */
	protected String lpdinvoicedate_to;
	
	/** ��Ʊ��� */
	protected String lpdinvoiceamount_q = "0";
	
	/** ״̬ */
	protected String lpdstatus_q;
	
	/** ���ܽ�� */
	protected BigDecimal money;
	
	/** Ԥ֧����ID */
	protected Integer acid;

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
	 * ���ɾ������ȡ��
	 * @return ���ɾ������
	 */
	public String[] getDeleteLpdid() {
		return deleteLpdid;
	}

	/**
	 * ���ɾ�������趨
	 * @param deleteLpdid ���ɾ������
	 */
	public void setDeleteLpdid(String[] deleteLpdid) {
		this.deleteLpdid = deleteLpdid;
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
	 * ���ܽ��ȡ��
	 * @return ���ܽ��
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * ���ܽ���趨
	 * @param money ���ܽ��
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	/**
	 * Ԥ֧����IDȡ��
	 * @return Ԥ֧����ID
	 */
	public Integer getAcid() {
		return acid;
	}

	/**
	 * Ԥ֧����ID�趨
	 * @param acid Ԥ֧����ID
	 */
	public void setAcid(Integer acid) {
		this.acid = acid;
	}

	public Integer getRid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getLdid_invoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSpType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTime_to() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
