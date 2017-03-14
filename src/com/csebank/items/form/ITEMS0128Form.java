/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0128Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	protected String intime_f;
	protected String intime_t;
	protected String instockorg_name;
	protected String instockorg;
	private String seqcode_q;
	private String itemsname_q;

	public String getIntime_f() {
		return intime_f;
	}

	public void setIntime_f(String intime_f) {
		this.intime_f = intime_f;
	}

	public String getIntime_t() {
		return intime_t;
	}

	public void setIntime_t(String intime_t) {
		this.intime_t = intime_t;
	}

	public String getInstockorg_name() {
		return instockorg_name;
	}

	public void setInstockorg_name(String instockorg_name) {
		this.instockorg_name = instockorg_name;
	}

	public String getInstockorg() {
		return instockorg;
	}

	public void setInstockorg(String instockorg) {
		this.instockorg = instockorg;
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