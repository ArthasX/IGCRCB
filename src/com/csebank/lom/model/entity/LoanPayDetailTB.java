/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 预支费用实体
 *
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
@Table(name="LoanPayDetail")
public class LoanPayDetailTB extends BaseEntity implements Serializable, Cloneable, LoanPayDetail {
	
	/** 借还款明细ID */
	@Id
	@TableGenerator(
		    name="LOANPAYDETAIL_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="LOANPAYDETAIL_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="LOANPAYDETAIL_TABLE_GENERATOR")
	protected Integer lpdid;
		
	/** 借还款区分 */
	protected String lpdtype;
	
	/** 借还款人 */
	protected String lpduser;
	
	/** 借还款日期 */
	protected String lpddate;
	
	/** 借还款金额 */
	protected BigDecimal lpdamount;
	
	/** 用途 */
	protected String lpdcomment;
	
	/** 状态 */
	protected String lpdstatus;
	
	/** 审批人ID */
	protected String lpdpersion;
	
	/** 审批人姓名 */
	protected String lpdpersionname;
	
	/** 发票日期 */
	protected String lpdinvoicedate;
	
	/** 发票号 */
	protected String lpdinvoicenum;
	
	/** 发票签发单位 */
	protected String lpdinvoicecor;
	
	/** 发票金额 */
	protected BigDecimal lpdinvoiceamount;
	
	/** 实际用途说明 */
	protected String lpdinvoicecomment;
	
	/** 借款ID */
	protected Integer ldid;
	
	/** 接待管理ID */
	protected Integer rid;
	
	/** 预支费用ID */
	protected Integer acid;
	
	/** 库存金额 */
	protected BigDecimal lpdstockamount;
	
	/** 借款人机构层次码 */
	protected String lpduserorg;
	
	/** 机构信息实体 */
	@OneToOne
	@JoinColumn(name="lpduserorg", referencedColumnName="orgsyscoding", updatable=false, insertable= false)
	@Basic(fetch = FetchType.EAGER)
	@NotFound(action = NotFoundAction.IGNORE)
	public OrganizationTB organizationTB;
	
	/** 实际发票金额 */
	public BigDecimal lpdactinvoice;
	
	/** 实际还款人 */
	public String lpdactuser;
	
	/** 借还款时间 */
	public String lpdtime;
	
	/**
	 * 主键取得
	 * @return 
	 */
	public Serializable getPK() {
		return lpdid;
	}
	
	/**
	 * 借还款明细ID取得
	 * @return 预支登记时间
	 */
	public Integer getLpdid() {
		return lpdid;
	}
	
	/**
	 * 借还款明细ID设定
	 * @param lpdid 借还款明细ID
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
	}

	/**
	 * 借还款区分取得
	 * @return 借还款区分
	 */
	public String getLpdtype() {
		return lpdtype;
	}

	/**
	 * 借还款区分设定
	 * @param lpdtype 借还款区分
	 */
	public void setLpdtype(String lpdtype) {
		this.lpdtype = lpdtype;
	}

	/**
	 * 借还款人取得
	 * @return 借还款人
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * 借还款人设定
	 * @param lpduser 借还款人
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * 借还款日期取得
	 * @return 借还款日期
	 */
	public String getLpddate() {
		return lpddate;
	}

	/**
	 * 借还款日期设定
	 * @param lpddate 借还款日期
	 */
	public void setLpddate(String lpddate) {
		this.lpddate = lpddate;
	}

	/**
	 * 借还款金额取得
	 * @return 借还款金额
	 */
	public BigDecimal getLpdamount() {
		return lpdamount;
	}

	/**
	 * 借还款金额设定
	 * @param lpdamount 借还款金额
	 */
	public void setLpdamount(BigDecimal lpdamount) {
		this.lpdamount = lpdamount;
	}

	/**
	 * 用途取得
	 * @return 用途
	 */
	public String getLpdcomment() {
		return lpdcomment;
	}

	/**
	 * 用途设定
	 * @param lpdcomment 用途
	 */
	public void setLpdcomment(String lpdcomment) {
		this.lpdcomment = lpdcomment;
	}

	/**
	 * 状态取得
	 * @return 状态
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * 状态设定
	 * @param lpdstatus 状态
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	/**
	 * 审批人ID取得
	 * @return 审批人ID
	 */
	public String getLpdpersion() {
		return lpdpersion;
	}

	/**
	 * 审批人ID设定
	 * @param lpdpersion 审批人ID
	 */
	public void setLpdpersion(String lpdpersion) {
		this.lpdpersion = lpdpersion;
	}

	/**
	 * 审批人姓名取得
	 * @return 审批人姓名
	 */
	public String getLpdpersionname() {
		return lpdpersionname;
	}

	/**
	 * 审批人姓名设定
	 * @param lpdpersionname 审批人姓名
	 */
	public void setLpdpersionname(String lpdpersionname) {
		this.lpdpersionname = lpdpersionname;
	}

	/**
	 * 发票日期取得
	 * @return 发票日期
	 */
	public String getLpdinvoicedate() {
		return lpdinvoicedate;
	}

	/**
	 * 发票日期设定
	 * @param lpdinvoicedate 发票日期
	 */
	public void setLpdinvoicedate(String lpdinvoicedate) {
		this.lpdinvoicedate = lpdinvoicedate;
	}

	/**
	 * 发票号取得
	 * @return 发票号
	 */
	public String getLpdinvoicenum() {
		return lpdinvoicenum;
	}

	/**
	 * 发票号设定
	 * @param lpdinvoicenum 发票号
	 */
	public void setLpdinvoicenum(String lpdinvoicenum) {
		this.lpdinvoicenum = lpdinvoicenum;
	}

	/**
	 * 发票签发单位取得
	 * @return 发票签发单位
	 */
	public String getLpdinvoicecor() {
		return lpdinvoicecor;
	}

	/**
	 * 发票签发单位设定
	 * @param lpdinvoicecor 发票签发单位
	 */
	public void setLpdinvoicecor(String lpdinvoicecor) {
		this.lpdinvoicecor = lpdinvoicecor;
	}

	/**
	 * 发票金额取得
	 * @return 发票金额
	 */
	public BigDecimal getLpdinvoiceamount() {
		return lpdinvoiceamount;
	}

	/**
	 * 发票金额设定
	 * @param lpdinvoiceamount 发票金额
	 */
	public void setLpdinvoiceamount(BigDecimal lpdinvoiceamount) {
		this.lpdinvoiceamount = lpdinvoiceamount;
	}

	/**
	 * 实际用途说明取得
	 * @return 实际用途说明
	 */
	public String getLpdinvoicecomment() {
		return lpdinvoicecomment;
	}

	/**
	 * 实际用途说明设定
	 * @param lpdinvoicecomment 实际用途说明
	 */
	public void setLpdinvoicecomment(String lpdinvoicecomment) {
		this.lpdinvoicecomment = lpdinvoicecomment;
	}

	/**
	 * 借款ID取得
	 * @return 借款ID
	 */
	public Integer getLdid() {
		return ldid;
	}

	/**
	 * 借款ID设定
	 * @param ldid 借款ID
	 */
	public void setLdid(Integer ldid) {
		this.ldid = ldid;
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
	
	/**
	 * 库存金额取得
	 * @return 库存金额
	 */
	public BigDecimal getLpdstockamount() {
		return lpdstockamount;
	}

	/**
	 * 库存金额设定
	 * @param lpdstockamount 库存金额
	 */
	public void setLpdstockamount(BigDecimal lpdstockamount) {
		this.lpdstockamount = lpdstockamount;
	}

	/**
	 * 借款人机构层次码取得
	 * @return 借款人机构层次码
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * 借款人机构层次码设定
	 * @param lpduserorg 借款人机构层次码
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * 机构取得
	 * @return 机构
	 */
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}

	/**
	 * 机构设定
	 * @param organizationTB 机构
	 */
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}

	/**
	 * 实际发票金额取得
	 * @return 实际发票金额
	 */
	public BigDecimal getLpdactinvoice() {
		return lpdactinvoice;
	}

	/**
	 * 实际发票金额设定
	 * @param lpdactinvoice 实际发票金额
	 */
	public void setLpdactinvoice(BigDecimal lpdactinvoice) {
		this.lpdactinvoice = lpdactinvoice;
	}

	/**
	 * 实际还款人取得
	 * @return 实际还款人
	 */
	public String getLpdactuser() {
		return lpdactuser;
	}

	/**
	 * 实际还款人设定
	 * @param lpdactuser 实际还款人
	 */
	public void setLpdactuser(String lpdactuser) {
		this.lpdactuser = lpdactuser;
	}

	/**
	 * 借还款时间取得
	 * @return 借还款时间
	 */
	public String getLpdtime() {
		return lpdtime;
	}

	/**
	 * 借还款时间设定
	 * @param lpdtime 借还款时间
	 */
	public void setLpdtime(String lpdtime) {
		this.lpdtime = lpdtime;
	}
	
}
