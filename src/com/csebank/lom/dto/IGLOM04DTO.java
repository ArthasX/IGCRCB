/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
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
 * 发票管理DTO
 *
 */
@SuppressWarnings("serial")
public class IGLOM04DTO extends BaseDTO implements Serializable {
	

	/** 发票管理查询条件 */
	protected InvoiceInfoSearchCond invoiceInfoSearchCond;

	/** 分页用DTO */
	protected PagingDTO pagingDto;

	/** 发票信息最大检索件数 */
	protected int maxSearchCount;
	
	/** 发票信息Form */
	protected IGLOM0401Form iglom0401Form;

	
	/** 发票搜索结果集 */
	protected List<Invoice> invoiceList;
	
	/** 发票搜索结果集 */
	protected List<InvoiceTj> invoiceVWList;
	
	
	public List<InvoiceTj> getInvoiceVWList() {
		return invoiceVWList;
	}

	public void setInvoiceVWList(List<InvoiceTj> invoiceVWList) {
		this.invoiceVWList = invoiceVWList;
	}

	/** 发票工作 */
	protected Invoice invoice;
	
	/**
	 * 通知删除主键
	 */
	
	protected String[] deleteNid;
	

	/**
	 * 接待管理查询条件取得
	 * @return
	 */
	public InvoiceInfoSearchCond getInvoiceInfoSearchCond() {
		return invoiceInfoSearchCond;
	}

	/**
	 * 接待管理查询条件设定
	 * @param recptionSearchCond 接待管理查询条件设定
	 */
	public void setInvoiceInfoSearchCond(InvoiceInfoSearchCond invoiceInfoSearchCond) {
		this.invoiceInfoSearchCond = invoiceInfoSearchCond;
	}

	/**
	 * 分页用DTO取得
	 * @return 分页用DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * 分页用DTO设定
	 * @param pagingDto 分页用DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * 发票信息最大检索件数取得
	 * @return 发票信息最大检索件数取得
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * 发票信息最大检索件数设定
	 * @param maxSearchCount 发票信息最大检索件数
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * 发票信息Form取得
	 * @return 发票信息Form
	 */
	public IGLOM0401Form getIglom0401Form() {
		return iglom0401Form;
	}

	/**
	 * 发票信息Form设定
	 * @param igLOM0401Form 发票信息Form
	 */
	public void setIglom0401Form(IGLOM0401Form iglom0401Form) {
		this.iglom0401Form = iglom0401Form;
	}
	
	/**
	 * 发票信息搜索结果集
	 * @return 发票信息搜索结果集
	 */
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	/**
	 * 发票信息搜索结果集
	 * @param recptionList 发票信息搜索结果集
	 */
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}
	
	/**
	 * 发票工作
	 * @return 发票工作
	 */
	public Invoice getInvoice() {
		return invoice;
	}

	/**
	 * 发票工作
	 * @param recption 发票工作
	 */
	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	/**
	 * 获取通知删除主键
	 * @return String[]
	 */
	
	public String[] getDeleteNid() {
		return deleteNid;
	}

	/**
	 * 设置通知删除主键
	 * @param deleteNid String[]
	 */
	
	public void setDeleteNid(String[] deleteNid) {
		this.deleteNid = deleteNid;
	}

}
