/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.PersonLoanDetail;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 人员借款明细统计实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(PersonLoanDetailVWPK.class)
public class PersonLoanDetailVW implements Serializable, Cloneable, PersonLoanDetail {
	
	/** ID */
	@Id
	protected String id;
	
	/** 交易日期 */
	protected String date;
	
	/** 交易类型 */
	@Id
	protected String type;
	
	/** 金额 */
	protected BigDecimal amount;
	
	/** 发票金额 */
	protected BigDecimal invoiceamount;
	
	/** 用途 */
	protected String comment;
	
	/** 状态 */
	protected String status;
	
	/** 状态 */
	protected String lpduserorg;
	  /** 机构信息实体 */
	@OneToOne
	@JoinColumn(name="lpduserorg", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	/**
	 * 交易日期取得
	 * @return 交易日期
	 */
	public String getDate() {
		return date;
	}

	/**
	 * 交易日期设定
	 * @param date 交易日期
	 */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	 * 交易类型取得
	 * @return 交易类型
	 */
	public String getType() {
		return type;
	}

	/**
	 * 交易类型设定
	 * @param type 交易类型
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 金额取得
	 * @return 金额
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 金额设定
	 * @param amount 金额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
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
	 * @param invoiceamount 发票金额
	 */
	public void setInvoiceamount(BigDecimal invoiceamount) {
		this.invoiceamount = invoiceamount;
	}

	/**
	 * 用途取得
	 * @return 用途
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 用途设定
	 * @param comment 用途
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getStatus() {
		return status;
	}
	
	/**
	 * 状态设定
	 * @param status 状态
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * ID取得
	 * @return ID
	 */
	public String getId() {
		return id;
	}

	/**
	 * ID设定
	 * @param id ID
	 */
	public void setId(String id) {
		this.id = id;
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
