/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.RecptionAmount;

/**
 * 
 * 接待管理实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionAmountVW implements Serializable, Cloneable,  RecptionAmount {
	
	/** 接待管理ID */
	@Id
	protected Integer rid;
	
	/** 接待工作名称 */
	protected String rname;
	
	/** 接待人数规模 */
	protected String rscale;
	
	/** 接待标准 */
	protected String rstandard;
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;
	
	/** 费用总额 */
	protected BigDecimal amount;
	
	/** 申请机构 */
	protected String rapporgname;
	
	protected String orgsyscoding;
	
	/** 接待结束日期 */
	protected String retime;
	
	/** 接待开始日期 */
	protected String rstime;
	

	
	/**
	 * 接待管理ID
	 * @return 接待管理ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待管理ID
	 * @param rid 接待管理ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
	}

	/**
	 * 接待工作名称
	 * @return 接待工作名称
	 */
	public String getRname() {
		return rname;
	}

	/**
	 * 接待工作名称
	 * @param rname 接待工作名称
	 */
	public void setRname(String rname) {
		this.rname = rname;
	}

	/**
	 * 接待人数规模
	 * @return 接待人数规模
	 */
	public String getRscale() {
		return rscale;
	}

	/**
	 * 接待人数规模
	 * @param rscale 接待人数规模
	 */
	public void setRscale(String rscale) {
		this.rscale = rscale;
	}

	/**
	 * 接待标准
	 * @return 接待标准
	 */
	public String getRstandard() {
		return rstandard;
	}

	/**
	 * 接待标准
	 * @param rstandard接待标准
	 */
	public void setRstandard(String rstandard) {
		this.rstandard = rstandard;
	}

	/**
	 * 状态
	 * @return 状态
	 */
	public String getRstatus() {
		return rstatus;
	}

	/**
	 * 状态
	 * @param rstatus 状态
	 */
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}


	/**
	 * 费用总额
	 * @return 费用总额
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * 费用总额
	 * @param amount 费用总额
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getRapporgname() {
		return rapporgname;
	}

	public void setRapporgname(String rapporgname) {
		this.rapporgname = rapporgname;
	}

	public String getOrgsyscoding() {
		return orgsyscoding;
	}

	public void setOrgsyscoding(String orgsyscoding) {
		this.orgsyscoding = orgsyscoding;
	}

	/**
	 * 接待结束日期 
	 * @return 接待结束日期 
	 */
	public String getRetime() {
		return retime;
	}

	/**
	 * 接待结束日期 
	 * @param retime 接待结束日期 
	 */
	public void setRetime(String retime) {
		this.retime = retime;
	}

	/**
	 * 接待开始日期 
	 * @return 接待开始日期 
	 */
	public String getRstime() {
		return rstime;
	}

	/**
	 * 接待开始日期
	 * @param rstime 接待开始日期
	 */
	public void setRstime(String rstime) {
		this.rstime = rstime;
	}


}
