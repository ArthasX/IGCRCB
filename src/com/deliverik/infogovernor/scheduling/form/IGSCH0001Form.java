package com.deliverik.infogovernor.scheduling.form;

import com.deliverik.framework.base.BaseForm;

public class IGSCH0001Form extends BaseForm {

	private static final long serialVersionUID = 1L;

	private String forward;
	private int year;
	private int month;

	public String getForward() {
		return forward;
	}

	public void setForward(String forward) {
		this.forward = forward;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

}
