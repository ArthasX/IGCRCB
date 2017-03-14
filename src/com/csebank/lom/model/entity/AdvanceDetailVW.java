/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.IdClass;

import com.csebank.lom.model.AdvanceDetail;

/**
 * 
 * 预支明细统计实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@IdClass(AdvanceDetailVWPK.class)
public class AdvanceDetailVW implements Serializable, Cloneable, AdvanceDetail {
	
	/** ID */
	@Id
	protected String id;
	
	/** 交易日期 */
	protected String date;
	
	/** 交易时间 */
	protected String time;
	
	/** 交易类型 */
	@Id
	protected String type;
	
	/** 人员 */
	protected String username;
	
	/** 金额 */
	protected BigDecimal amount;
	
	/** 发票金额 */
	protected BigDecimal invoiceamount;
	
	/** 库存金额 */
	protected BigDecimal stockamount;
	
	/** 状态 */
	protected String status;
	
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
	 * 交易时间取得
	 * @return 交易时间
	 */
	public String getTime() {
		return time;
	}
	
	/**
	 * 交易时间设定
	 * @param time 交易时间
	 */
	public void setTime(String time) {
		this.time = time;
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
	 * 人员取得
	 * @return 人员
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * 人员设定
	 * @param username 人员
	 */
	public void setUsername(String username) {
		this.username = username;
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
	 * 库存金额取得
	 * @return 库存金额
	 */
	public BigDecimal getStockamount() {
		return stockamount;
	}

	/**
	 * 库存金额设定
	 * @param stockamount 库存金额
	 */
	public void setStockamount(BigDecimal stockamount) {
		this.stockamount = stockamount;
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
	
}
