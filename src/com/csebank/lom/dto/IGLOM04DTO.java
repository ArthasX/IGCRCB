/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.dto;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.form.IGLOM0401Form;
import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;

/**
 * 
 * ��Ʊ����DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM04DTO extends BaseDTO implements Serializable {
	

	/** ��Ʊ�����ѯ���� */
	protected InvoiceInfoSearchCond invoiceInfoSearchCond;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;

	/** ��Ʊ��Ϣ���������� */
	protected int maxSearchCount;
	
	/** ��Ʊ��ϢForm */
	protected IGLOM0401Form iglom0401Form;

	
	/** ��Ʊ��������� */
	protected List<Invoice> invoiceList;
	
	/** ��Ʊ��������� */
	protected List<InvoiceTj> invoiceVWList;
	
	
	public List<InvoiceTj> getInvoiceVWList() {
		return invoiceVWList;
	}

	public void setInvoiceVWList(List<InvoiceTj> invoiceVWList) {
		this.invoiceVWList = invoiceVWList;
	}

	/** ��Ʊ���� */
	protected Invoice invoice;
	
	/**
	 * ֪ͨɾ������
	 */
	
	protected String[] deleteNid;
	

	/**
	 * �Ӵ������ѯ����ȡ��
	 * @return
	 */
	public InvoiceInfoSearchCond getInvoiceInfoSearchCond() {
		return invoiceInfoSearchCond;
	}

	/**
	 * �Ӵ������ѯ�����趨
	 * @param recptionSearchCond �Ӵ������ѯ�����趨
	 */
	public void setInvoiceInfoSearchCond(InvoiceInfoSearchCond invoiceInfoSearchCond) {
		this.invoiceInfoSearchCond = invoiceInfoSearchCond;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ��Ʊ��Ϣ����������ȡ��
	 * @return ��Ʊ��Ϣ����������ȡ��
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * ��Ʊ��Ϣ�����������趨
	 * @param maxSearchCount ��Ʊ��Ϣ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��Ʊ��ϢFormȡ��
	 * @return ��Ʊ��ϢForm
	 */
	public IGLOM0401Form getIglom0401Form() {
		return iglom0401Form;
	}

	/**
	 * ��Ʊ��ϢForm�趨
	 * @param igLOM0401Form ��Ʊ��ϢForm
	 */
	public void setIglom0401Form(IGLOM0401Form iglom0401Form) {
		this.iglom0401Form = iglom0401Form;
	}
	
	/**
	 * ��Ʊ��Ϣ���������
	 * @return ��Ʊ��Ϣ���������
	 */
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	/**
	 * ��Ʊ��Ϣ���������
	 * @param recptionList ��Ʊ��Ϣ���������
	 */
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	
	/**
	 * ��Ʊ����
	 * @return ��Ʊ����
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * ��Ʊ����
	 * @param recption ��Ʊ����
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * ��ȡ֪ͨɾ������
	 * @return String[]
	 */
	
	public String[] getDeleteNid() {
		return deleteNid;
	}

	/**
	 * ����֪ͨɾ������
	 * @param deleteNid String[]
	 */
	
	public void setDeleteNid(String[] deleteNid) {
		this.deleteNid = deleteNid;
	}

}
