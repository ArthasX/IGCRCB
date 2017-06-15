/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.PersonLoanSummary;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * Ԥ֧��Աͳ��ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class PersonLoanSummaryVW implements Serializable, Cloneable, PersonLoanSummary {
	
	/** ����� */
	@Id
	protected String lpduser;
	
	/** ����� */
	protected BigDecimal loanamount;
	
	/** ��Ʊ��� */
	protected BigDecimal invoiceamount;
	
	/** �����ֽ� */
	protected BigDecimal payamount;
	
	/** ����˻�������� */
	protected String lpduserorg;
	
	/** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="lpduserorg", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	public OrganizationTB organizationTB;
	
	/**
	 * �����ȡ��
	 * @return �����
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * ������趨
	 * @param lpduser �����
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getLoanamount() {
		return loanamount;
	}

	/**
	 * ������趨
	 * @param loanamount �����
	 */
	public void setLoanamount(BigDecimal loanamount) {
		this.loanamount = loanamount;
	}

	/**
	 * ��Ʊ���ȡ��
	 * @return ��Ʊ���
	 */
	public BigDecimal getInvoiceamount() {
		return invoiceamount;
	}

	/**
	 * ��Ʊ����趨
	 * @param invoiceamount ��Ʊ���ID
	 */
	public void setInvoiceamount(BigDecimal invoiceamount) {
		this.invoiceamount = invoiceamount;
	}

	/**
	 * �����ֽ�ȡ��
	 * @return �����ֽ�
	 */
	public BigDecimal getPayamount() {
		return payamount;
	}

	/**
	 * �����ֽ��趨
	 * @param payamount �����ֽ�
	 */
	public void setPayamount(BigDecimal payamount) {
		this.payamount = payamount;
	}

	public String getLpduserorg() {
		return lpduserorg;
	}

	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

}
