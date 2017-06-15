/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.RecptionOrg;

/**
 * 
 * ���ŽӴ�ͳ�ƽӿ�ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionOrgVW implements Serializable, Cloneable, RecptionOrg {
	
	/** �Ӵ����� */
	protected Integer rnum;
	
	/** �����ܶ� */
	protected BigDecimal amount;
	
	/** ��Ҫ���벿�Ų���� */
	@Id
	protected String rapporgid;

	/** ���� */
	protected String rapporgname;
	
	/** �������� */
	protected Integer disnum;
	
	/** δ�������� */
	protected Integer ennum;

	/**
	 * �Ӵ�����ȡ��
	 * @return �Ӵ�����
	 */
	public Integer getRnum() {
		return rnum;
	}

	/**
	 * �Ӵ������趨
	 * @param rnum �Ӵ�����
	 */
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
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

	/**
	 * ��Ҫ���벿�Ų����ȡ��
	 * @return ��Ҫ���벿�Ų����
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * ��Ҫ���벿�Ų�����趨
	 * @param rapporgid ��Ҫ���벿�Ų����
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getRapporgname() {
		return rapporgname;
	}

	/**
	 * �����趨
	 * @param rapporgidname �趨
	 */
	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	/**
	 * ��������ȡ��
	 * @return ��������
	 */
	public Integer getDisnum() {
		return disnum;
	}

	/**
	 * ���������趨
	 * @param disnum ��������
	 */
	public void setDisnum(Integer disnum) {
		this.disnum = disnum;
	}

	/**
	 * δ��������ȡ��
	 * @return δ��������
	 */
	public Integer getEnnum() {
		return ennum;
	}

	/**
	 * δ���������趨
	 * @param ennum δ��������
	 */
	public void setEnnum(Integer ennum) {
		this.ennum = ennum;
	}




}
