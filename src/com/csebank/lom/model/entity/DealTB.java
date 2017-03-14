/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.csebank.lom.model.Deal;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * ģ�飺���ڹ��� -�Ӵ�����-����Ͳ͹���ʵ��TB��
 * ˵��������Ͳ͹���entity
 * ���ߣ�������
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="DEAL")
public class DealTB extends BaseEntity implements Serializable, Cloneable, Deal {
	
	/** 
	 * 
	 * ����Ͳ͹���ID
	 * ����hibernateʵ���Ӧ
	 * 
	 * */
	@Id
	@TableGenerator(
		    name="DEAL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="DEAL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DEAL_TABLE_GENERATOR")
	protected Integer rid;
	
	/** ���벿������ */
	protected String deptName;
	
	

	/** ��Ҫ���벿�Ų���� */
	protected String rapporgid;
	
	
	/** ����ʱ��  */
	protected String dealTime;
	
	

	/** ����������ģ  */
	protected String dealScale;
	
	

	/** ������  */
	protected BigDecimal dealCash;
	
	/** ��Ʊ��� */
	protected String invoiceNumber;
	
	/** ����������  */
	protected String otherJoiner;
	
	/** ������������  */
	protected String dealDesc;
	
	
	
	/** ״̬��1�����У�2������ */
	protected String rstatus;
	
	  /** ������Ϣʵ�� */
	@Transient
	protected OrganizationTB organizationTB;

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
	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getRapporgid() {
		return rapporgid;
	}

	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}
	public String getDealTime() {
		return dealTime;
	}

	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	public String getDealScale() {
		return dealScale;
	}

	public void setDealScale(String dealScale) {
		this.dealScale = dealScale;
	}

	public String getInvoiceNumber() {
		return invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public String getOtherJoiner() {
		return otherJoiner;
	}

	public void setOtherJoiner(String otherJoiner) {
		this.otherJoiner = otherJoiner;
	}

	public String getDealDesc() {
		return dealDesc;
	}

	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}

	public OrganizationTB getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * dealCashȡ��
	 *
	 * @return dealCash dealCash
	 */
	public BigDecimal getDealCash() {
		return dealCash;
	}

	/**
	 * dealCash�趨
	 *
	 * @param dealCash dealCash
	 */
	public void setDealCash(BigDecimal dealCash) {
		this.dealCash = dealCash;
	}
	
}
