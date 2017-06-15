/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.RecptionVWInfo;

/**
 * 
 * �Ӵ�ͳ��ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionVW implements Serializable, Cloneable, RecptionVWInfo {

	
	/** �Ӵ��������� */
	protected Integer rnum;
	
	/** �·� */
	@Id
	protected String month;
	
	/** �����ܶ� */
	protected BigDecimal amount;

	/**
	 * �Ӵ���������ȡ��
	 * @return �Ӵ���������ȡ��
	 */
	public Integer getRnum() {
		return rnum;
	}

	/**
	 * �Ӵ���������ȡ���趨
	 * @param rnum �Ӵ���������ȡ��
	 */
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}

	/**
	 * �·�ȡ��
	 * @return �·�
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * �·��趨
	 * @param month �·�
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * �����ܶ�ȡ��
	 * @return �����ܶ�
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * �����ܶ��趨
	 * @param amount �����ܶ�
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
