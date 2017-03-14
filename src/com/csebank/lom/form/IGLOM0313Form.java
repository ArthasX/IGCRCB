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
 * 还款登记Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0313Form extends BaseForm  implements LoanPayDetail{

	/** 借款ID */
	protected Integer ldid;
	
	/** 借款ID */
	protected Integer lpdid;
	
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
	
	/** 还款日期 */
	protected String lpddate;
	
	/** 还款人 */
	protected String lpduser;
	
	/** 还款方式 */
	protected String lpdtype;
	
	/** 还款金额 */
	protected BigDecimal lpdamount;
	
	/** 还款状态 4 */
	protected String lpdstatus;
	
	/** 还款人机构层次码 */
	protected String lpduserorg;
	
	/** 还款人机构 */
	protected String lpduserorgname;
	
	/** 实际发票金额 */
	protected BigDecimal lpdactinvoice;
	
	/** 实际还款人 */
	protected String lpdactuser;
	
	/** 删除还款发票对象 */
	protected String[] deleteLpdid;
	
	/** 借还款时间 */
	public String lpdtime;


	/**
	 * 借款ID取得
	 * @return 借款ID
	 */
	public Integer getLdid() {
		return ldid;
	}

	/**
	 * 借款ID设定
	 * @param lpdid 借款ID
	 */
	public void setLdid(Integer ldid) {
		this.ldid = ldid;
	}

	public String getLpdtype_q() {
		return null;
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
	 * 发票单位取得
	 * @return 发票单位
	 */
	public String getLpdinvoicecor() {
		return lpdinvoicecor;
	}

	/**
	 * 发票单位设定
	 * @param lpdinvoicecor 发票单位
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
	 * 还款日期取得
	 * @return 还款日期
	 */
	public String getLpddate() {
		return lpddate;
	}

	/**
	 * 还款日期设定
	 * @param lpddate 还款日期
	 */
	public void setLpddate(String lpddate) {
		this.lpddate = lpddate;
	}

	/**
	 * 还款人取得
	 * @return 还款人
	 */
	public String getLpduser() {
		return lpduser;
	}

	/**
	 * 还款人设定
	 * @param lpduser 还款人
	 */
	public void setLpduser(String lpduser) {
		this.lpduser = lpduser;
	}

	/**
	 * 还款方式取得
	 * @return 还款方式
	 */
	public String getLpdtype() {
		return lpdtype;
	}

	/**
	 * 还款方式设定
	 * @param lpdtype 还款方式
	 */
	public void setLpdtype(String lpdtype) {
		this.lpdtype = lpdtype;
	}

	/**
	 * 还款金额取得
	 * @return 还款金额
	 */
	public BigDecimal getLpdamount() {
		return lpdamount;
	}

	/**
	 * 还款金额设定
	 * @param lpdamount 还款金额
	 */
	public void setLpdamount(BigDecimal lpdamount) {
		this.lpdamount = lpdamount;
	}

	/**
	 * 还款状态取得
	 * @return 还款状态
	 */
	public String getLpdstatus() {
		return lpdstatus;
	}

	/**
	 * 还款状态设定
	 * @param lpdstatus 还款状态
	 */
	public void setLpdstatus(String lpdstatus) {
		this.lpdstatus = lpdstatus;
	}

	/**
	 * 还款人机构层次码取得
	 * @return 还款人机构层次码
	 */
	public String getLpduserorg() {
		return lpduserorg;
	}

	/**
	 * 还款人机构层次码设定
	 * @param lpduserorg 还款人机构层次码
	 */
	public void setLpduserorg(String lpduserorg) {
		this.lpduserorg = lpduserorg;
	}

	/**
	 * 还款人机构名称取得
	 * @return 还款人机构名称
	 */
	public String getLpduserorgname() {
		return lpduserorgname;
	}

	/**
	 * 还款人机构名称设定
	 * @param lpduserorgname 还款人机构名称
	 */
	public void setLpduserorgname(String lpduserorgname) {
		this.lpduserorgname = lpduserorgname;
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
	 * 删除还款发票对象取得
	 * @return 删除还款发票对象
	 */
	public String[] getDeleteLpdid() {
		return deleteLpdid;
	}

	/**
	 * 删除还款发票对象设定
	 * @param deleteLpdid 删除还款发票对象
	 */
	public void setDeleteLpdid(String[] deleteLpdid) {
		this.deleteLpdid = deleteLpdid;
	}

	public Integer getAcid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getLpdcomment() {
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

	public BigDecimal getLpdstockamount() {
		// TODO Auto-generated method stub
		return null;
	}

	public OrganizationTB getOrganizationTB() {
		// TODO Auto-generated method stub
		return null;
	}

	public Integer getRid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 还款Id取得
	 * @return 还款Id
	 */
	public Integer getLpdid() {
		return lpdid;
	}

	/**
	 * 还款Id设定
	 * @param lpdid 还款Id
	 */
	public void setLpdid(Integer lpdid) {
		this.lpdid = lpdid;
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
