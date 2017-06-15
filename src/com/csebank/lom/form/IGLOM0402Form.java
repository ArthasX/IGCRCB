/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.base.BaseForm;


/**
 * 
 * 支票登记变更Form
 *
 */
public class IGLOM0402Form extends BaseForm implements InvoiceInfoSearchCond{


	
	private static final long serialVersionUID = 1L;

	//protected Integer iid;

	/** 发票类型 */
	protected String itype;
	
	/** 开票日期 */
	protected String idate;
	
	/** 发票号码 */
	protected String inum;
	
	/** 金额*/
	protected String iamount;

	/** 用途说明描述 */
	protected String icomment;
	
	/** 合同编号 */
	protected String icontractserial;
	
	/** 合同名称 */
	protected String icontractname;
	
	/** 收款单位名称 */
	protected String icorporation;
	
	/** 开户银行 */
	protected String ibank;
	
	/** 账号 */
	protected String iaccount;
	
	/** 申请部门层次码 */
	protected String ireqemp;
	
	/** 申请人id */
	protected String irequser;
	
	/** 申请人姓名 */
	protected String irequsername;
	
	/** 状态(0: 未付款 1:已付款) */
	protected String istatus;
	
	/** 付款方式 */
	protected String ipaymenttype;
	
	/** 付款方式号码 */
	protected String ipaymenttypecode;
	
	
	/** 付款日期 */
	protected String ipaymentdate;
	
	/** 记录版本标识 */
	protected String fingerprint;
	
	/** 登记日期 */
	protected String rdate;  
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected String mode="0";
	
	/** 开票开始日期 */
	protected String idate_from;
	
	/** 开票结束日期 */
	protected String idate_to;
	
	/** 主键数组 */
	protected String[] iid;
	
	/** 按部门查询  */
	protected String searchbyemp;

	/**  */
	protected String ireqempid;

	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	public String getIreqempid() {
		return ireqempid;
	}

	public void setIreqempid(String ireqempid) {
		this.ireqempid = ireqempid;
	}



	public String getSearchByEmp() {
		return searchbyemp;
	}
	
	public void setSearchByEmp(String searchbyemp) {
		this.searchbyemp = searchbyemp;
	}

	public String getIdate_from() {
		return idate_from;
	}

	public void setIdate_from(String idate_from) {
		this.idate_from = idate_from;
	}

	public String getIdate_to() {
		return idate_to;
	}

	public void setIdate_to(String idate_to) {
		this.idate_to = idate_to;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

//	public Integer getIid() {
//		return iid;
//	}
//
//	public void setIid(Integer iid) {
//		this.iid = iid;
//	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
	}

	public String getIdate() {
		return idate;
	}

	public void setIdate(String idate) {
		this.idate = idate;
	}

	public String getInum() {
		return inum;
	}

	public void setInum(String inum) {
		this.inum = inum;
	}

	public String getIamount() {
		return iamount;
	}

	public void setIamount(String iamount) {
		this.iamount = iamount;
	}

	public String getIcomment() {
		return icomment;
	}

	public void setIcomment(String icomment) {
		this.icomment = icomment;
	}

	public String getIcontractserial() {
		return icontractserial;
	}

	public void setIcontractserial(String icontractserial) {
		this.icontractserial = icontractserial;
	}

	public String getIcontractname() {
		return icontractname;
	}

	public void setIcontractname(String icontractname) {
		this.icontractname = icontractname;
	}

	public String getIcorporation() {
		return icorporation;
	}

	public void setIcorporation(String icorporation) {
		this.icorporation = icorporation;
	}

	public String getIbank() {
		return ibank;
	}

	public void setIbank(String ibank) {
		this.ibank = ibank;
	}

	public String getIaccount() {
		return iaccount;
	}

	public void setIaccount(String iaccount) {
		this.iaccount = iaccount;
	}

	public String getIreqemp() {
		return ireqemp;
	}
	
	public String[] getIid() {
		return iid;
	}

	public void setIid(String[] iid) {
		this.iid = iid;
	}

	public void setIreqemp(String ireqemp) {
		this.ireqemp = ireqemp;
	}

	public String getIrequser() {
		return irequser;
	}

	public void setIrequser(String irequser) {
		this.irequser = irequser;
	}

	public String getIrequsername() {
		return irequsername;
	}

	public void setIrequsername(String irequsername) {
		this.irequsername = irequsername;
	}

	public String getIstatus() {
		return istatus;
	}

	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}

	public String getIpaymenttype() {
		return ipaymenttype;
	}

	public void setIpaymenttype(String ipaymenttype) {
		this.ipaymenttype = ipaymenttype;
	}

	public String getIpaymenttypecode() {
		return ipaymenttypecode;
	}

	public void setIpaymenttypecode(String ipaymenttypecode) {
		this.ipaymenttypecode = ipaymenttypecode;
	}

	public String getIpaymentdate() {
		return ipaymentdate;
	}

	public void setIpaymentdate(String ipaymentdate) {
		this.ipaymentdate = ipaymentdate;
	}

	public String getFingerprint() {
		return fingerprint;
	}

	public void setFingerprint(String fingerprint) {
		this.fingerprint = fingerprint;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	/**
	 * 页面标题显示取得
	 * @return 页面标题显示
	 */
	public String getMode() {
		return mode;
	}

	/**
	 * 页面标题显示设定
	 * @param mode 页面标题显示
	 */
	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFingerPrint() {
		
		return fingerprint;
	}

	public String getIyear() {
		// TODO Auto-generated method stub
		return null;
	}

	


	
}
