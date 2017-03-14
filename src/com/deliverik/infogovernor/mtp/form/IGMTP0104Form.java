package com.deliverik.infogovernor.mtp.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.scheduling.model.condition.QuartzJobsSearchCond;

@SuppressWarnings("serial")
public class IGMTP0104Form extends BaseForm implements QuartzJobsSearchCond {
	
	protected Integer qjid;
	protected String qjname;
	protected String qjdesc;
	protected String qjtriname;
	protected String qjtrigrp;
	protected String qjcrtuser;
	protected String qjimpluser;
	protected String qjcrttime;
	protected String qjendtime;
	protected String qjtype;
	protected String qjstatus;
	protected String qjinfo;
	protected String qjtricron;
	protected String qjperiodinfo;
	
	protected String startTime;
	protected String endTime;
	
	protected String periodType;
	protected String CustomDate;
	protected String exeHour;
	protected String exeMinute;

	protected String qjcrtusername;
	protected String qjimplusername;
	
	protected String qjtype_q;
	protected String pagetype;
	
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
	public String getQjperiodinfo() {
		return qjperiodinfo;
	}
	public void setQjperiodinfo(String qjperiodinfo) {
		this.qjperiodinfo = qjperiodinfo;
	}
	public String getPeriodType() {
		return periodType;
	}
	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}
	public String getCustomDate() {
		return CustomDate;
	}
	public void setCustomDate(String customDate) {
		CustomDate = customDate;
	}
	public String getExeHour() {
		return exeHour;
	}
	public void setExeHour(String exeHour) {
		this.exeHour = exeHour;
	}
	public String getExeMinute() {
		return exeMinute;
	}
	public void setExeMinute(String exeMinute) {
		this.exeMinute = exeMinute;
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
	public Integer getQjid() {
		return qjid;
	}
	public void setQjid(Integer qjid) {
		this.qjid = qjid;
	}
	public String getQjname() {
		return qjname;
	}
	public void setQjname(String qjname) {
		this.qjname = qjname;
	}
	public String getQjdesc() {
		return qjdesc;
	}
	public void setQjdesc(String qjdesc) {
		this.qjdesc = qjdesc;
	}
	public String getQjtriname() {
		return qjtriname;
	}
	public void setQjtriname(String qjtriname) {
		this.qjtriname = qjtriname;
	}
	public String getQjtrigrp() {
		return qjtrigrp;
	}
	public void setQjtrigrp(String qjtrigrp) {
		this.qjtrigrp = qjtrigrp;
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
	public String getQjcrttime() {
		return qjcrttime;
	}
	public void setQjcrttime(String qjcrttime) {
		this.qjcrttime = qjcrttime;
	}
	public String getQjendtime() {
		return qjendtime;
	}
	public void setQjendtime(String qjendtime) {
		this.qjendtime = qjendtime;
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
	public String getQjinfo() {
		return qjinfo;
	}
	public void setQjinfo(String qjinfo) {
		this.qjinfo = qjinfo;
	}
	public String getQjtricron() {
		return qjtricron;
	}
	public void setQjtricron(String qjtricron) {
		this.qjtricron = qjtricron;
	}
	
	public String getQjassetid() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getQjassettypeid() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getPagetype() {
		return pagetype;
	}
	public void setPagetype(String pagetype) {
		this.pagetype = pagetype;
	}
	public String getDate_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getYmonth_q() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDate_j() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getDate() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
}
