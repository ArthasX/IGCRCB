/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.InvoiceInfoSearchCond;
import com.deliverik.framework.base.BaseForm;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发票统计Form
 * </p>
 * 
 * @author piaowei@deliverik.com
 * @version 1.0
 */

@SuppressWarnings("serial")
public class IGLOM0405Form extends BaseForm implements InvoiceInfoSearchCond{

	/** 发票类型 */
	protected String itype;
	
	/** 开票开始日期 */
	protected String idate_from;
	
	/** 开票结束日期 */
	protected String idate_to;
	
	/** 申请部门层次码 */
	protected String ireqemp;
	
	/** 申请人id */
	protected String irequser;
	
	/** 金额*/
	protected String iamount;
	
	/** 状态(0: 未付款 1:已付款) */
	protected String istatus;
	
	/**按部门查询  */
	protected String searchbyemp;
	
	/**统计序号  */
	protected String num;
	
	/**统计发票比数  */
	protected String invoicenum;
	
	/**统计总金额  */
	protected String sumiamount;
	
	/**统计已付款金额  */
	protected String sumiamounted;
	
	/**统计未付款金额 */
	protected String unsumiamounted;
	
	/**统计按年统计 */
	protected String iyear; 
	
	/** 资产项所属机构名称*/
    protected String eiorgname;

    /** 资产项所属机构*/
	public String eiorgsyscoding;
	
	public String getIyear() {
		return iyear;
	}

	public void setIyear(String iyear) {
		this.iyear = iyear;
	}

	public String getSearchbyemp() {
		return searchbyemp;
	}

	public void setSearchbyemp(String searchbyemp) {
		this.searchbyemp = searchbyemp;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getInvoicenum() {
		return invoicenum;
	}

	public void setInvoicenum(String invoicenum) {
		this.invoicenum = invoicenum;
	}

	public String getSumiamount() {
		return sumiamount;
	}

	public void setSumiamount(String sumiamount) {
		this.sumiamount = sumiamount;
	}

	public String getSumiamounted() {
		return sumiamounted;
	}

	public void setSumiamounted(String sumiamounted) {
		this.sumiamounted = sumiamounted;
	}

	public String getUnsumiamounted() {
		return unsumiamounted;
	}

	public void setUnsumiamounted(String unsumiamounted) {
		this.unsumiamounted = unsumiamounted;
	}

	public String getSearchByEmp() {
		return searchbyemp;
	}
	
	public void setSearchByEmp(String searchbyemp) {
		this.searchbyemp = searchbyemp;
	}

	public String getItype() {
		return itype;
	}

	public void setItype(String itype) {
		this.itype = itype;
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

	public String getIreqempid() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getIrequsername() {
		// TODO Auto-generated method stub
		return null;
	}
    
	public String getEiorgname() {
		return eiorgname;
	}

	public void setEiorgname(String eiorgname) {
		this.eiorgname = eiorgname;
	}
	
	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
}
