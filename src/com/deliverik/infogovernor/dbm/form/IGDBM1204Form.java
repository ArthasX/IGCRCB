package com.deliverik.infogovernor.dbm.form;

import com.deliverik.framework.base.BaseForm;

public class IGDBM1204Form extends BaseForm{
	 private static final long serialVersionUID = 1L;
	public String year;
	public String rcclass;
	public String params;
	public String getRcclass() {
		return rcclass;
	}

	public void setRcclass(String rcclass) {
		this.rcclass = rcclass;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

}
