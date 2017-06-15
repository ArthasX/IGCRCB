/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0130Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	protected String category;
	protected String stockorg_qname;
	protected String stockorg_q;
	private String seqcode_q;
	private String itemsname_q;
	
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getSeqcode_q() {
		return seqcode_q;
	}

	public void setSeqcode_q(String seqcode_q) {
		this.seqcode_q = seqcode_q;
	}

	public String getItemsname_q() {
		return itemsname_q;
	}

	public void setItemsname_q(String itemsname_q) {
		this.itemsname_q = itemsname_q;
	}


}