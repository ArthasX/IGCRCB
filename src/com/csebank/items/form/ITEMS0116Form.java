/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0116Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String category;
	private String seqcode;
	private String outtype;
	private String userid;
	private String username;
	private Integer[] instockid;
	private Integer[] useNum;
	private String[] desc;
	private String[] reqorg;
	private String[] reqname;

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

	public String getOuttype() {
		return outtype;
	}

	public void setOuttype(String outtype) {
		this.outtype = outtype;
	}

	public Integer[] getInstockid() {
		return instockid;
	}

	public void setInstockid(Integer[] instockid) {
		this.instockid = instockid;
	}

	public Integer[] getUseNum() {
		return useNum;
	}

	public void setUseNum(Integer[] useNum) {
		this.useNum = useNum;
	}

	public String[] getDesc() {
		return desc;
	}

	public void setDesc(String[] desc) {
		this.desc = desc;
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

	public String[] getReqorg() {
		return reqorg;
	}

	public void setReqorg(String[] reqorg) {
		this.reqorg = reqorg;
	}

	public String[] getReqname() {
		return reqname;
	}

	public void setReqname(String[] reqname) {
		this.reqname = reqname;
	}

}
