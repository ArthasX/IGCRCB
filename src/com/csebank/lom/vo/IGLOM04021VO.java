/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.vo;

import java.io.Serializable;
import java.util.List;

import com.csebank.lom.model.Invoice;
import com.csebank.lom.model.InvoiceTj;
import com.deliverik.framework.base.BaseVO;

/**
 * 
 * 发票管理VO
 *
 */
public class IGLOM04021VO extends BaseVO implements Serializable {
	

	private static final long serialVersionUID = 1L;
	
	/**发票管理统计信息List*/
	protected List<InvoiceTj> invoiceVWList;

	/**
	 * 构造函数
	 * @param invoiceVWList List<ChangeKpi>
	 * 
	 */
	
	public IGLOM04021VO(List<InvoiceTj> invoiceVWList) {
		this.invoiceVWList = invoiceVWList;
	}

	/**
	 * 获取发票管理统计信息Lis
	 * @return 发票管理统计信息Lis
	 */
	public List<InvoiceTj> getInvoiceVWList() {
		return invoiceVWList;
	}
	
	/**
	 * 发票管理检索结果
	 */
	protected List<Invoice> invoiceList;

	/**
	 * 发票管理检索结果取得
	 * @return 发票管理检索结果
	 */
	public List<Invoice> getInvoiceList() {
		return invoiceList;
	}

	/**
	 * 发票管理检索结果
	 * @param recptionList 发票管理检索结果
	 */
	public void setInvoiceList(List<Invoice> invoiceList) {
		this.invoiceList = invoiceList;
	}

}
