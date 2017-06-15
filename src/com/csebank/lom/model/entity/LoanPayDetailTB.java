/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * Ԥ֧����ʵ��
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="LoanPayDetail")
public class LoanPayDetailTB extends BaseEntity implements Serializable, Cloneable, LoanPayDetail {
	
	/** �軹����ϸID */
	@Id
	@TableGenerator(
		    name="LOANPAYDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="LOANPAYDETAIL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="LOANPAYDETAIL_TABLE_GENERATOR")
	protected Integer lpdid;
		
	/** �軹������ */
	protected String lpdtype;
	
	/** �軹���� */
	protected String lpduser;
	
	/** �軹������ */
	protected String lpddate;
	
	/** �軹���� */
	protected BigDecimal lpdamount;
	
	/** ��; */
	protected String lpdcomment;
	
	/** ״̬ */
	protected String lpdstatus;
	
	/** ������ID */
	protected String lpdpersion;
	
	/** ���������� */
	protected String lpdpersionname;
	
	/** ��Ʊ���� */
	protected String lpdinvoicedate;
	
	/** ��Ʊ�� */
	protected String lpdinvoicenum;
	
	/** ��Ʊǩ����λ */
	protected String lpdinvoicecor;
	
	/** ��Ʊ��� */
	protected BigDecimal lpdinvoiceamount;
	
	/** ʵ����;˵�� */
	protected String lpdinvoicecomment;
	
	/** ���ID */
	protected Integer ldid;
	
	/** �Ӵ�����ID */
	protected Integer rid;
	
	/** Ԥ֧����ID */
	protected Integer acid;
	
	/** ����� */
	protected BigDecimal lpdstockamount;
	
	/** ����˻�������� */
	protected String lpduserorg;
	
	/** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="lpduserorg", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	public OrganizationTB organizationTB;
	
	/** ʵ�ʷ�Ʊ��� */
	public BigDecimal lpdactinvoice;
	
	/** ʵ�ʻ����� */
	public String lpdactuser;
	
	/** �軹��ʱ�� */
	public String lpdtime;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return lpdid;
	}
	
	/**
	 * �軹����ϸIDȡ��
	 * @return Ԥ֧�Ǽ�ʱ��
	 */
	public Integer getLpdid() {
		return lpdid;
	}
	
	/**
	 * �軹����ϸID�趨
	 * @param lpdid �軹����ϸID
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
	}

	/**
	 * �軹������ȡ��
	 * @return �軹������
	 */
	public String getLpdtype() {
		return lpdtype;
	}

	/**
	 * �軹�������趨
	 * @param lpdtype �軹������
	 */
	public void setLpdtype(String lpdtype) {
		this.lpdtype = lpdtype;
	}

	/**
	 * �軹����ȡ��
	 * @return �軹����
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * �軹�����趨
	 * @param lpduser �軹����
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * �軹������ȡ��
	 * @return �軹������
	 */
	public String getLpddate() {
		return lpddate;
	}

	/**
	 * �軹�������趨
	 * @param lpddate �軹������
	 */
	public void setLpddate(String lpddate) {
		this.lpddate = lpddate;
	}

	/**
	 * �軹����ȡ��
	 * @return �軹����
	 */
	public BigDecimal getLpdamount() {
		return lpdamount;
	}

	/**
	 * �軹�����趨
	 * @param lpdamount �軹����
	 */
	public void setLpdamount(BigDecimal lpdamount) {
		this.lpdamount = lpdamount;
	}

	/**
	 * ��;ȡ��
	 * @return ��;
	 */
	public String getLpdcomment() {
		return lpdcomment;
	}

	/**
	 * ��;�趨
	 * @param lpdcomment ��;
	 */
	public void setLpdcomment(String lpdcomment) {
		this.lpdcomment = lpdcomment;
	}

	/**
	 * ״̬ȡ��
	 * @return ״̬
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * ״̬�趨
	 * @param lpdstatus ״̬
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	/**
	 * ������IDȡ��
	 * @return ������ID
	 */
	public String getLpdpersion() {
		return lpdpersion;
	}

	/**
	 * ������ID�趨
	 * @param lpdpersion ������ID
	 */
	public void setLpdpersion(String lpdpersion) {
		this.lpdpersion = lpdpersion;
	}

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getLpdpersionname() {
		return lpdpersionname;
	}

	/**
	 * �����������趨
	 * @param lpdpersionname ����������
	 */
	public void setLpdpersionname(String lpdpersionname) {
		this.lpdpersionname = lpdpersionname;
	}

	/**
	 * ��Ʊ����ȡ��
	 * @return ��Ʊ����
	 */
	public String getLpdinvoicedate() {
		return lpdinvoicedate;
	}

	/**
	 * ��Ʊ�����趨
	 * @param lpdinvoicedate ��Ʊ����
	 */
	public void setLpdinvoicedate(String lpdinvoicedate) {
		this.lpdinvoicedate = lpdinvoicedate;
	}

	/**
	 * ��Ʊ��ȡ��
	 * @return ��Ʊ��
	 */
	public String getLpdinvoicenum() {
		return lpdinvoicenum;
	}

	/**
	 * ��Ʊ���趨
	 * @param lpdinvoicenum ��Ʊ��
	 */
	public void setLpdinvoicenum(String lpdinvoicenum) {
		this.lpdinvoicenum = lpdinvoicenum;
	}

	/**
	 * ��Ʊǩ����λȡ��
	 * @return ��Ʊǩ����λ
	 */
	public String getLpdinvoicecor() {
		return lpdinvoicecor;
	}

	/**
	 * ��Ʊǩ����λ�趨
	 * @param lpdinvoicecor ��Ʊǩ����λ
	 */
	public void setLpdinvoicecor(String lpdinvoicecor) {
		this.lpdinvoicecor = lpdinvoicecor;
	}

	/**
	 * ��Ʊ���ȡ��
	 * @return ��Ʊ���
	 */
	public BigDecimal getLpdinvoiceamount() {
		return lpdinvoiceamount;
	}

	/**
	 * ��Ʊ����趨
	 * @param lpdinvoiceamount ��Ʊ���
	 */
	public void setLpdinvoiceamount(BigDecimal lpdinvoiceamount) {
		this.lpdinvoiceamount = lpdinvoiceamount;
	}

	/**
	 * ʵ����;˵��ȡ��
	 * @return ʵ����;˵��
	 */
	public String getLpdinvoicecomment() {
		return lpdinvoicecomment;
	}

	/**
	 * ʵ����;˵���趨
	 * @param lpdinvoicecomment ʵ����;˵��
	 */
	public void setLpdinvoicecomment(String lpdinvoicecomment) {
		this.lpdinvoicecomment = lpdinvoicecomment;
	}

	/**
	 * ���IDȡ��
	 * @return ���ID
	 */
	public Integer getLdid() {
		return ldid;
	}

	/**
	 * ���ID�趨
	 * @param ldid ���ID
	 */
	public void setLdid(Integer ldid) {
		this.ldid = ldid;
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
	 * Ԥ֧����IDȡ��
	 * @return Ԥ֧����ID
	 */
	public Integer getAcid() {
		return acid;
	}

	/**
	 * Ԥ֧����ID�趨
	 * @param acid Ԥ֧����ID
	 */
	public void setAcid(Integer acid) {
		this.acid = acid;
	}
	
	/**
	 * �����ȡ��
	 * @return �����
	 */
	public BigDecimal getLpdstockamount() {
		return lpdstockamount;
	}

	/**
	 * ������趨
	 * @param lpdstockamount �����
	 */
	public void setLpdstockamount(BigDecimal lpdstockamount) {
		this.lpdstockamount = lpdstockamount;
	}

	/**
	 * ����˻��������ȡ��
	 * @return ����˻��������
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * ����˻���������趨
	 * @param lpduserorg ����˻��������
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * �����趨
	 * @param organizationTB ����
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

	/**
	 * ʵ�ʷ�Ʊ���ȡ��
	 * @return ʵ�ʷ�Ʊ���
	 */
	public BigDecimal getLpdactinvoice() {
		return lpdactinvoice;
	}

	/**
	 * ʵ�ʷ�Ʊ����趨
	 * @param lpdactinvoice ʵ�ʷ�Ʊ���
	 */
	public void setLpdactinvoice(BigDecimal lpdactinvoice) {
		this.lpdactinvoice = lpdactinvoice;
	}

	/**
	 * ʵ�ʻ�����ȡ��
	 * @return ʵ�ʻ�����
	 */
	public String getLpdactuser() {
		return lpdactuser;
	}

	/**
	 * ʵ�ʻ������趨
	 * @param lpdactuser ʵ�ʻ�����
	 */
	public void setLpdactuser(String lpdactuser) {
		this.lpdactuser = lpdactuser;
	}

	/**
	 * �軹��ʱ��ȡ��
	 * @return �軹��ʱ��
	 */
	public String getLpdtime() {
		return lpdtime;
	}

	/**
	 * �軹��ʱ���趨
	 * @param lpdtime �軹��ʱ��
	 */
	public void setLpdtime(String lpdtime) {
		this.lpdtime = lpdtime;
	}
	
}
