/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.PersonLoanDetail;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * ��Ա�����ϸͳ��ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(PersonLoanDetailVWPK.class)
public class PersonLoanDetailVW implements Serializable, Cloneable, PersonLoanDetail {
	
	/** ID */
	@Id
	protected String id;
	
	/** �������� */
	protected String date;
	
	/** �������� */
	@Id
	protected String type;
	
	/** ��� */
	protected BigDecimal amount;
	
	/** ��Ʊ��� */
	protected BigDecimal invoiceamount;
	
	/** ��; */
	protected String comment;
	
	/** ״̬ */
	protected String status;
	
	/** ״̬ */
	protected String lpduserorg;
	  /** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="lpduserorg", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getDate() {
		return date;
	}

	/**
	 * ���������趨
	 * @param date ��������
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public String getType() {
		return type;
	}

	/**
	 * ���������趨
	 * @param type ��������
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * ���ȡ��
	 * @return ���
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * ����趨
	 * @param amount ���
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	 * @param invoiceamount ��Ʊ���
	 */
	public void setInvoiceamount(BigDecimal invoiceamount) {
		this.invoiceamount = invoiceamount;
	}

	/**
	 * ��;ȡ��
	 * @return ��;
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * ��;�趨
	 * @param comment ��;
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * ״̬�趨
	 * @param status ״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * IDȡ��
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID�趨
	 * @param id ID
	 */
	public void setId(String id) {
		this.id = id;
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
