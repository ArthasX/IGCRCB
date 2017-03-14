/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.EEOrg;


/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ���д����Ż���ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class EEOrgVW implements Serializable, Cloneable, EEOrg {
	
	/** �Ӵ����� */
	protected Integer rnum;
	
	/** �����ܶ� */
	protected BigDecimal amount;
	
	/** ��Ҫ���벿�Ų���� */
	@Id
	protected String rapporgid;

	/** ���� */
	public String rapporgname;
	
	

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

	public String getRapporgname() {
		return rapporgname;
	}

	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}


//	public String getRapporgname() {
//		return rapporgname;
//	}
//
//	public void setRapporgname(String rapporgname) {
//		this.rapporgname = rapporgname;
//	}






}
