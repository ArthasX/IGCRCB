/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.LoanPayDetail;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 借款登记变更Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0303Form extends BaseForm  implements LoanPayDetail {


	/** 借还款ID */
	protected Integer lpdid;
	
	/** 借还款区分(0:借款 1:现金还款 2:支票还款) */
	protected String lpdtype;
	
	/** 借还款人 */
	protected String lpduser;
	
	/** 借还款日期 */
	protected String lpddate;
	
	/** 借还款金额 */
	protected BigDecimal lpdamount;
	
	/** 用途 */
	protected String lpdcomment;
	
	/** 状态(借款时: 0:已确认 1:待审批 2:待确认 3:审批未通过 4:已还款) */
	protected String lpdstatus;
	
	/** 编辑标识 */
	protected String mode = "0";
	
	/** 借款人机构层次码 */
	protected String lpduserorg;
	
	/** 借款人机构名称 */
	protected String lpduserorgname;
	
	/** 库存金额 */
	protected BigDecimal lpdstockamount;
	
	/** 接待ID */
	protected Integer rid;
	
	/** 借还款时间 */
	public String lpdtime;
	
	/** 可用金额 */
	protected BigDecimal availableAmount;
	
	
	/**
	 * 编辑标识取得
	 * @return 编辑标识
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 编辑标识设定
	 * @param mode 编辑标识
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 借还款ID取得
	 * @return 借还款ID
	 */
	public Integer getLpdid() {
		return lpdid;
	}

	/**
	 * 借还款ID设定
	 * @param lpdid 借还款ID
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

	public Integer getLdid() {
		// TODO Auto-generated method stub
		return null;
	}

	public BigDecimal getLpdinvoiceamount() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicecomment() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicecor() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicedate() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdinvoicenum() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdpersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdpersionname() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getAcid() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrganizationTB getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
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
	 * 借款人机构名称取得
	 * @return 借款人机构名称
	 */
	public String getLpduserorgname() {
		return lpduserorgname;
	}

	/**
	 * 借款人机构名称设定
	 * @param lpduserorgname 借款人机构名称
	 */
	public void setLpduserorgname(String lpduserorgname) {
		this.lpduserorgname = lpduserorgname;
	}

	/**
	 * 接待ID取得
	 * @return 接待ID
	 */
	public Integer getRid() {
		return rid;
	}

	/**
	 * 接待ID设定
	 * @param rid 接待ID
	 */
	public void setRid(Integer rid) {
		this.rid = rid;
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

	public BigDecimal getLpdactinvoice() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdactuser() {
		// TODO Auto-generated method stub
		return null;
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
	
	/**
	 * 可用金额取得
	 * @return 可用金额
	 */
	public BigDecimal getAvailableAmount() {
		return availableAmount;
	}

	/**
	 * 可用金额设定
	 * @param availableAmount 可用金额
	 */
	public void setAvailableAmount(BigDecimal availableAmount) {
		this.availableAmount = availableAmount;
	}
	
}
