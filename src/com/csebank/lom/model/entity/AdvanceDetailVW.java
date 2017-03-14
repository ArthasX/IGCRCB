/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.IdClass;

import com.csebank.lom.model.AdvanceDetail;

/**
 * 
 * Ԥ֧��ϸͳ��ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(AdvanceDetailVWPK.class)
public class AdvanceDetailVW implements Serializable, Cloneable, AdvanceDetail {
	
	/** ID */
	@Id
	protected String id;
	
	/** �������� */
	protected String date;
	
	/** ����ʱ�� */
	protected String time;
	
	/** �������� */
	@Id
	protected String type;
	
	/** ��Ա */
	protected String username;
	
	/** ��� */
	protected BigDecimal amount;
	
	/** ��Ʊ��� */
	protected BigDecimal invoiceamount;
	
	/** ����� */
	protected BigDecimal stockamount;
	
	/** ״̬ */
	protected String status;
	
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
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * ����ʱ���趨
	 * @param time ����ʱ��
	 */
	public void setTime(String time) {
		this.time = time;
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
	 * ��Աȡ��
	 * @return ��Ա
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ��Ա�趨
	 * @param username ��Ա
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getStockamount() {
		return stockamount;
	}

	/**
	 * ������趨
	 * @param stockamount �����
	 */
	public void setStockamount(BigDecimal stockamount) {
		this.stockamount = stockamount;
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
	
}
