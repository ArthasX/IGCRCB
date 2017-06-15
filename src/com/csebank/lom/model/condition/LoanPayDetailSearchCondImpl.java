/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.condition;

/**
 * 
 * 借还款明细查询接口实现
 *
 */
public class LoanPayDetailSearchCondImpl implements LoanPayDetailSearchCond {
	
	/** 借款人 */
	protected String lpduser_q;
	
	/** 借还款区分 */
	protected String lpdtype_q;
	
	/** 发票日期开始 */
	protected String lpdinvoicedate_from;
	
	/** 发票日期结束 */
	protected String lpdinvoicedate_to;
	
	/** 发票金额 */
	protected String lpdinvoiceamount_q;
	
	/** 状态 */
	protected String lpdstatus_q;
	
	/** 接待ID */
	protected Integer rid_q;
	
	/** 借款ID */
	protected Integer lpdid;
	protected Integer ldid_invoice;
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
	 * 发票日期开始取得
	 * @return 发票日期开始
	 */
	public String getLpdinvoicedate_from() {
		return lpdinvoicedate_from;
	}

	/**
	 * 发票日期开始设定
	 * @param lpdinvoicedate_from 发票日期开始
	 */
	public void setLpdinvoicedate_from(String lpdinvoicedate_from) {
		this.lpdinvoicedate_from = lpdinvoicedate_from;
	}

	/**
	 * 发票日期结束取得
	 * @return 发票日期结束
	 */
	public String getLpdinvoicedate_to() {
		return lpdinvoicedate_to;
	}

	/**
	 * 发票日期结束设定
	 * @param lpdinvoicedate_to 发票日期结束
	 */
	public void setLpdinvoicedate_to(String lpdinvoicedate_to) {
		this.lpdinvoicedate_to = lpdinvoicedate_to;
	}

	/**
	 * 借款区分取得
	 * @return 借款区分
	 */
	public String getLpdtype_q() {
		return lpdtype_q;
	}
	
	/**
	 * 借款区分设定
	 * @param lpdtype_q 借款区分
	 */
	public void setLpdtype_q(String lpdtype_q) {
		this.lpdtype_q = lpdtype_q;
	}
	
	/**
	 * 发票金额取得
	 * @return 发票金额
	 */
	public String getLpdinvoiceamount_q() {
		return lpdinvoiceamount_q;
	}
	
	/**
	 * 发票金额设定
	 * @param lpdinvoiceamount_q 发票金额
	 */
	public void setLpdinvoiceamount_q(String lpdinvoiceamount_q) {
		this.lpdinvoiceamount_q = lpdinvoiceamount_q;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getLpdstatus_q() {
		return lpdstatus_q;
	}

	/**
	 * 状态设定
	 * @param lpdstatus_q 状态
	 */
	public void setLpdstatus_q(String lpdstatus_q) {
		this.lpdstatus_q = lpdstatus_q;
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

	public Integer getLdid_invoice() {
		return ldid_invoice;
	}

	public void setLdid_invoice(Integer ldid_invoice) {
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
