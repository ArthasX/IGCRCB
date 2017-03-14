/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.form;

import com.csebank.lom.model.condition.AdvancesummaryCond;
import com.deliverik.framework.base.BaseForm;

public class IGLOM0309Form extends BaseForm implements AdvancesummaryCond{

	private static final long serialVersionUID = 1L;
	
	/** 用于查询年 */
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
	 * 用于查询年取得
	 * @return 用于查询年
	 */
	public String getYear() {
		return year;
	}

	/**
	 * 用于查询年设定
	 * @param year 用于查询年
	 */
	public void setYear(String year) {
		this.year = year;
	}
	

}
