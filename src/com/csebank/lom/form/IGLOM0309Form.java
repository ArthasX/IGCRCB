/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0309Form extends BaseForm implements AdvancesummaryCond{

	private static final long serialVersionUID = 1L;
	
	/** ���ڲ�ѯ�� */
	protected String year;
	
	protected String asyear;
	
	protected String asmonth;
	
	protected String asprebalance;
	
	protected String asadvancescost;
	
	protected String asloan;
	
	protected String asinvoice;
	
	protected String aspay;
	
	protected String asbalance;
	
	protected String asfreeze;
	


	public String getAsyear() {
		return asyear;
	}

	public void setAsyear(String asyear) {
		this.asyear = asyear;
	}

	public String getAsmonth() {
		return asmonth;
	}

	public void setAsmonth(String asmonth) {
		this.asmonth = asmonth;
	}

	public String getAsprebalance() {
		return asprebalance;
	}

	public void setAsprebalance(String asprebalance) {
		this.asprebalance = asprebalance;
	}

	public String getAsadvancescost() {
		return asadvancescost;
	}

	public void setAsadvancescost(String asadvancescost) {
		this.asadvancescost = asadvancescost;
	}

	public String getAsloan() {
		return asloan;
	}

	public void setAsloan(String asloan) {
		this.asloan = asloan;
	}

	public String getAsinvoice() {
		return asinvoice;
	}

	public void setAsinvoice(String asinvoice) {
		this.asinvoice = asinvoice;
	}

	public String getAspay() {
		return aspay;
	}

	public void setAspay(String aspay) {
		this.aspay = aspay;
	}

	public String getAsbalance() {
		return asbalance;
	}

	public void setAsbalance(String asbalance) {
		this.asbalance = asbalance;
	}

	public String getAsfreeze() {
		return asfreeze;
	}

	public void setAsfreeze(String asfreeze) {
		this.asfreeze = asfreeze;
	}

	/**
	 * ���ڲ�ѯ��ȡ��
	 * @return ���ڲ�ѯ��
	 */
	public String getYear() {
		return year;
	}

	/**
	 * ���ڲ�ѯ���趨
	 * @param year ���ڲ�ѯ��
	 */
	public void setYear(String year) {
		this.year = year;
	}
	

}
