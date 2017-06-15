/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.AdvanCescost;
import com.deliverik.framework.base.BaseForm;

/**
 * 
 * 接待工作登记变更Form
 *
 */
@SuppressWarnings("serial")
public class IGLOM0301Form extends BaseForm  implements AdvanCescost {

	/** 预支费用ID */
	protected Integer acid;
	
	/** 预支金额 */
	protected BigDecimal acamount;
	
	/** 计财记帐日期 */
	protected String acdate;
	
	/** 预支方式 */
	protected String actype;
	
	/** 支票号 */
	protected String acchequenum;
	
	/** 预支审批号 */
	protected String acserial;
	
	/** 预支主要用途说明 */
	protected String accomment;
	
	/** 预支状态 */
	protected String acstatus;
	
	/** 还款现金金额 */
	protected BigDecimal acfreezeamount;
	
	/** 还款发票金额 */
	protected BigDecimal acinvoiceamount;
	
	/** 库存金额 */
	protected BigDecimal acstockamount;
	
	/** 预支冲抵日期 */
	protected String accreditdate;
	
	/** 预支登记日期 */
	protected String acinsdate;
	
	/** 编辑标识 */
	protected String mode = "0";
	
	/** 登记人ID */
	protected String acuserid;
	
	/** 登记人姓名 */
	protected String acusername;
	
	/** 预支登记时间 */
	protected String acinstime;
	
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
	 * 预支金额取得
	 * @return 预支金额
	 */
	public BigDecimal getAcamount() {
		return acamount;
	}

	/**
	 * 预支金额设定
	 * @param acamount 预支金额
	 */
	public void setAcamount(BigDecimal acamount) {
		this.acamount = acamount;
	}

	/**
	 * 计财记帐日期取得
	 * @return 计财记帐日期
	 */
	public String getAcdate() {
		return acdate;
	}

	/**
	 * 计财记帐日期设定
	 * @param acdate 计财记帐日期
	 */
	public void setAcdate(String acdate) {
		this.acdate = acdate;
	}

	/**
	 * 预支方式取得
	 * @return 预支方式
	 */
	public String getActype() {
		return actype;
	}
	
	/**
	 * 预支方式设定
	 * @param actype 预支方式
	 */
	public void setActype(String actype) {
		this.actype = actype;
	}

	/**
	 * 支票号取得
	 * @return 支票号
	 */
	public String getAcchequenum() {
		return acchequenum;
	}

	/**
	 * 支票号设定
	 * @param acchequenum 支票号
	 */
	public void setAcchequenum(String acchequenum) {
		this.acchequenum = acchequenum;
	}

	/**
	 * 预支审批号取得
	 * @return 预支审批号
	 */
	public String getAcserial() {
		return acserial;
	}

	/**
	 * 预支审批号设定
	 * @param acserial 预支审批号
	 */
	public void setAcserial(String acserial) {
		this.acserial = acserial;
	}

	/**
	 * 预支主要用途说明取得
	 * @return 预支主要用途说明
	 */
	public String getAccomment() {
		return accomment;
	}

	/**
	 * 预支主要用途说明设定
	 * @param accomment 预支主要用途说明
	 */
	public void setAccomment(String accomment) {
		this.accomment = accomment;
	}

	/**
	 * 预支状态取得
	 * @return 预支状态
	 */
	public String getAcstatus() {
		return acstatus;
	}

	/**
	 * 预支费用ID设定
	 * @param acdate 预支费用ID
	 */
	public void setAcstatus(String acstatus) {
		this.acstatus = acstatus;
	}

	/**
	 * 还款现金金额取得
	 * @return 还款现金金额
	 */
	public BigDecimal getAcfreezeamount() {
		return acfreezeamount;
	}

	/**
	 * 还款现金金额设定
	 * @param acfreezeamount 还款现金金额
	 */
	public void setAcfreezeamount(BigDecimal acfreezeamount) {
		this.acfreezeamount = acfreezeamount;
	}
	
	/**
	 * 还款发票金额取得
	 * @return 还款发票金额
	 */
	public BigDecimal getAcinvoiceamount() {
		return acinvoiceamount;
	}

	/**
	 * 还款发票金额设定
	 * @param acinvoiceamount 还款发票金额
	 */
	public void setAcinvoiceamount(BigDecimal acinvoiceamount) {
		this.acinvoiceamount = acinvoiceamount;
	}
	
	/**
	 * 预支冲抵时间取得
	 * @return 预支冲抵时间
	 */
	public String getAccreditdate() {
		return accreditdate;
	}

	/**
	 * 预支冲抵时间设定
	 * @param accreditdate 预支冲抵时间
	 */
	public void setAccreditdate(String accreditdate) {
		this.accreditdate = accreditdate;
	}

	/**
	 * 预支登记时间取得
	 * @return 预支登记时间
	 */
	public String getAcinsdate() {
		return acinsdate;
	}

	/**
	 * 预支登记时间设定
	 * @param acinsdate 预支登记时间
	 */
	public void setAcinsdate(String acinsdate) {
		this.acinsdate = acinsdate;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}

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
	 * 库存金额取得
	 * @return 库存金额
	 */
	public BigDecimal getAcstockamount() {
		return acstockamount;
	}

	/**
	 * 库存金额取得
	 * @return 库存金额
	 */
	public void setAcstockamount(BigDecimal acstockamount) {
		this.acstockamount = acstockamount;
	}
	
	/**
	 * 登记人ID取得
	 * @return 登记人ID
	 */
	public String getAcuserid() {
		return acuserid;
	}

	/**
	 * 登记人ID设定
	 * @param acuserid 登记人ID
	 */
	public void setAcuserid(String acuserid) {
		this.acuserid = acuserid;
	}

	/**
	 * 登记人姓名取得
	 * @return 登记人姓名
	 */
	public String getAcusername() {
		return acusername;
	}

	/**
	 * 登记人姓名设定
	 * @param acusername 登记人姓名
	 */
	public void setAcusername(String acusername) {
		this.acusername = acusername;
	}
	
	/**
	 * 预支登记时间取得
	 * @return 预支登记时间
	 */
	public String getAcinstime() {
		return acinstime;
	}

	/**
	 * 预支登记时间设定
	 * @param acinstime 预支登记时间
	 */
	public void setAcinstime(String acinstime) {
		this.acinstime = acinstime;
	}
	
}
