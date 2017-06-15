/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ʊͳ��Form
 * </p>
 * 
 * @author piaowei@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGLOM0405Form extends BaseForm implements InvoiceInfoSearchCond{

	/** ��Ʊ���� */
	protected String itype;
	
	/** ��Ʊ��ʼ���� */
	protected String idate_from;
	
	/** ��Ʊ�������� */
	protected String idate_to;
	
	/** ���벿�Ų���� */
	protected String ireqemp;
	
	/** ������id */
	protected String irequser;
	
	/** ���*/
	protected String iamount;
	
	/** ״̬(0: δ���� 1:�Ѹ���) */
	protected String istatus;
	
	/**�����Ų�ѯ  */
	protected String searchbyemp;
	
	/**ͳ�����  */
	protected String num;
	
	/**ͳ�Ʒ�Ʊ����  */
	protected String invoicenum;
	
	/**ͳ���ܽ��  */
	protected String sumiamount;
	
	/**ͳ���Ѹ�����  */
	protected String sumiamounted;
	
	/**ͳ��δ������ */
	protected String unsumiamounted;
	
	/**ͳ�ư���ͳ�� */
	protected String iyear; 
	
	/** �ʲ���������������*/
    protected String eiorgname;

    /** �ʲ�����������*/
	public String eiorgsyscoding;
	
	public String getIyear() {
		return iyear;
	}

	public void setIyear(String iyear) {
		this.iyear = iyear;
	}

	public String getSearchbyemp() {
		return searchbyemp;
	}

	public void setSearchbyemp(String searchbyemp) {
		this.searchbyemp = searchbyemp;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getInvoicenum() {
		return invoicenum;
	}

	public void setInvoicenum(String invoicenum) {
		this.invoicenum = invoicenum;
	}

	public String getSumiamount() {
		return sumiamount;
	}

	public void setSumiamount(String sumiamount) {
		this.sumiamount = sumiamount;
	}

	public String getSumiamounted() {
		return sumiamounted;
	}

	public void setSumiamounted(String sumiamounted) {
		this.sumiamounted = sumiamounted;
	}

	public String getUnsumiamounted() {
		return unsumiamounted;
	}

	public void setUnsumiamounted(String unsumiamounted) {
		this.unsumiamounted = unsumiamounted;
	}

	public String getSearchByEmp() {
		return searchbyemp;
	}
	
	public void setSearchByEmp(String searchbyemp) {
		this.searchbyemp = searchbyemp;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
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

	public String getIreqempid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIrequsername() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
}
