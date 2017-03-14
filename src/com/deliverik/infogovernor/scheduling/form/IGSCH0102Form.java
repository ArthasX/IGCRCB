package com.deliverik.infogovernor.scheduling.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;



@SuppressWarnings("serial")
public class IGSCH0102Form extends BaseForm implements QuartzJobs {
	
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
	protected String qjcrtusername;
	protected String qjimplusername;
	protected String qjperiodinfo;
	protected String qjorgid;
	protected String qjorgname;
	protected String qjassetid;
	protected String qjassettypeid;
	
	protected String qjdtime;
	
	
	
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
	public String getQjorgid() {
		return qjorgid;
	}
	public void setQjorgid(String qjorgid) {
		this.qjorgid = qjorgid;
	}
	public String getQjorgname() {
		return qjorgname;
	}
	public void setQjorgname(String qjorgname) {
		this.qjorgname = qjorgname;
	}
	
	protected String fingerPrint;

	public String getFingerPrint() {
		return fingerPrint;
	}

	public void setFingerPrint(String fingerPrint) {
		this.fingerPrint = fingerPrint;
	}
	public String getQjdtime() {
		return qjdtime;
	}
	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}
}
