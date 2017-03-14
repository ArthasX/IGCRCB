package com.csebank.lom.model.condition;

public class InvoiceInfoSearchCondImpl implements InvoiceInfoSearchCond {

	/**
	 * 发票类型
	 */
	protected String itype;
	
	/**
	 * 申请部门层次码
	 */
	protected String ireqemp;
	
	/**
	 * 申请人ID
	 */
	protected String irequser;
	
	/**
	 * 开票开始时间
	 */
	protected String idate_from;
	
	/**
	 * 开票结束时间
	 */
	protected String idate_to;
	
	/**
	 * 金额
	 */
	protected String iamount;
	
	/**
	 * 状态
	 */
	protected String istatus;
	
	/**
	 * 按年统计 
	 */
	protected String iyear;

	/**
	 * 申请人ID
	 */
    protected String ireqempid;
	
	/** 
	 * 申请人姓名
	 */
	protected String irequsername;
	
	/** 资产项所属机构*/
	public String eiorgsyscoding;
	
	public String getIreqempid() {
		return ireqempid;
	}

	public void setIreqempid(String ireqempid) {
		this.ireqempid = ireqempid;
	}
	
	public String getIyear() {
		return iyear;
	}
	
	public void setIyear(String iyear) {
		this.iyear = iyear;
	}

	public String getItype() {
		return itype;
	}

	public void setItpye(String itype) {
		this.itype = itype;
	}

	public String getIreqemp() {
		return ireqemp;
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

	public String getIamount() {
		return iamount;
	}

	public void setIamount(String iamount) {
		this.iamount = iamount;
	}

	public String getIstatus() {
		return istatus;
	}

	public void setIstatus(String istatus) {
		this.istatus = istatus;
	}

	public String getIrequsername() {
		return irequsername;
	}

	public void setIrequsername(String irequsername) {
		this.irequsername = irequsername;
	}


	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}

}
