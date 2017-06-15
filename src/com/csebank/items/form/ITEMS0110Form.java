/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0110Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String category;
	private String seqcode;
	private String userid;
	private String username;
	private Integer[] instockid;
	private Double[] editInprise;
	private Double[] editOutprise;
	
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
	public Integer[] getInstockid() {
		return instockid;
	}
	public void setInstockid(Integer[] instockid) {
		this.instockid = instockid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Double[] getEditInprise() {
		return editInprise;
	}
	public void setEditInprise(Double[] editInprise) {
		this.editInprise = editInprise;
	}
	public Double[] getEditOutprise() {
		return editOutprise;
	}
	public void setEditOutprise(Double[] editOutprise) {
		this.editOutprise = editOutprise;
	}
	
}
