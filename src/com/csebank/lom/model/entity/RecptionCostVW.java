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

import com.csebank.lom.model.RecptionCost;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 接待管理实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class RecptionCostVW  implements Serializable, Cloneable, RecptionCost {
	
	/** 接待管理ID */
	@Id
	protected Integer rid;
	
	/** 接待工作名称 */
	protected String rname;
	
	/** 主要申请部门层次码 */
	protected String rapporgid;
	
	/** 接待结束日期 */
	protected String retime;
	
	/** 接待开始日期 */
	protected String rstime;
	
	
	/** 登记日期 */
	protected String rdate;
	
	/** 状态（1进行中，2结束） */
	protected String rstatus;
	
	
	/** 物品费用统计 */
	protected BigDecimal stockSum;
	
	/** 借款统计 */
	protected BigDecimal loanSum;
	
	/** 食堂费用统计 */
	protected BigDecimal entertainmentSum;
	
	/** 费用合计 */
	protected BigDecimal cost;
	
	public BigDecimal getCost() {
		return cost.add(stockSum).add(loanSum).add(entertainmentSum);
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	/** 机构信息实体 */
	@OneToOne
	@JoinColumn(name="rapporgid", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	protected OrganizationTB organizationTB;
	
	public BigDecimal getStockSum() {
		return stockSum;
	}

	public void setStockSum(BigDecimal stockSum) {
		this.stockSum = stockSum;
	}

	public BigDecimal getLoanSum() {
		return loanSum;
	}

	public void setLoanSum(BigDecimal loanSum) {
		this.loanSum = loanSum;
	}

	public BigDecimal getEntertainmentSum() {
		return entertainmentSum;
	}

	public void setEntertainmentSum(BigDecimal entertainmentSum) {
		this.entertainmentSum = entertainmentSum;
	}



	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return rid;
	}
	
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

	/**
	 * 主要申请部门层次码
	 * @return 主要申请部门层次码
	 */
	public String getRapporgid() {
		return rapporgid;
	}

	/**
	 * 主要申请部门层次码
	 * @param rapporgid 主要申请部门层次码
	 */
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}

	

	/**
	 * 登记日期
	 * @return 登记日期
	 */
	public String getRdate() {
		return rdate;
	}

	/**
	 * 登记日期
	 * @param rdate 登记日期
	 */
	public void setRdate(String rdate) {
		this.rdate = rdate;
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
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
}
