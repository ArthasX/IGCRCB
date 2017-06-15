/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.PersonLoanSummary;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 预支人员统计实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class PersonLoanSummaryVW implements Serializable, Cloneable, PersonLoanSummary {
	
	/** 借款人 */
	@Id
	protected String lpduser;
	
	/** 借款金额 */
	protected BigDecimal loanamount;
	
	/** 发票金额 */
	protected BigDecimal invoiceamount;
	
	/** 还款现金 */
	protected BigDecimal payamount;
	
	/** 借款人机构层次码 */
	protected String lpduserorg;
	
	/** 机构信息实体 */
	@OneToOne
	@JoinColumn(name="lpduserorg", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	public OrganizationTB organizationTB;
	
	/**
	 * 借款人取得
	 * @return 借款人
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * 借款人设定
	 * @param lpduser 借款人
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * 借款金额取得
	 * @return 借款金额
	 */
	public BigDecimal getLoanamount() {
		return loanamount;
	}

	/**
	 * 借款金额设定
	 * @param loanamount 借款金额
	 */
	public void setLoanamount(BigDecimal loanamount) {
		this.loanamount = loanamount;
	}

	/**
	 * 发票金额取得
	 * @return 发票金额
	 */
	public BigDecimal getInvoiceamount() {
		return invoiceamount;
	}

	/**
	 * 发票金额设定
	 * @param invoiceamount 发票金额ID
	 */
	public void setInvoiceamount(BigDecimal invoiceamount) {
		this.invoiceamount = invoiceamount;
	}

	/**
	 * 还款现金取得
	 * @return 还款现金
	 */
	public BigDecimal getPayamount() {
		return payamount;
	}

	/**
	 * 还款现金设定
	 * @param payamount 还款现金
	 */
	public void setPayamount(BigDecimal payamount) {
		this.payamount = payamount;
	}

	public String getLpduserorg() {
		return lpduserorg;
	}

	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

}
