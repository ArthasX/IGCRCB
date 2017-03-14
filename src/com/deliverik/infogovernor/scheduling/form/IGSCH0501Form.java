package com.deliverik.infogovernor.scheduling.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.scheduling.model.QuartzJobs;

public class IGSCH0501Form extends BaseForm implements QuartzJobs {

	private static final long serialVersionUID = 1L;

	private Integer qjid;
	private String qjname;
	private String qjdesc;
	private String qjtriname;// Trigger名称
	private String qjtrigrp;// Trigger组
	private String qjtricron;// Trigger时间表达式
	private String qjcrtuser;
	private String qjimpluser;
	private String qjcrttime;
	private String qjendtime;
	private String qjtype;
	private String qjstatus;
	private String qjinfo;
	private String date;
	private String type;
	private String qprpdid;
	
	private String qjhour;
	private String qjminute;
	private String periodType;
	private String customDate;
	
	protected String qjcrtusername;
	protected String qjimplusername;
	protected String qjperiodinfo;
	protected String qjorgid;
	protected String qjorgname;
	protected String qjimplrole;
	protected String qjimplrolename;
	protected String qjimplroleid;
	protected String ptsavepg;
	protected String pdname;
	protected String qjassetid;
	protected String qjassetname;
	protected String qjassettypeid;
	protected String qjassettypename;
	
	protected String mode;//变更页面参数
	
	/** 删除资产时pieid计数标识 */
	protected Integer countx;
	
	protected String qjdtime;
	
	public String getQjdtime() {
		return qjdtime;
	}

	public void setQjdtime(String qjdtime) {
		this.qjdtime = qjdtime;
	}
	
	public String getQjimplrole() {
		return qjimplrole;
	}
	public void setQjimplrole(String qjimplrole) {
		this.qjimplrole = qjimplrole;
	}
	public String getQjimplrolename() {
		return qjimplrolename;
	}
	public void setQjimplrolename(String qjimplrolename) {
		this.qjimplrolename = qjimplrolename;
	}
	public String getQjimplroleid() {
		return qjimplroleid;
	}
	public void setQjimplroleid(String qjimplroleid) {
		this.qjimplroleid = qjimplroleid;
	}
	public String getQjassettypename() {
		return qjassettypename;
	}
	public void setQjassettypename(String qjassettypename) {
		this.qjassettypename = qjassettypename;
	}
	public String getQjassetname() {
		return qjassetname;
	}
	public void setQjassetname(String qjassetname) {
		this.qjassetname = qjassetname;
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
	public String getPtsavepg() {
		return ptsavepg;
	}
	public void setPtsavepg(String ptsavepg) {
		this.ptsavepg = ptsavepg;
	}
	public String getPdname() {
		return pdname;
	}
	public void setPdname(String pdname) {
		this.pdname = pdname;
	}
	public String getQprpdid() {
		return qprpdid;
	}
	public void setQprpdid(String qprpdid) {
		this.qprpdid = qprpdid;
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
	
	public String getCustomDate() {
		return customDate;
	}

	public void setCustomDate(String customDate) {
		this.customDate = customDate;
	}

	public String getPeriodType() {
		return periodType;
	}

	public void setPeriodType(String periodType) {
		this.periodType = periodType;
	}

	public String getQjhour() {
		return qjhour;
	}

	public void setQjhour(String qjhour) {
		this.qjhour = qjhour;
	}

	public String getQjminute() {
		return qjminute;
	}

	public void setQjminute(String qjminute) {
		this.qjminute = qjminute;
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

	public String getQjtricron() {
		return qjtricron;
	}

	public void setQjtricron(String qjtricron) {
		this.qjtricron = qjtricron;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
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
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}

	/**
	 * 删除资产时pieid计数标识取得
	 * @return 删除资产时pieid计数标识
	 */
	public Integer getCountx() {
		return countx;
	}

	/**
	 * 删除资产时pieid计数标识设定
	 * @param countx 删除资产时pieid计数标识
	 */
	public void setCountx(Integer countx) {
		this.countx = countx;
	}
}
