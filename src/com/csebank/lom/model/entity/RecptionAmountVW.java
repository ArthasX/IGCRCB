/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.RecptionAmount;

/**
 * 
 * �Ӵ�����ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionAmountVW implements Serializable, Cloneable,  RecptionAmount {
	
	/** �Ӵ�����ID */
	@Id
	protected Integer rid;
	
	/** �Ӵ��������� */
	protected String rname;
	
	/** �Ӵ�������ģ */
	protected String rscale;
	
	/** �Ӵ���׼ */
	protected String rstandard;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	
	/** �����ܶ� */
	protected BigDecimal amount;
	
	/** ������� */
	protected String rapporgname;
	
	protected String orgsyscoding;
	
	/** �Ӵ��������� */
	protected String retime;
	
	/** �Ӵ���ʼ���� */
	protected String rstime;
	

	
	/**
	 * �Ӵ�����ID
	 * @return �Ӵ�����ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * �Ӵ�����ID
	 * @param rid �Ӵ�����ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * �Ӵ���������
	 * @return �Ӵ���������
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * �Ӵ���������
	 * @param rname �Ӵ���������
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * �Ӵ�������ģ
	 * @return �Ӵ�������ģ
	 */
	public String getRscale() {
		return rscale;
	}

	/**
	 * �Ӵ�������ģ
	 * @param rscale �Ӵ�������ģ
	 */
	public void setRscale(String rscale) {
		this.rscale = rscale;
	}

	/**
	 * �Ӵ���׼
	 * @return �Ӵ���׼
	 */
	public String getRstandard() {
		return rstandard;
	}

	/**
	 * �Ӵ���׼
	 * @param rstandard�Ӵ���׼
	 */
	public void setRstandard(String rstandard) {
		this.rstandard = rstandard;
	}

	/**
	 * ״̬
	 * @return ״̬
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * ״̬
	 * @param rstatus ״̬
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}


	/**
	 * �����ܶ�
	 * @return �����ܶ�
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * �����ܶ�
	 * @param amount �����ܶ�
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRapporgname() {
		return rapporgname;
	}

	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * �Ӵ��������� 
	 * @return �Ӵ��������� 
	 */
	public String getRetime() {
		return retime;
	}

	/**
	 * �Ӵ��������� 
	 * @param retime �Ӵ��������� 
	 */
	public void setRetime(String retime) {
		this.retime = retime;
	}

	/**
	 * �Ӵ���ʼ���� 
	 * @return �Ӵ���ʼ���� 
	 */
	public String getRstime() {
		return rstime;
	}

	/**
	 * �Ӵ���ʼ����
	 * @param rstime �Ӵ���ʼ����
	 */
	public void setRstime(String rstime) {
		this.rstime = rstime;
	}


}
