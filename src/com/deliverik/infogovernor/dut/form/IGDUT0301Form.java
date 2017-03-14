package com.deliverik.infogovernor.dut.form;

import com.deliverik.framework.base.BaseForm;

public class IGDUT0301Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private Integer showYear;
	private Integer showMonth;
	private String forward;
	private String dadcategory;
	
	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public Integer getShowYear() {
		return showYear;
	}

	public void setShowYear(Integer showYear) {
		this.showYear = showYear;
	}

	public Integer getShowMonth() {
		return showMonth;
	}

	public void setShowMonth(Integer showMonth) {
		this.showMonth = showMonth;
	}

}
