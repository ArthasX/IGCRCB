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

import com.csebank.lom.model.RecptionCost;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * �Ӵ�����ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionCostVW  implements Serializable, Cloneable, RecptionCost {
	
	/** �Ӵ�����ID */
	@Id
	protected Integer rid;
	
	/** �Ӵ��������� */
	protected String rname;
	
	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid;
	
	/** �Ӵ��������� */
	protected String retime;
	
	/** �Ӵ���ʼ���� */
	protected String rstime;
	
	
	/** �Ǽ����� */
	protected String rdate;
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	
	
	/** ��Ʒ����ͳ�� */
	protected BigDecimal stockSum;
	
	/** ���ͳ�� */
	protected BigDecimal loanSum;
	
	/** ʳ�÷���ͳ�� */
	protected BigDecimal entertainmentSum;
	
	/** ���úϼ� */
	protected BigDecimal cost;
	
	public BigDecimal getCost() {
		return cost.add(stockSum).add(loanSum).add(entertainmentSum);
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="rapporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	public BigDecimal getStockSum() {
		return stockSum;
	}

	public void setStockSum(BigDecimal stockSum) {
		this.stockSum = stockSum;
	}

	public BigDecimal getLoanSum() {
		return loanSum;
	}

	public void setLoanSum(BigDecimal loanSum) {
		this.loanSum = loanSum;
	}

	public BigDecimal getEntertainmentSum() {
		return entertainmentSum;
	}

	public void setEntertainmentSum(BigDecimal entertainmentSum) {
		this.entertainmentSum = entertainmentSum;
	}



	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rid;
	}
	
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

	/**
	 * ��Ҫ���벿�Ų����
	 * @return ��Ҫ���벿�Ų����
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * ��Ҫ���벿�Ų����
	 * @param rapporgid ��Ҫ���벿�Ų����
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	

	/**
	 * �Ǽ�����
	 * @return �Ǽ�����
	 */
	public String getRdate() {
		return rdate;
	}

	/**
	 * �Ǽ�����
	 * @param rdate �Ǽ�����
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
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
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
}
