/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.csebank.items.form;

import com.deliverik.framework.base.BaseForm;

public class ITEMS0121Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	protected String approveType;
	protected String approve;
	protected Integer[] outstockid;

	public Integer[] getOutstockid() {
		return outstockid;
	}

	public void setOutstockid(Integer[] outstockid) {
		this.outstockid = outstockid;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

	public String getApproveType() {
		return approveType;
	}

	public void setApproveType(String approveType) {
		this.approveType = approveType;
	}
	
}
