/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * ��Ʊ����VO
 *
 */
public class IGLOM04021VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**��Ʊ����ͳ����ϢList*/
	protected List<InvoiceTj> invoiceVWList;

	/**
	 * ���캯��
	 * @param invoiceVWList List<ChangeKpi>
	 * 
	 */
	
	public IGLOM04021VO(List<InvoiceTj> invoiceVWList) {
		this.invoiceVWList = invoiceVWList;
	}

	/**
	 * ��ȡ��Ʊ����ͳ����ϢLis
	 * @return ��Ʊ����ͳ����ϢLis
	 */
	public List<InvoiceTj> getInvoiceVWList() {
		return invoiceVWList;
	}
	
	/**
	 * ��Ʊ����������
	 */
	protected List<Invoice> invoiceList;

	/**
	 * ��Ʊ����������ȡ��
	 * @return ��Ʊ����������
	 */
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	/**
	 * ��Ʊ����������
	 * @param recptionList ��Ʊ����������
	 */
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

}
