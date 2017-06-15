/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0129Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	protected String outtime_f;
	protected String outtime_t;
	protected String outtype;
	protected String outstockorg_q;
	protected String outstockorg_qname;
	protected String accountstatus_q;
	protected String reqstatus;
	private String seqcode_q;
	private String itemsname_q;
	
	public String getOutstockorg_qname() {
		return outstockorg_qname;
	}

	public void setOutstockorg_qname(String outstockorg_qname) {
		this.outstockorg_qname = outstockorg_qname;
	}

	public String getOutstockorg_q() {
		return outstockorg_q;
	}

	public void setOutstockorg_q(String outstockorg_q) {
		this.outstockorg_q = outstockorg_q;
	}

	public String getOuttime_f() {
		return outtime_f;
	}

	public void setOuttime_f(String outtime_f) {
		this.outtime_f = outtime_f;
	}

	public String getOuttime_t() {
		return outtime_t;
	}

	public void setOuttime_t(String outtime_t) {
		this.outtime_t = outtime_t;
	}

	public String getOuttype() {
		return outtype;
	}

	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	public String getAccountstatus_q() {
		return accountstatus_q;
	}

	public void setAccountstatus_q(String accountstatus_q) {
		this.accountstatus_q = accountstatus_q;
	}

	public String getReqstatus() {
		return reqstatus;
	}

	public void setReqstatus(String reqstatus) {
		this.reqstatus = reqstatus;
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