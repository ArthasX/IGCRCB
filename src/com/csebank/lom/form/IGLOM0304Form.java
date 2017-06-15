/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 借款审批、确认form
 *
 */
public class IGLOM0304Form extends BaseForm implements LoanPayDetailSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** 借款人 */
	protected String lpduser_q;
	
	/** 借款删除对象 */
	protected String[] deleteLpdid;
	
	/** 借还款区分 0:借款 */
	protected String lpdtype_q = IGLOMCONSTANTS.LPD_TYPE_LOAN;
	
	/** 借款ID */
	protected Integer lpdid;
	
	/** 借款状态 */
	protected String lpdstatus;
	
	/** 借款状态 */
	protected String lpdstatus_q;
	
	/** 接待ID */
	protected Integer rid_q;
	
	/** 接待工作状态 */
	protected String rstatus;
	
	/** 页面标识 */
	protected String flag;
	/**借款查询开始时间 */
	protected String time_from;
	/**借款查询结束时间 */
	protected String time_to;
	/**借款审批状态 */
	protected String spType ;

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

	/**
	 * 借款状态取得
	 * @return 借款状态
	 */
	public String getLpdstatus_q() {
		return lpdstatus_q;
	}

	/**
	 * 借款状态设定
	 * @param lpdstatus_q 借款状态
	 */
	public void setLpdstatus_q(String lpdstatus_q) {
		this.lpdstatus_q = lpdstatus_q;
	}

	/**
	 * 借还款区分 0:借款取得
	 * @return 借还款区分 0:借款
	 */
	public String getLpdtype_q() {
		return lpdtype_q;
	}

	/**
	 * 借还款区分 0:借款设定
	 * @return 借还款区分 0:借款
	 */
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

	/**
	 * 接待ID取得
	 * @return 接待ID
	 */
	public Integer getRid_q() {
		return rid_q;
	}

	/**
	 * 接待ID设定
	 * @param rid_q 接待ID
	 */
	public void setRid_q(Integer rid_q) {
		this.rid_q = rid_q;
	}

	/**
	 * 接待工作状态取得
	 * @return 接待工作状态
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * 接待工作状态设定
	 * @param rstatus 接待工作状态
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}

	/**
	 * 页面标识取得
	 * @return 页面标识
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 页面标识设定
	 * @param flag 页面标识
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	public Integer getLdid_invoice() {
		// TODO Auto-generated method stub
		return null;
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
