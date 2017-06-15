/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.RecptionVWInfo;

/**
 * 
 * 接待统计实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionVW implements Serializable, Cloneable, RecptionVWInfo {

	
	/** 接待工作数量 */
	protected Integer rnum;
	
	/** 月份 */
	@Id
	protected String month;
	
	/** 费用总额 */
	protected BigDecimal amount;

	/**
	 * 接待工作数量取得
	 * @return 接待工作数量取得
	 */
	public Integer getRnum() {
		return rnum;
	}

	/**
	 * 接待工作数量取得设定
	 * @param rnum 接待工作数量取得
	 */
	public void setRnum(Integer rnum) {
		this.rnum = rnum;
	}

	/**
	 * 月份取得
	 * @return 月份
	 */
	public String getMonth() {
		return month;
	}

	/**
	 * 月份设定
	 * @param month 月份
	 */
	public void setMonth(String month) {
		this.month = month;
	}

	/**
	 * 费用总额取得
	 * @return 费用总额
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 费用总额设定
	 * @param amount 费用总额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
