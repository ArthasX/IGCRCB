

/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
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

import com.csebank.lom.model.Invoice;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 * ֧Ʊ����ʵ��
 * @author piaow@deliverik.com
 * 
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="Invoice")
public class InvoiceTB extends BaseEntity implements Serializable, Cloneable, Invoice {

	@Id
	@TableGenerator(
		    name="INVOICE_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="INVOICE_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="INVOICE_TABLE_GENERATOR")
	
	protected Integer iid;

	/** ��Ʊ���� */
	protected String itype;
	
	/** ��Ʊ���� */
	protected String idate;
	
	/** ��Ʊ���� */
	protected String inum;
	
	/** ���*/
	protected BigDecimal iamount;

	/** ��;˵������ */
	protected String icomment;
	
	/** ��ͬ��� */
	protected String icontractserial;
	
	/** ��ͬ���� */
	protected String icontractname;
	
	/** �տλ���� */
	protected String icorporation;
	
	/** �������� */
	protected String ibank;
	
	/** �˺� */
	protected String iaccount;
	
	/** ���벿�Ų���� */
	protected String ireqemp;
	
	/** ������id */
	protected String irequser;
	
	/** ���������� */
	protected String irequsername;
	
	/** ״̬(0: δ���� 1:�Ѹ���) */
	protected String istatus;
	
	/** ���ʽ */
	protected String ipaymenttype;
	
	/** ���ʽ���� */
	protected String ipaymenttypecode;
	
	
	/** �������� */
	protected String ipaymentdate;
	
	
	  /** ������Ϣʵ�� */
	@OneToOne
	@JoinColumn(name="ireqemp", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return iid;
	}
	
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getInum() {
		return inum;
	}

	public void setInum(String inum) {
		this.inum = inum;
	}

	public BigDecimal getIamount() {
		return iamount;
	}

	public void setIamount(BigDecimal iamount) {
		this.iamount = iamount;
	}

	public String getIcomment() {
		return icomment;
	}

	public void setIcomment(String icomment) {
		this.icomment = icomment;
	}

	public String getIcontractserial() {
		return icontractserial;
	}

	public void setIcontractserial(String icontractserial) {
		this.icontractserial = icontractserial;
	}

	public String getIcontractname() {
		return icontractname;
	}

	public void setIcontractname(String icontractname) {
		this.icontractname = icontractname;
	}

	public String getIcorporation() {
		return icorporation;
	}

	public void setIcorporation(String icorporation) {
		this.icorporation = icorporation;
	}

	public String getIbank() {
		return ibank;
	}

	public void setIbank(String ibank) {
		this.ibank = ibank;
	}

	public String getIaccount() {
		return iaccount;
	}

	public void setIaccount(String iaccount) {
		this.iaccount = iaccount;
	}

	public String getIreqemp() {
		return ireqemp;
	}

	public void setIreqemp(String ireqemp) {
		this.ireqemp = ireqemp;
	}

	public String getIrequser() {
		return irequser;
	}

	public void setIrequser(String irequser) {
		this.irequser = irequser;
	}

	public String getIrequsername() {
		return irequsername;
	}

	public void setIrequsername(String irequsername) {
		this.irequsername = irequsername;
	}

	public String getIstatus() {
		return istatus;
	}

	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}

	public String getIpaymenttype() {
		return ipaymenttype;
	}

	public void setIpaymenttype(String ipaymenttype) {
		this.ipaymenttype = ipaymenttype;
	}

	public String getIpaymenttypecode() {
		return ipaymenttypecode;
	}

	public void setIpaymenttypecode(String ipaymenttypecode) {
		this.ipaymenttypecode = ipaymenttypecode;
	}

	public String getIpaymentdate() {
		return ipaymentdate;
	}

	public void setIpaymentdate(String ipaymentdate) {
		this.ipaymentdate = ipaymentdate;
	}

	

	
	

	
	
	
	

}
