/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.condition.LoanPayDetailSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 冲抵计财部借款form
 *
 */
public class IGLOM0307Form extends BaseForm implements LoanPayDetailSearchCond {
	
	private static final long serialVersionUID = 1L;

	/** 借款人 */
	protected String lpduser_q;
	
	/** 借款删除对象 */
	protected String[] deleteLpdid;
	
	/** 借还款区分 */
	protected String lpdtype_q = IGLOMCONSTANTS.LPD_TYPE_PAY_INVOICE;
	
	/** 发票日期开始 */
	protected String lpdinvoicedate_from;
	
	/** 发票日期结束 */
	protected String lpdinvoicedate_to;
	
	/** 发票金额 */
	protected String lpdinvoiceamount_q = "0";
	
	/** 状态 */
	protected String lpdstatus_q;
	
	/** 汇总金额 */
	protected BigDecimal money;
	
	/** 预支费用ID */
	protected Integer acid;

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
	 * 汇总金额取得
	 * @return 汇总金额
	 */
	public BigDecimal getMoney() {
		return money;
	}

	/**
	 * 汇总金额设定
	 * @param money 汇总金额
	 */
	public void setMoney(BigDecimal money) {
		this.money = money;
	}
	
	/**
	 * 预支费用ID取得
	 * @return 预支费用ID
	 */
	public Integer getAcid() {
		return acid;
	}

	/**
	 * 预支费用ID设定
	 * @param acid 预支费用ID
	 */
	public void setAcid(Integer acid) {
		this.acid = acid;
	}

	public Integer getRid_q() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getLdid_invoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSpType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTime_from() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getTime_to() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
