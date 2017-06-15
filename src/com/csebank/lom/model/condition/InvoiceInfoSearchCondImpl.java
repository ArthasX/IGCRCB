package com.csebank.lom.model.condition;

public class InvoiceInfoSearchCondImpl implements InvoiceInfoSearchCond {

	/**
	 * ��Ʊ����
	 */
	protected String itype;
	
	/**
	 * ���벿�Ų����
	 */
	protected String ireqemp;
	
	/**
	 * ������ID
	 */
	protected String irequser;
	
	/**
	 * ��Ʊ��ʼʱ��
	 */
	protected String idate_from;
	
	/**
	 * ��Ʊ����ʱ��
	 */
	protected String idate_to;
	
	/**
	 * ���
	 */
	protected String iamount;
	
	/**
	 * ״̬
	 */
	protected String istatus;
	
	/**
	 * ����ͳ�� 
	 */
	protected String iyear;

	/**
	 * ������ID
	 */
    protected String ireqempid;
	
	/** 
	 * ����������
	 */
	protected String irequsername;
	
	/** �ʲ�����������*/
	public String eiorgsyscoding;
	
	public String getIreqempid() {
		return ireqempid;
	}

	public void setIreqempid(String ireqempid) {
		this.ireqempid = ireqempid;
	}
	
	public String getIyear() {
		return iyear;
	}
	
	public void setIyear(String iyear) {
		this.iyear = iyear;
	}

	public String getItype() {
		return itype;
	}

	public void setItpye(String itype) {
		this.itype = itype;
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

	public String getIamount() {
		return iamount;
	}

	public void setIamount(String iamount) {
		this.iamount = iamount;
	}

	public String getIstatus() {
		return istatus;
	}

	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}

	public String getIrequsername() {
		return irequsername;
	}

	public void setIrequsername(String irequsername) {
		this.irequsername = irequsername;
	}


	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

}
