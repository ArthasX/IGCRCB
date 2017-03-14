/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * ����form
 *
 */
public class IGLOM0306Form extends BaseForm implements LoanPayDetailSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** ����� */
	protected String lpduser_q;
	
	/** ���ɾ������ */
	protected String[] deleteLpdid;
	
	/** �軹������ 0:��� */
	protected String lpdtype_q;
	
	/** ���ID */
	protected Integer lpdid;
	
	/** ���״̬ */
	protected String lpdstatus;
	
	/** ���״̬ */
	protected String lpdstatus_q = "0";
	
	/** ���ID */
	protected String ldid_invoice;
	
	protected String time_from;
	protected String time_to;
	protected String spType;

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
	 * �軹������ 0:����趨
	 * @param lpdtype_q �軹������ 0:���
	 */
	public void setLpdtype_q(String lpdtype_q) {
		this.lpdtype_q = lpdtype_q;
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

	/**
	 * ���״̬ȡ��
	 * @return ���״̬
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * ���״̬�趨
	 * @param lpdstatus ���״̬
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	public String getLpdstatus_q() {
		return lpdstatus_q;
	}

	public void setLpdstatus_q(String lpdstatus_q) {
		this.lpdstatus_q = lpdstatus_q;
	}

	public String getLpdtype_q() {
		return lpdtype_q;
	}

	public String getLpdinvoiceamount_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicedate_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicedate_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getLdid_invoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLdid_invoice(String ldid_invoice) {
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
