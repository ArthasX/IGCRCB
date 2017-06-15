/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0112Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String category;
	private String seqcode;
	private String outtype;
	private String stockorg_q;
	private String stockorg_qname;
	/**
	 * 物品名称
	 */
	protected String itemsname;
	
	
	/**
	 * @return the itemsname
	 */
	public String getItemsname() {
		return itemsname;
	}
	/**
	 * @param itemsname the itemsname to set
	 */
	public void setItemsname(String itemsname) {
		this.itemsname = itemsname;
	}
	
	public String getStockorg_qname() {
		return stockorg_qname;
	}
	public void setStockorg_qname(String stockorg_qname) {
		this.stockorg_qname = stockorg_qname;
	}
	public String getStockorg_q() {
		return stockorg_q;
	}
	public void setStockorg_q(String stockorg_q) {
		this.stockorg_q = stockorg_q;
	}
	public String getOuttype() {
		return outtype;
	}
	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSeqcode() {
		return seqcode;
	}
	public void setSeqcode(String seqcode) {
		this.seqcode = seqcode;
	}
	
}
