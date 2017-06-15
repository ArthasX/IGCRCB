/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.csebank.lom.model.AdvanceSummary;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * Ԥ֧����ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="AdvanceSummary")
@IdClass(AdvanceSummaryTBPK.class)
public class AdvanceSummaryTB extends BaseEntity implements Serializable, Cloneable, AdvanceSummary {
	
	/** ���ȡ�� */
	@Id
	protected String asyear;

	/** �·�ȡ�� */
	@Id
	protected String asmonth;

	/** �������ȡ�� */
	protected BigDecimal asprebalance;

	/** ����Ԥ֧���ȡ�� */
	protected BigDecimal asadvancescost;

	/** �����ȡ�� */
	protected BigDecimal asloan;

	/** ���·�Ʊ���ȡ�� */
	protected BigDecimal asinvoice;

	/** ���»�����ȡ�� */
	protected BigDecimal aspay;

	/** �������ȡ�� */
	protected BigDecimal asbalance;

	/** ������ȡ�� */
	protected BigDecimal asfreeze;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return new AdvanceSummaryTBPK(asyear, asmonth);
	}
	
	/**
	 * ���ȡ��
	 * @return ���
	 */
	public String getAsyear() {
		return asyear;
	}
	
	/**
	 * ����趨
	 * @return asyear ���
	 */
	public void setAsyear(String asyear) {
		this.asyear = asyear;
	}

	/**
	 * �·�ȡ��
	 * @return �·�
	 */
	public String getAsmonth() {
		return asmonth;
	}
	
	/**
	 * �·��趨
	 * @return asmonth �·�
	 */
	public void setAsmonth(String asmonth) {
		this.asmonth = asmonth;
	}
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public BigDecimal getAsprebalance() {
		return asprebalance;
	}
	
	/**
	 * ��������趨
	 * @return asprebalance �������
	 */
	public void setAsprebalance(BigDecimal asprebalance) {
		this.asprebalance = asprebalance;
	}
	
	/**
	 * ����Ԥ֧���ȡ��
	 * @return ����Ԥ֧���
	 */
	public BigDecimal getAsadvancescost() {
		return asadvancescost;
	}
	
	/**
	 * ����Ԥ֧����趨
	 * @return asadvancescost ����Ԥ֧���
	 */
	public void setAsadvancescost(BigDecimal asadvancescost) {
		this.asadvancescost = asadvancescost;
	}
	
	/**
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getAsloan() {
		return asloan;
	}
	
	/**
	 * ������趨
	 * @return asloan �����
	 */
	public void setAsloan(BigDecimal asloan) {
		this.asloan = asloan;
	}
	
	/**
	 * ���·�Ʊ���ȡ��
	 * @return ���·�Ʊ���
	 */
	public BigDecimal getAsinvoice() {
		return asinvoice;
	}
	
	/**
	 * ���·�Ʊ����趨
	 * @return asinvoice ���·�Ʊ���
	 */
	public void setAsinvoice(BigDecimal asinvoice) {
		this.asinvoice = asinvoice;
	}
	
	/**
	 * ���»�����ȡ��
	 * @return ���»�����
	 */
	public BigDecimal getAspay() {
		return aspay;
	}
	
	/**
	 * ���»������趨
	 * @return aspay ���»�����
	 */
	public void setAspay(BigDecimal aspay) {
		this.aspay = aspay;
	}
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public BigDecimal getAsbalance() {
		return asbalance;
	}
	
	/**
	 * ��������趨
	 * @return asbalance �������
	 */
	public void setAsbalance(BigDecimal asbalance) {
		this.asbalance = asbalance;
	}
	
	/**
	 * ������ȡ��
	 * @return ������
	 */
	public BigDecimal getAsfreeze() {
		return asfreeze;
	}
	
	/**
	 * �������趨
	 * @return asfreeze ������
	 */
	public void setAsfreeze(BigDecimal asfreeze) {
		this.asfreeze = asfreeze;
	}

}
