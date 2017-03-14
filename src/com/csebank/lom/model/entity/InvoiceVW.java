/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */
package com.csebank.lom.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Id;

import com.csebank.lom.model.InvoiceTj;


/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发票统计
 * </p>
 * 
 * @author piaowei@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@javax.persistence.Entity
public class InvoiceVW implements Serializable, Cloneable, InvoiceTj {
    
	/**统计序号  */
	@Id
	protected String num;
	
	/**统计发票比数  */
	protected Integer invoicenum;
	
	/**统计总金额  */
	protected BigDecimal sumiamount;
	
	/**统计已付款金额  */
	protected BigDecimal sumiamounted;
	
	/**统计未付款金额 */
	protected BigDecimal unsumiamounted;
	
	/**统计部门 */
	protected String ireqemp;
	
	/** 资产项所属机构*/
	public String eiorgsyscoding;

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public Integer getInvoicenum() {
		return invoicenum;
	}

	public void setInvoicenum(Integer invoicenum) {
		this.invoicenum = invoicenum;
	}

	public BigDecimal getSumiamount() {
		return sumiamount;
	}

	public void setSumiamount(BigDecimal sumiamount) {
		this.sumiamount = sumiamount;
	}

	public BigDecimal getSumiamounted() {
		return sumiamounted;
	}

	public void setSumiamounted(BigDecimal sumiamounted) {
		this.sumiamounted = sumiamounted;
	}

	public BigDecimal getUnsumiamounted() {
		return unsumiamounted;
	}

	public void setUnsumiamounted(BigDecimal unsumiamounted) {
		this.unsumiamounted = unsumiamounted;
	}

	

	public String getIreqemp() {
		return ireqemp;
	}

	public void setIreqemp(String ireqemp) {
		this.ireqemp = ireqemp;
	}

	public String getEiorgsyscoding() {
		return eiorgsyscoding;
	}

	public void setEiorgsyscoding(String eiorgsyscoding) {
		this.eiorgsyscoding = eiorgsyscoding;
	}
	
}
