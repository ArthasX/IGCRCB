package com.deliverik.infogovernor.scheduling.model.condition;

public class QuartzProcessParticipantSearchCondImpl implements QuartzProcessParticipantSearchCond {
	
	protected Integer qprid;
	
	protected Integer qpproleid;
	
	protected String qppuserid;
	
	protected String qppinittime;
	
	protected String qppproctime;
	
	protected String qppstatus;
	
	protected String qppuseridIsNull;
	
	protected String qppproctimeIsNull;

	public Integer getQprid() {
		return qprid;
	}

	public void setQprid(Integer qprid) {
		this.qprid = qprid;
	}

	public Integer getQpproleid() {
		return qpproleid;
	}

	public void setQpproleid(Integer qpproleid) {
		this.qpproleid = qpproleid;
	}

	public String getQppuserid() {
		return qppuserid;
	}

	public void setQppuserid(String qppuserid) {
		this.qppuserid = qppuserid;
	}

	public String getQppinittime() {
		return qppinittime;
	}

	public void setQppinittime(String qppinittime) {
		this.qppinittime = qppinittime;
	}

	public String getQppproctime() {
		return qppproctime;
	}

	public void setQppproctime(String qppproctime) {
		this.qppproctime = qppproctime;
	}

	public String getQppstatus() {
		return qppstatus;
	}

	public void setQppstatus(String qppstatus) {
		this.qppstatus = qppstatus;
	}

	public String getQppuseridIsNull() {
		return qppuseridIsNull;
	}

	public void setQppuseridIsNull(String qppuseridIsNull) {
		this.qppuseridIsNull = qppuseridIsNull;
	}

	public String getQppproctimeIsNull() {
		return qppproctimeIsNull;
	}

	public void setQppproctimeIsNull(String qppproctimeIsNull) {
		this.qppproctimeIsNull = qppproctimeIsNull;
	}

}
