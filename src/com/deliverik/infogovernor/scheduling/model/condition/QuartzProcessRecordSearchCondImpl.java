package com.deliverik.infogovernor.scheduling.model.condition;

public class QuartzProcessRecordSearchCondImpl implements QuartzProcessRecordSearchCond {

	protected String qprtitle;
	
	protected String qprtype;
	
	protected String qprstatus;
	
	protected Integer qprid;
	
	protected String qpcode;
	
	protected String qprusername;
	
	protected String qprurgency;
	
	protected String qpropentime;
	
	protected String qprclosetime;

	public String getQprtitle() {
		return qprtitle;
	}

	public void setQprtitle(String qprtitle) {
		this.qprtitle = qprtitle;
	}

	public String getQprtype() {
		return qprtype;
	}

	public void setQprtype(String qprtype) {
		this.qprtype = qprtype;
	}

	public String getQprstatus() {
		return qprstatus;
	}

	public void setQprstatus(String qprstatus) {
		this.qprstatus = qprstatus;
	}

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public String getQpcode() {
		return qpcode;
	}

	public void setQpcode(String qpcode) {
		this.qpcode = qpcode;
	}

	public String getQprusername() {
		return qprusername;
	}

	public void setQprusername(String qprusername) {
		this.qprusername = qprusername;
	}

	public String getQprurgency() {
		return qprurgency;
	}

	public void setQprurgency(String qprurgency) {
		this.qprurgency = qprurgency;
	}

	public String getQpropentime() {
		return qpropentime;
	}

	public void setQpropentime(String qpropentime) {
		this.qpropentime = qpropentime;
	}

	public String getQprclosetime() {
		return qprclosetime;
	}

	public void setQprclosetime(String qprclosetime) {
		this.qprclosetime = qprclosetime;
	}

}
