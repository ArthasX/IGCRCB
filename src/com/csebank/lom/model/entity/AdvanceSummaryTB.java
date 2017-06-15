/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import com.csebank.lom.model.AdvanceSummary;
import com.deliverik.framework.base.BaseEntity;

/**
 * 
 * 预支汇总实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="AdvanceSummary")
@IdClass(AdvanceSummaryTBPK.class)
public class AdvanceSummaryTB extends BaseEntity implements Serializable, Cloneable, AdvanceSummary {
	
	/** 年度取得 */
	@Id
	protected String asyear;

	/** 月份取得 */
	@Id
	protected String asmonth;

	/** 上月余额取得 */
	protected BigDecimal asprebalance;

	/** 本月预支金额取得 */
	protected BigDecimal asadvancescost;

	/** 借款金额取得 */
	protected BigDecimal asloan;

	/** 本月发票金额取得 */
	protected BigDecimal asinvoice;

	/** 本月还款金额取得 */
	protected BigDecimal aspay;

	/** 本月余额取得 */
	protected BigDecimal asbalance;

	/** 冻结金额取得 */
	protected BigDecimal asfreeze;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return new AdvanceSummaryTBPK(asyear, asmonth);
	}
	
	/**
	 * 年度取得
	 * @return 年度
	 */
	public String getAsyear() {
		return asyear;
	}
	
	/**
	 * 年度设定
	 * @return asyear 年度
	 */
	public void setAsyear(String asyear) {
		this.asyear = asyear;
	}

	/**
	 * 月份取得
	 * @return 月份
	 */
	public String getAsmonth() {
		return asmonth;
	}
	
	/**
	 * 月份设定
	 * @return asmonth 月份
	 */
	public void setAsmonth(String asmonth) {
		this.asmonth = asmonth;
	}
	
	/**
	 * 上月余额取得
	 * @return 上月余额
	 */
	public BigDecimal getAsprebalance() {
		return asprebalance;
	}
	
	/**
	 * 上月余额设定
	 * @return asprebalance 上月余额
	 */
	public void setAsprebalance(BigDecimal asprebalance) {
		this.asprebalance = asprebalance;
	}
	
	/**
	 * 本月预支金额取得
	 * @return 本月预支金额
	 */
	public BigDecimal getAsadvancescost() {
		return asadvancescost;
	}
	
	/**
	 * 本月预支金额设定
	 * @return asadvancescost 本月预支金额
	 */
	public void setAsadvancescost(BigDecimal asadvancescost) {
		this.asadvancescost = asadvancescost;
	}
	
	/**
	 * 借款金额取得
	 * @return 借款金额
	 */
	public BigDecimal getAsloan() {
		return asloan;
	}
	
	/**
	 * 借款金额设定
	 * @return asloan 借款金额
	 */
	public void setAsloan(BigDecimal asloan) {
		this.asloan = asloan;
	}
	
	/**
	 * 本月发票金额取得
	 * @return 本月发票金额
	 */
	public BigDecimal getAsinvoice() {
		return asinvoice;
	}
	
	/**
	 * 本月发票金额设定
	 * @return asinvoice 本月发票金额
	 */
	public void setAsinvoice(BigDecimal asinvoice) {
		this.asinvoice = asinvoice;
	}
	
	/**
	 * 本月还款金额取得
	 * @return 本月还款金额
	 */
	public BigDecimal getAspay() {
		return aspay;
	}
	
	/**
	 * 本月还款金额设定
	 * @return aspay 本月还款金额
	 */
	public void setAspay(BigDecimal aspay) {
		this.aspay = aspay;
	}
	
	/**
	 * 本月余额取得
	 * @return 本月余额
	 */
	public BigDecimal getAsbalance() {
		return asbalance;
	}
	
	/**
	 * 本月余额设定
	 * @return asbalance 本月余额
	 */
	public void setAsbalance(BigDecimal asbalance) {
		this.asbalance = asbalance;
	}
	
	/**
	 * 冻结金额取得
	 * @return 冻结金额
	 */
	public BigDecimal getAsfreeze() {
		return asfreeze;
	}
	
	/**
	 * 冻结金额设定
	 * @return asfreeze 冻结金额
	 */
	public void setAsfreeze(BigDecimal asfreeze) {
		this.asfreeze = asfreeze;
	}

}
