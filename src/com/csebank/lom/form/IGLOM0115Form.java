/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import java.math.BigDecimal;

import com.csebank.lom.model.Deal;
import com.deliverik.framework.base.BaseForm;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 * ˵��������Ͳ͵Ǽ�form
 * ���ߣ������� mail to tangxiaona@deliverik.com
 *
 */
public class IGLOM0115Form extends BaseForm implements Deal {
	
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * ҳ�������ʾ��־0-����,1-���
	 */
	protected Integer rid;
	public Integer getRid() {
		return rid;
	}
	public void setRid(Integer rid) {
		this.rid = rid;
	}
	protected String mode = "0";
	protected String rstatus;//��ǰ״̬
	protected String rapporgid;//���벿�Ų㼶��

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
	protected OrganizationTB organizationTB;//������Ϣʵ��
	public OrganizationTB getOrganizationTB() {
		return organizationTB;
	}
	public void setOrganizationTB(OrganizationTB organizationTB) {
		this.organizationTB = organizationTB;
	}
	protected String deptName;//��������
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	protected String dealTime;//����ʱ��
	public String getDealTime() {
		return dealTime;
	}
	public void setDealTime(String dealTime) {
		this.dealTime = dealTime;
	}
	protected String dealScale;//�ò�������ģ
	public String getDealScale() {
		return dealScale;
	}
	public void setDealScale(String dealScale) {
		this.dealScale = dealScale;
	}
	protected BigDecimal dealCash;//�����òͽ��
	public BigDecimal getDealCash() {
		return dealCash;
	}
	public void setDealCash(BigDecimal dealCash) {
		this.dealCash = dealCash;
	}
	protected String invoiceNumber;//��Ʊ���
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	protected String otherJoiner;//����������
	public String getOtherJoiner() {
		return otherJoiner;
	}
	public void setOtherJoiner(String otherJoiner) {
		this.otherJoiner = otherJoiner;
	}
	protected String dealDesc;//��������
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
