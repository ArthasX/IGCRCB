/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Invoice;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;


/**
 * 
 * ֧Ʊ�ǼǱ��Form
 *
 */
public class IGLOM0401Form extends BaseForm implements Invoice{


	private static final long serialVersionUID = 1L;

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
	
	/** ��¼�汾��ʶ */
	protected String fingerprint;
	
	/** �Ǽ����� */
	protected String rdate;  
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected String mode="0";
	
	/** ��Ʊ��ʼ���� */
	protected String idate_from;
	
	/** ��Ʊ�������� */
	protected String idate_to;
	
	/**  */
	protected String ireqempid;
	
	protected OrganizationTB organizationTB;


	public String getIreqempid() {
		return ireqempid;
	}

	public void setIreqempid(String ireqempid) {
		this.ireqempid = ireqempid;
	}

	public String getIdate_from() {
		return idate_from;
	}

	public void setIdate_from(String idate_from) {
		this.idate_from = idate_from;
	}

	public String getIdate_to() {
		return idate_to;
	}

	public void setIdate_to(String idate_to) {
		this.idate_to = idate_to;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
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

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * ҳ�������ʾȡ��
	 * @return ҳ�������ʾ
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * ҳ�������ʾ�趨
	 * @param mode ҳ�������ʾ
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFingerPrint() {
		
		return fingerprint;
	}

	public OrganizationTB getOrganizationTB() {
		
		return organizationTB;
	}


	
}
