package com.deliverik.infogovernor.scheduling.model.condition;

public class QuartzJobsSearchCondImpl implements QuartzJobsSearchCond {

	private String qjtype;

	private String qjstatus;

	private String qjcrtuser;
	
	private String qjimpluser;
	
	private String qjname;
	
	private String qjtriname;
	
	private String startTime;
	
    private String endTime;
	
	private Integer qjid;
	
	private String qjcrtusername;
	
	private String qjimplusername;
	
	private String qjassetid;
	
	private String qjassettypeid;
	
	private String qjtype_q;
	
	private String date_q;
	
	private String date_j;
	
	private String date;
	
	private String ymonth_q;

	private String userid;
	
	public String getQjtype_q() {
		return qjtype_q;
	}

	public void setQjtype_q(String qjtype_q) {
		this.qjtype_q = qjtype_q;
	}

	public String getQjcrtusername() {
		return qjcrtusername;
	}

	public void setQjcrtusername(String qjcrtusername) {
		this.qjcrtusername = qjcrtusername;
	}

	public String getQjimplusername() {
		return qjimplusername;
	}

	public void setQjimplusername(String qjimplusername) {
		this.qjimplusername = qjimplusername;
	}

	public Integer getQjid() {
		return qjid;
	}

	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getQjtriname() {
		return qjtriname;
	}

	public void setQjtriname(String qjtriname) {
		this.qjtriname = qjtriname;
	}

	public String getQjtype() {
		return qjtype;
	}

	public void setQjtype(String qjtype) {
		this.qjtype = qjtype;
	}

	public String getQjstatus() {
		return qjstatus;
	}

	public void setQjstatus(String qjstatus) {
		this.qjstatus = qjstatus;
	}

	public String getQjcrtuser() {
		return qjcrtuser;
	}

	public void setQjcrtuser(String qjcrtuser) {
		this.qjcrtuser = qjcrtuser;
	}

	public String getQjimpluser() {
		return qjimpluser;
	}

	public void setQjimpluser(String qjimpluser) {
		this.qjimpluser = qjimpluser;
	}

	public String getQjname() {
		return qjname;
	}

	public void setQjname(String qjname) {
		this.qjname = qjname;
	}

	public String getQjassetid() {
		return qjassetid;
	}

	public void setQjassetid(String qjassetid) {
		this.qjassetid = qjassetid;
	}

	public String getQjassettypeid() {
		return qjassettypeid;
	}

	public void setQjassettypeid(String qjassettypeid) {
		this.qjassettypeid = qjassettypeid;
	}

	public String getDate_q() {
		return date_q;
	}

	public void setDate_q(String date_q) {
		this.date_q = date_q;
	}

	public String getYmonth_q() {
		return ymonth_q;
	}

	public void setYmonth_q(String ymonth_q) {
		this.ymonth_q = ymonth_q;
	}

	public String getDate_j() {
		return date_j;
	}

	public void setDate_j(String date_j) {
		this.date_j = date_j;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}