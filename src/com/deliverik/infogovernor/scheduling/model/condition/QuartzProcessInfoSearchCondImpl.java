package com.deliverik.infogovernor.scheduling.model.condition;

public class QuartzProcessInfoSearchCondImpl implements QuartzProcessInfoSearchCond {

	protected Integer qprid;
	
	protected String qpivarname;

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public String getQpivarname() {
		return qpivarname;
	}

	public void setQpivarname(String qpivarname) {
		this.qpivarname = qpivarname;
	}

}
