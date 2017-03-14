/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Deal;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * 说明：外出就餐登记form
 * 作者：唐晓娜 mail to tangxiaona@deliverik.com
 *
 */
public class IGLOM0115Form extends BaseForm implements Deal {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * 页面标题显示标志0-新增,1-变更
	 */
	protected Integer rid;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	protected String mode = "0";
	protected String rstatus;//当前状态
	protected String rapporgid;//申请部门层级码

	public String getRapporgid() {
		return rapporgid;
	}
	public void setRapporgid(String rapporgid) {
		this.rapporgid = rapporgid;
	}
	public String getRstatus() {
		return rstatus;
	}
	public void setRstatus(String rstatus) {
		this.rstatus = rstatus;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	protected OrganizationTB organizationTB;//机构信息实体
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	protected String deptName;//申请名称
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	protected String dealTime;//申请时间
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	protected String dealScale;//用餐人数规模
	public String getDealScale() {
		return dealScale;
	}
	public void setDealScale(String dealScale) {
		this.dealScale = dealScale;
	}
	protected BigDecimal dealCash;//申请用餐金额
	public BigDecimal getDealCash() {
		return dealCash;
	}
	public void setDealCash(BigDecimal dealCash) {
		this.dealCash = dealCash;
	}
	protected String invoiceNumber;//发票编号
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	protected String otherJoiner;//其他参与者
	public String getOtherJoiner() {
		return otherJoiner;
	}
	public void setOtherJoiner(String otherJoiner) {
		this.otherJoiner = otherJoiner;
	}
	protected String dealDesc;//其他描述
	public String getDealDesc() {
		return dealDesc;
	}
	public void setDealDesc(String dealDesc) {
		this.dealDesc = dealDesc;
	}
	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	

}
