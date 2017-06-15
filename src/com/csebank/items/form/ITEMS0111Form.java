/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0111Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String category;
	private String seqcode;
	private String userid;
	private String username;
	private Integer[] instockid;
	private Integer[] inputSubInnum;
	
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
	public Integer[] getInputSubInnum() {
		return inputSubInnum;
	}
	public void setInputSubInnum(Integer[] inputSubInnum) {
		this.inputSubInnum = inputSubInnum;
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

}
