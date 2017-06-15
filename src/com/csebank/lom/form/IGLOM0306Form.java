/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 还款form
 *
 */
public class IGLOM0306Form extends BaseForm implements LoanPayDetailSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** 借款人 */
	protected String lpduser_q;
	
	/** 借款删除对象 */
	protected String[] deleteLpdid;
	
	/** 借还款区分 0:借款 */
	protected String lpdtype_q;
	
	/** 借款ID */
	protected Integer lpdid;
	
	/** 借款状态 */
	protected String lpdstatus;
	
	/** 借款状态 */
	protected String lpdstatus_q = "0";
	
	/** 借款ID */
	protected String ldid_invoice;
	
	protected String time_from;
	protected String time_to;
	protected String spType;

	/**
	 * 借款人取得
	 * @return 借款人
	 */
	public String getLpduser_q() {
		return lpduser_q;
	}

	/**
	 * 借款人设定
	 * @param lpduser 借款人
	 */
	public void setLpduser_q(String lpduser_q) {
		this.lpduser_q = lpduser_q;
	}

	/**
	 * 借款删除对象取得
	 * @return 借款删除对象
	 */
	public String[] getDeleteLpdid() {
		return deleteLpdid;
	}

	/**
	 * 借款删除对象设定
	 * @param deleteLpdid 借款删除对象
	 */
	public void setDeleteLpdid(String[] deleteLpdid) {
		this.deleteLpdid = deleteLpdid;
	}

	/**
	 * 借还款区分 0:借款设定
	 * @param lpdtype_q 借还款区分 0:借款
	 */
	public void setLpdtype_q(String lpdtype_q) {
		this.lpdtype_q = lpdtype_q;
	}

	/**
	 * 借款ID取得
	 * @return 借款ID
	 */
	public Integer getLpdid() {
		return lpdid;
	}

	/**
	 * 借款ID设定
	 * @param lpdid 借款ID
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
	}

	/**
	 * 借款状态取得
	 * @return 借款状态
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * 借款状态设定
	 * @param lpdstatus 借款状态
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	public String getLpdstatus_q() {
		return lpdstatus_q;
	}

	public void setLpdstatus_q(String lpdstatus_q) {
		this.lpdstatus_q = lpdstatus_q;
	}

	public String getLpdtype_q() {
		return lpdtype_q;
	}

	public String getLpdinvoiceamount_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicedate_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicedate_to() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getLdid_invoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setLdid_invoice(String ldid_invoice) {
		this.ldid_invoice = ldid_invoice;
	}

	public String getTime_from() {
		return time_from;
	}

	public void setTime_from(String time_from) {
		this.time_from = time_from;
	}

	public String getTime_to() {
		return time_to;
	}

	public void setTime_to(String time_to) {
		this.time_to = time_to;
	}

	public String getSpType() {
		return spType;
	}

	public void setSpType(String spType) {
		this.spType = spType;
	}
	
}
