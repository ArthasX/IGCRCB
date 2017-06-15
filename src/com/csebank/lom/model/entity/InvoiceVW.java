/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.InvoiceTj;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��Ʊͳ��
 * </p>
 * 
 * @author piaowei@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class InvoiceVW implements Serializable, Cloneable, InvoiceTj {
    
	/**ͳ�����  */
	@Id
	protected String num;
	
	/**ͳ�Ʒ�Ʊ����  */
	protected Integer invoicenum;
	
	/**ͳ���ܽ��  */
	protected BigDecimal sumiamount;
	
	/**ͳ���Ѹ�����  */
	protected BigDecimal sumiamounted;
	
	/**ͳ��δ������ */
	protected BigDecimal unsumiamounted;
	
	/**ͳ�Ʋ��� */
	protected String ireqemp;
	
	/** �ʲ�����������*/
	public String eiorgsyscoding;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getInvoicenum() {
		return invoicenum;
	}

	public void setInvoicenum(Integer invoicenum) {
		this.invoicenum = invoicenum;
	}

	public BigDecimal getSumiamount() {
		return sumiamount;
	}

	public void setSumiamount(BigDecimal sumiamount) {
		this.sumiamount = sumiamount;
	}

	public BigDecimal getSumiamounted() {
		return sumiamounted;
	}

	public void setSumiamounted(BigDecimal sumiamounted) {
		this.sumiamounted = sumiamounted;
	}

	public BigDecimal getUnsumiamounted() {
		return unsumiamounted;
	}

	public void setUnsumiamounted(BigDecimal unsumiamounted) {
		this.unsumiamounted = unsumiamounted;
	}

	

	public String getIreqemp() {
		return ireqemp;
	}

	public void setIreqemp(String ireqemp) {
		this.ireqemp = ireqemp;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	
}
